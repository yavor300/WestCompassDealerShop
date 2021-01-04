package springboot.vehicles.domain.models.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class BrandServiceModel {
    private String name;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Set<ModelServiceModel> models;
}
