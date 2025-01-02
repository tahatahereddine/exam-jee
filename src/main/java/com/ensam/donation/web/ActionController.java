package com.ensam.donation.web;

import com.ensam.donation.dao.entities.EtatAction;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.ensam.donation.dto.ActionDto;
import com.ensam.donation.dto.DonDto;
import com.ensam.donation.service.IActionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ActionController {

    private final IActionService actionService;

    @GetMapping({"/" , "/index"})
    public String start() {
        return "index";
    }

    @GetMapping("/actions")
    public String listerActions(Model model) {
        List<ActionDto> actions = actionService.getActions();
        model.addAttribute("actions", actions);
        return "actions";
    }

    @GetMapping("/ajouterAction")
    public String afficherFormulaireAjoutAction(Model model) {
        model.addAttribute("action", new ActionDto());
        model.addAttribute("etat", EtatAction.values());
        return "ajouterAction";
    }

    @PostMapping("/ajouterAction")
    public String ajouterAction(@Valid @ModelAttribute("action") ActionDto actionDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "ajouterAction";
        }
        actionService.addAction(actionDto);
        return "redirect:/actions";
    }

    @GetMapping("/voirDons")
    public String afficherFormulaireVoirDons(Model model) {
        List<ActionDto> actions = actionService.getActions();
        model.addAttribute("actions", actions);
        return "voirDons";
    }

    @GetMapping("/dons")
    public String afficherDonsParAction(@RequestParam("actionId") Integer actionId, Model model) {
        List<DonDto> dons = actionService.getDonsOfActionById(actionId);
        model.addAttribute("dons", dons);
        return "dons";
    }
}
