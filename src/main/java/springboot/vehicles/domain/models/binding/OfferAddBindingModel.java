package springboot.vehicles.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OfferAddBindingModel {
    private String model;
    private Integer year;
    private String engine;
    private Double mileage;
    private BigDecimal price;
    private String transmission;
    private String imageUrl;
    private String username;
    private String description;
}
