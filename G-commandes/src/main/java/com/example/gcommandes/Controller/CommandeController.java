package com.example.gcommandes.Controller;

import com.example.gcommandes.Dto.CommandeRequest;
import com.example.gcommandes.Entity.Commande;
import com.example.gcommandes.Entity.LigneCommande;
import com.example.gcommandes.Service.CommandeSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/store/commandes")
public class CommandeController {
    private final CommandeSerivce commandeSerivce;

    public CommandeController(CommandeSerivce commandeSerivce) {
        this.commandeSerivce = commandeSerivce;
    }

    @PostMapping
    public String createCommande(@RequestParam Long clientId, @RequestParam String nom) {
        commandeSerivce.create(new CommandeRequest(clientId, nom));
        return "redirect:/store/home/reload?clientId=" + clientId;
    }

    @PostMapping("/{commandeId}/ligne-commande/add")
    public String addLigneCommande(@PathVariable Long commandeId, @ModelAttribute LigneCommande ligneCommande) {
        commandeSerivce.addLigneCommandeToCommande(ligneCommande, commandeId);
        return "redirect:/store/commandes/" + commandeId;
    }

    @PostMapping("/{commandeId}/ligne-commande/remove")
    public String removeLigneCommande(@PathVariable Long commandeId, @RequestParam Long ligneCommandeId) {
        commandeSerivce.removeLigneCommandeFromCommande(ligneCommandeId, commandeId);
        return "redirect:/store/commandes/" + commandeId;
    }

    @GetMapping("/{id}")
    public ModelAndView commandeDetails(@PathVariable Long id) {
        Commande commande = commandeSerivce.getCommandeById(id);
        ModelAndView mv = new ModelAndView("commande/details");
        mv.addObject("commande", commande);
        mv.addObject("ligneCommande", new LigneCommande());
        return mv;
    }


}
