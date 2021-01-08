package springboot.vehicles.domain.models.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ModelAddBindingModel {
    private String brand;
    private String name;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
}
