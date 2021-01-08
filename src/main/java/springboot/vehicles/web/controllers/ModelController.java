package springboot.vehicles.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.vehicles.domain.models.binding.ModelAddBindingModel;
import springboot.vehicles.domain.models.binding.UserRegisterBindingModel;
import springboot.vehicles.domain.models.service.ModelServiceModel;
import springboot.vehicles.service.BrandService;
import springboot.vehicles.service.ModelService;

@Controller
@RequestMapping("/models")
public class ModelController extends BaseController {
    private final BrandService brandService;
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelController(BrandService brandService, ModelService modelService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView addModel(ModelAndView modelAndView) {
        modelAndView.addObject("brands", brandService.getAll());
        return super.view("model-add", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addModelConfirm(@ModelAttribute(name = "model") ModelAddBindingModel model) {
        modelService.add(modelMapper.map(model, ModelServiceModel.class), model.getBrand());
        return super.redirect("/");
    }
}
