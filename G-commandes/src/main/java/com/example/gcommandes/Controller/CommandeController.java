package com.example.gcommandes.Controller;

import com.example.gcommandes.Dto.CommandeRequest;
import com.example.gcommandes.Service.CommandeSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommandeController {
    private final CommandeSerivce commandeSerivce;

    public CommandeController(CommandeSerivce commandeSerivce) {
        this.commandeSerivce = commandeSerivce;
    }
    @PostMapping("/store/commandes")
    public String createCommande(@RequestParam Long clientId, @RequestParam String nom) {
        commandeSerivce.create(new CommandeRequest(clientId, nom));
        return "redirect:/store/home/reload?clientId=" + clientId;
    }

}
