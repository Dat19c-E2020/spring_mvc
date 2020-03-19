package dk.kea.spring_mvc.controller;

import dk.kea.spring_mvc.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @Autowired
    AnimalService animalService;

    @GetMapping("/")
    public String index(Model model)
    {
        //add all animals to view model from animalService
        model.addAttribute("anim", animalService.readAll());
        return("index");
    }


}
