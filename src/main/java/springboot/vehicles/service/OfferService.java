package springboot.vehicles.service;

import springboot.vehicles.domain.models.binding.OfferAddBindingModel;
import springboot.vehicles.domain.models.service.OfferServiceModel;

import java.util.Set;

public interface OfferService {
    OfferServiceModel add(OfferAddBindingModel offerAddBindingModel);

    Set<OfferServiceModel> getAll();

    OfferServiceModel getById(String id);
}
