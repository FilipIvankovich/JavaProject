package hr.tvz.ivankovic.hardwareapp.hardware;

import javax.persistence.criteria.CriteriaBuilder;

public class HardwareDTO {
    private final String name;
    private final String code;
    private Double price;
    private Integer availability;

    public HardwareDTO(String name, Double price, String code, Integer availability) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.availability = availability;
    }
    public String getName() {return name;}
    public String getCode() {
        return code;
    }
    public Integer getAvailability() {
        return availability;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice( Double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price + '$' +
                ", availability=" + availability +
                '}';
    }
}
