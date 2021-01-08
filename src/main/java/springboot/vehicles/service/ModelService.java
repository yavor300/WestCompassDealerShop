package springboot.vehicles.service;

import springboot.vehicles.domain.models.service.ModelServiceModel;

import java.util.Set;

public interface ModelService {
    ModelServiceModel add(ModelServiceModel modelServiceModel, String brandName);

    Set<ModelServiceModel> getAll();

    ModelServiceModel getByName(String name);
}
