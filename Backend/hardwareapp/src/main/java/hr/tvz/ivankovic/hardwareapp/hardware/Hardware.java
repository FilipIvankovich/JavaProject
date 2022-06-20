package hr.tvz.ivankovic.hardwareapp.hardware;

import hr.tvz.ivankovic.hardwareapp.review.Review;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "HARDWARE")
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

    @Column(name = "code")
     String code;

    @Column(name = "name")
     String name;

    @Column(name = "price")
     Double price;

    @Column(name = "type")
     String type;

    @Column(name = "availability")
     Integer availability;

    @OneToMany(mappedBy = "hardware", fetch = FetchType.EAGER)
    private List<Review> reviewList;

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Hardware(){}

    public Hardware(Long id, String code, String name, Double price, String type, Integer availability) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.type = type;
        this.availability = availability;
    }

    public Integer getAvailability() {
        return availability;
    }
    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public String  getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }
}
