package springboot.vehicles.service;

import springboot.vehicles.domain.models.binding.OfferAddBindingModel;
import springboot.vehicles.domain.models.service.OfferServiceModel;

public interface OfferService {
    OfferServiceModel add(OfferAddBindingModel offerAddBindingModel);
}
