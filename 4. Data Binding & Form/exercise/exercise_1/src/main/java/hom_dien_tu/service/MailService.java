package hom_dien_tu.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("mail")
public class MailService implements IMailService {
    public List<String> languages() {
        List<String> languages = new ArrayList<>();
        languages.add("Vietnamese");
        languages.add("English");
        languages.add("Laos");
        languages.add("India");
        return languages;
    }

    public List<Integer> pageSizes() {
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(25);
        pageSizes.add(20);
        pageSizes.add(15);
        pageSizes.add(10);
        return pageSizes;
    }
}
