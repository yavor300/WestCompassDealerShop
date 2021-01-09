package springboot.vehicles.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springboot.vehicles.domain.models.binding.OfferAddBindingModel;
import springboot.vehicles.repository.OfferRepository;
import springboot.vehicles.service.ModelService;
import springboot.vehicles.service.OfferService;
import springboot.vehicles.service.UserService;

@Controller
@RequestMapping("/offers")
public class OfferController extends BaseController {
    private final OfferService offerService;
    private final ModelService modelService;
    private final UserService userService;

    @Autowired
    public OfferController(OfferService offerService, OfferRepository offerRepository, ModelService modelService, UserService userService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelService = modelService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public ModelAndView addOffer(ModelAndView modelAndView) {
        modelAndView.addObject("models", modelService.getAll());
        modelAndView.addObject("users", userService.getAll());
        return super.view("offer-add", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addOfferConfirm(@ModelAttribute(name = "model") OfferAddBindingModel model) {
        offerService.add(model);
        return super.redirect("/");
    }

    @GetMapping("/all")
    public ModelAndView getAllCars(ModelAndView modelAndView) {
        modelAndView.addObject("offers", offerService.getAll());
        return super.view("all", modelAndView);
    }

    @GetMapping("/details/{id}")
    public ModelAndView offerDetails(@PathVariable String id, ModelAndView modelAndView) {
        modelAndView.addObject("offer", offerService.getById(id));
        return super.view("details", modelAndView);
    }
}
