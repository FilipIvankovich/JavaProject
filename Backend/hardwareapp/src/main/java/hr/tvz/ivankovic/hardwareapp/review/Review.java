package hr.tvz.ivankovic.hardwareapp.review;

import hr.tvz.ivankovic.hardwareapp.hardware.Hardware;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title;
    String content;
    Integer rating;
    String code;

    @ManyToOne
    @JoinColumn(name = "id_hardware")
    Hardware hardware;

    public Review(){}

    public Review(Long id, String title, String content, Integer rating) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
    }

    public String getCode() { return code; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
