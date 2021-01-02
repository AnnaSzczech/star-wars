package star.wars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import star.wars.model.api.CharacterDescription;
import star.wars.model.api.Response;
import star.wars.service.StarWarsService;

@RestController
@RequestMapping()
public class StarWarsController {

    @Autowired
    private StarWarsService starWarsService;

    @GetMapping(value = "/characters")
    public Response getCharacters(@RequestParam(name = "page") Long pageNumber){
        return starWarsService.getCharacters(pageNumber);
    }

    @GetMapping(value = "/characters/{id}")
    public CharacterDescription getCharacter(@PathVariable(name = "id") Long id){
        return starWarsService.getCharacter(id);
    }
}
