package springboot.vehicles.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.vehicles.domain.entities.Brand;
import springboot.vehicles.domain.entities.Model;
import springboot.vehicles.domain.models.service.BrandServiceModel;
import springboot.vehicles.domain.models.service.ModelServiceModel;
import springboot.vehicles.repository.BrandRepository;
import springboot.vehicles.repository.ModelRepository;
import springboot.vehicles.service.BrandService;
import springboot.vehicles.service.ModelService;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService, BrandRepository brandRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelServiceModel add(ModelServiceModel modelServiceModel, String brandName) {
        Brand brand = brandRepository.findByName(brandName).get();
        modelServiceModel.setCreated(LocalDateTime.now());
        modelServiceModel.setModified(LocalDateTime.now());
        Model model = modelMapper.map(modelServiceModel, Model.class);
        model.setBrand(brand);
        return modelMapper.map(modelRepository.saveAndFlush(model), ModelServiceModel.class);
    }

    @Override
    public Set<ModelServiceModel> getAll() {
        return modelRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, ModelServiceModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public ModelServiceModel getByName(String name) {
        return modelMapper.map(modelRepository.findByName(name), ModelServiceModel.class);
    }
}
