package springboot.vehicles.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.vehicles.domain.entities.EngineType;
import springboot.vehicles.domain.entities.TransmissionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OfferServiceModel {
    private String id;
    private String description;
    private EngineType engine;
    private String imageUrl;
    private Double mileage;
    private BigDecimal price;
    private TransmissionType transmission;
    private Integer year;
    private LocalDateTime created;
    private LocalDateTime modified;
    private ModelServiceModel model;
    private UserServiceModel seller;
}
