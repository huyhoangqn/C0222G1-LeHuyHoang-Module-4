package com.codegym.config;

import com.codegym.repository.IMusicRepository;
import com.codegym.repository.MusicRepository;
import com.codegym.service.IMusicService;
import com.codegym.service.MusicService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.codegym.controller")
//Thằng này để tham chiếu đến file "resources/upload_file.properties"
@PropertySource("classpath:upload_file.properties")
public class AppConfig implements WebMvcConfigurer, ApplicationContextAware {
    //lấy giá trị
    @Value("${file-upload}")
    private String fileUpload;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext= applicationContext;
    }
//   Phải thêm thư viện thymleaf mới đọc dc
//        doi tuong
//            thuoc tinh 1 = gia tri 1
//            thuoc tinh 2 = gia tri 2
//    Đây thường chỉ dùng cho JSP
//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver(){
//        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".html");
//        return viewResolver;
//    }

    @Bean
    public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
//    @Bean
//    public IStudentService studentService(){
//        return new StudentService();
//    }
//    @Bean
//    public IStudentService studentService(){
//        return new StudentServiceJPA();
//    }

    //Cấu hình upload file
    //Cấu hình ra được nơi để lưu trữ file, cái cấu hình uploadfile
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + fileUpload);

    }
    //Bỏ name=multipartResolver vẫn dc
    @Bean(name = "multipartResolver")
    //CommonsMultipartResolver-> tức là chương trình sẽ hỗ trợ upload file
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(52428800);//set max file
        return resolver;
    }
    //Hết cấu hình upload file

    //Cấu hình CSDL- ORM
    //Chỉ ra cho thằng hibernate(triển khai orm) rằng tôi dùng MySQL5, các fields cho hibernate
    Properties additionalProperties(){
        Properties properties= new Properties();
        //Update thì nghĩa là thêm dữ liệu ở model -> sẽ thêm vào CSDL
        //Create thì sẽ tạo mới hoàn toàn, xác những cái cũ ở CSDL mỗi lần run lại tomcat
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
//        properties.setProperty("show_sql", "true");
        return properties;
    }

    //Cấp quyền cho app gọi được database này
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource= new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/music_20_09_21");
        dataSource.setUsername("root");
        dataSource.setPassword("dtk1051030073");
        return dataSource;
    }

    //Cấu hình các Entity để quản lý các Entity
    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory){
        return entityManagerFactory.createEntityManager();
    }

    //Nói cho biết là dự án tham chiếu đên object model nào
    //Cái này dùng cho hibernate
    //Quản lý các entity trong package com.codegym.model
//    @Bean
//    public LocalSessionFactoryBean sessionFactoryBean(){
//        LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
//        //Cái LocalSessionFactoryBean này quản lý đối tượng trong database, cần cấp datasoure cho nó
//        sessionFactoryBean.setDataSource(dataSource());
//        sessionFactoryBean.setPackagesToScan("com.codegym.model");
//        //cấu hính hibernate
//        sessionFactoryBean.setHibernateProperties(additionalProperties());
//        return sessionFactoryBean;
//    }


    //Hết cấu hình CSDL bài 5

    //Cấu hình cho JPA bài 6
    //Để method name là: entityManagerFactoryBean() -> LỖI
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em= new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.codegym.model");
        //Để HibernateJpaVendorAdapter jpaVendorAdapter là lỗi
        JpaVendorAdapter jpaVendorAdapter= new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }
    //Hỏi lại cái này dùng làm gì, các bài trc lại k có?
    //Quản lý các transaction
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public IMusicService iMusicService(){
        return new MusicService();
    }

    @Bean
    public IMusicRepository iMusicRepository(){
        return new MusicRepository();
    }

    //Hết bài 6

//    @Bean
//    public IStudentRepo studentRepo(){
//        return new StudentRepo();
//    }

}
