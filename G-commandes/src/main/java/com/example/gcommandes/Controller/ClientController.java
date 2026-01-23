package com.example.gcommandes.Controller;

import com.example.gcommandes.Dto.ClientRequestDto;
import com.example.gcommandes.Dto.ClientResponseDto;
import com.example.gcommandes.Entity.Commande;
import com.example.gcommandes.Service.ClientService;
import com.example.gcommandes.Service.CommandeSerivce;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/store/home")
public class ClientController {
    private final ClientService clientService;
    private final CommandeSerivce commandeSerivce;

    public ClientController(ClientService clientService, CommandeSerivce commandeSerivce) {
        this.clientService = clientService;
        this.commandeSerivce = commandeSerivce;
    }

    @GetMapping()
    public ModelAndView Home() {
        return new ModelAndView("SignIn");
    }

    @GetMapping("inscription")
    public ModelAndView SignUp() {
        return new ModelAndView("SignUp");
    }

    @PostMapping("/inscription")
    public RedirectView createClient(ClientRequestDto clientRequestDto) {
        clientService.createClient(clientRequestDto);
        return new RedirectView("/store/home");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String mdp, HttpSession session) {
        ClientResponseDto client = clientService.login(email, mdp);
        session.setAttribute("client", client);
        List<Commande> commandes = commandeSerivce.getAllCommandesByClient(client.getId());
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("client", client);
        mv.addObject("commandes", commandes);
        return mv;
    }
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        return new RedirectView("/store/home");
    }
    @GetMapping("/reload")
    public ModelAndView reloadHome(@RequestParam Long clientId) {
        ClientResponseDto client = clientService.getById(clientId);
        List<Commande> commandes = commandeSerivce.getAllCommandesByClient(clientId);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("client", client);
        mv.addObject("commandes", commandes);
        return mv;
    }

}
