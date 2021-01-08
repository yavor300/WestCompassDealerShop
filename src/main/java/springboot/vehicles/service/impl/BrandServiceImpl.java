package springboot.vehicles.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springboot.vehicles.domain.entities.Brand;
import springboot.vehicles.domain.models.service.BrandServiceModel;
import springboot.vehicles.repository.BrandRepository;
import springboot.vehicles.service.BrandService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;


    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandServiceModel add(BrandServiceModel brandServiceModel) {
        Optional<Brand> byName = brandRepository.findByName(brandServiceModel.getName());
        if (byName.isEmpty()) {
            brandServiceModel.setCreated(LocalDateTime.now());
            brandServiceModel.setModified(LocalDateTime.now());
            return modelMapper.map(brandRepository.saveAndFlush(modelMapper.map(brandServiceModel, Brand.class)), BrandServiceModel.class);
        }
        return null;
    }

    @Override
    public Set<BrandServiceModel> getAll() {
        return brandRepository.findAll()
                .stream()
                .map(b -> modelMapper.map(b, BrandServiceModel.class))
                .collect(Collectors.toSet());
    }
}
