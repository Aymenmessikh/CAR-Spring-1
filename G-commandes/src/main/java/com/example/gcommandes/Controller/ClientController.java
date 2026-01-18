package com.example.gcommandes.Controller;

import com.example.gcommandes.Dto.ClientRequestDto;
import com.example.gcommandes.Dto.ClientResponseDto;
import com.example.gcommandes.Service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/store/home")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
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
    public ModelAndView login(@RequestParam String email, @RequestParam String mdp) {
        ClientResponseDto clientResponseDto = clientService.login(email, mdp);
        return new ModelAndView("home", "client", clientResponseDto);
    }

    @GetMapping("/logout")
    public RedirectView logout() {
        return new RedirectView("/store/home");
    }
}
