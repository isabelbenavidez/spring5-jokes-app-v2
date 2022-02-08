package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    //@Autowired Con el autowired, spring inyectará el JokeController, pero en este caso podemos omitirlo, por usar la inyección con un único constructor
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""}) //MODELO
    public String showJoke(Model model){
      model.addAttribute("joke", jokeService.getJoke());
      return "index";
    }
}
