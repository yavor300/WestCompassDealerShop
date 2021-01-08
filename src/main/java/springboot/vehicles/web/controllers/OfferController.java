package springboot.vehicles.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.vehicles.domain.models.binding.OfferAddBindingModel;
import springboot.vehicles.domain.models.service.OfferServiceModel;
import springboot.vehicles.service.ModelService;
import springboot.vehicles.service.OfferService;
import springboot.vehicles.service.UserService;

@Controller
@RequestMapping("/offers")
public class OfferController extends BaseController {
    private final OfferService offerService;
    private final ModelService modelService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferController(OfferService offerService, ModelService modelService, UserService userService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelService = modelService;
        this.userService = userService;
        this.modelMapper = modelMapper;
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
}
