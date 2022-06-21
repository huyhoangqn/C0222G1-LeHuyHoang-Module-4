package mp3.model;

import javafx.beans.DefaultProperty;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "mp3")
public class Mp3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Song", columnDefinition = "Varchar (200)")
    private String name;
    @Column(name = "Singer", columnDefinition = "varchar(200)")
    private String singer;
    @Column(name = "Type", columnDefinition = "varchar(200)")
    private String typeSong;
    @Column(name = "Listen", columnDefinition = "varchar(200)")
    private String link;
    @Column(name = "status",columnDefinition = "bit")
    @ColumnDefault("0")
    private int status ;

    public Mp3() {
    }

    public Mp3(int id, String name, String singer, String typeSong, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.typeSong = typeSong;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
