package hr.tvz.ivankovic.hardwareapp.hardware;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class HardwareCommand {
    private Long id;

    @NotBlank(message="Name must not be empty")
    private String name;

    @NotBlank(message="Code must not be empty")
    private String code;

    @PositiveOrZero(message="Availability must be greater than or equal to zero")
    private Double price;

    @NotNull(message="Type must not be empty")
    private String type;

    @PositiveOrZero(message="Availability must be greater than or equal to zero")
    private Integer stock;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public Double getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public Integer getStock() { return stock; }
}
