package springboot.vehicles.service;

import springboot.vehicles.domain.entities.Brand;
import springboot.vehicles.domain.models.service.BrandServiceModel;

import java.util.Optional;
import java.util.Set;

public interface BrandService {
    BrandServiceModel add(BrandServiceModel brandServiceModel);

    Set<BrandServiceModel> getAll();
}
