package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.service.IReservationService;

@RestController
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

    private IReservationService reservationService;
}