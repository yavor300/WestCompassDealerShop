package springboot.vehicles.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.vehicles.domain.models.binding.BrandAddBindingModel;
import springboot.vehicles.domain.models.service.BrandServiceModel;
import springboot.vehicles.service.BrandService;

@Controller
@RequestMapping("/brands")
public class BrandController extends BaseController {
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public ModelAndView addBrand() {
        return super.view("brand-add");
    }

    @PostMapping("/add")
    public ModelAndView addBrandConfirm(@ModelAttribute(name = "model") BrandAddBindingModel model) {
        brandService.add(modelMapper.map(model, BrandServiceModel.class));
        return super.redirect("/");
    }
}
