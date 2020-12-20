package pl.anril.spring5webapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pl.anril.spring5webapp.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorRepository authorRepository;
    
    @RequestMapping(value="/authors")
    public String getAuthors (Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }
    
}
