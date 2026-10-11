package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.service.IContratService;

@RestController
@RequestMapping("/contrat")
@AllArgsConstructor
public class ContratController {

    private IContratService contratService;
}