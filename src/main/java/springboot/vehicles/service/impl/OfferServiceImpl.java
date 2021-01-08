package springboot.vehicles.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.vehicles.domain.entities.EngineType;
import springboot.vehicles.domain.entities.Offer;
import springboot.vehicles.domain.entities.TransmissionType;
import springboot.vehicles.domain.models.binding.OfferAddBindingModel;
import springboot.vehicles.domain.models.service.OfferServiceModel;
import springboot.vehicles.repository.OfferRepository;
import springboot.vehicles.service.ModelService;
import springboot.vehicles.service.OfferService;
import springboot.vehicles.service.UserService;

import java.time.LocalDateTime;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelService modelService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ModelService modelService, UserService userService, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelService = modelService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public OfferServiceModel add(OfferAddBindingModel offerAddBindingModel) {
        OfferServiceModel offerServiceModel = modelMapper.map(offerAddBindingModel, OfferServiceModel.class);
        offerServiceModel.setEngine(EngineType.valueOf(offerAddBindingModel.getEngine().toUpperCase()));
        offerServiceModel.setTransmission(TransmissionType.valueOf(offerAddBindingModel.getTransmission().toUpperCase()));
        offerServiceModel.setCreated(LocalDateTime.now());
        offerServiceModel.setModified(LocalDateTime.now());
        offerServiceModel.setModel(modelService.getByName(offerAddBindingModel.getModel()));
        offerServiceModel.setSeller(userService.getByUsername(offerAddBindingModel.getUsername()));

        Offer offer = modelMapper.map(offerServiceModel, Offer.class);

        return modelMapper.map(offerRepository.saveAndFlush(offer), OfferServiceModel.class);
    }
}
