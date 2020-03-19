package dk.kea.spring_mvc.controller;

import dk.kea.spring_mvc.model.Animal;
import dk.kea.spring_mvc.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Animal anim){
        animalService.create(anim);
        return "redirect:/";
    }

    //use pathvariable to map id from list on web page
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model){
        //tilføj Animal med id til model view
        model.addAttribute("anim", animalService.read(id));
        return "update";
    }

    //update animal
    @PostMapping("/update")
    public String update(@ModelAttribute Animal anim){
        //update by using update service
        animalService.update(anim);
        return "redirect:/";
    }

    //delete animal
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model){
        animalService.delete(id);
        //burde fange returværdi fra kald og sende statusbesked med ud på websiden
        return "redirect:/";
    }
}
