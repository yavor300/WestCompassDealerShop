package springboot.vehicles.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springboot.vehicles.domain.models.binding.UserRegisterBindingModel;
import springboot.vehicles.domain.models.service.UserServiceModel;
import springboot.vehicles.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterSeller() {
        return super.view("register");
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute(name = "model") UserRegisterBindingModel model) {
        this.userService.register(modelMapper.map(model, UserServiceModel.class));
        return super.redirect("/");
    }
}
