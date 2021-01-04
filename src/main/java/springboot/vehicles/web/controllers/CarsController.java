package springboot.vehicles.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.vehicles.repository.OfferRepository;

@Controller
@RequestMapping("/cars")
public class CarsController extends BaseController {
    private final OfferRepository offerRepository;

    @Autowired
    public CarsController(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @GetMapping("/all")
    public ModelAndView getAllCars(ModelAndView modelAndView) {
        modelAndView.addObject("offers", offerRepository.findAll());
        return super.view("all", modelAndView);
    }
}
