package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.service.IAgenceService;

@RestController
@RequestMapping("/agence")
@AllArgsConstructor
public class AgenceController {

    private IAgenceService agenceService;
}