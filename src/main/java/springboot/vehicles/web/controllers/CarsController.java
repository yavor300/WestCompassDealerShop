package springboot.vehicles.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cars")
public class CarsController {
    @GetMapping("/all")
    public ModelAndView getAllCars() {
        return new ModelAndView("all");
    }
}
