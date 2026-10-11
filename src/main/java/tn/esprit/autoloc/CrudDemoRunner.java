package tn.esprit.autoloc;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IAgenceService;
import tn.esprit.autoloc.service.IVehiculeService;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class CrudDemoRunner implements CommandLineRunner {

    private IAgenceService agenceService;
    private IVehiculeService vehiculeService;

    @Override
    public void run(String... args) {

        // CREATE : une agence puis un véhicule
        Agence agence = new Agence();
        agence.setNom("AutoLoc Tunis");
        agence.setVille("Tunis");
        agence = agenceService.addAgence(agence);

        Vehicule vehicule = new Vehicule();
        vehicule.setImmatriculation("123 TUN 4567");
        vehicule.setMarque("Renault");
        vehicule.setModele("Clio");
        vehicule.setCategorie(CategorieVehicule.CITADINE);
        vehicule.setTarifJournalier(new BigDecimal("80.00"));
        vehicule.setStatut(StatutVehicule.DISPONIBLE);
        vehicule.setAgence(agence);
        vehicule = vehiculeService.addVehicule(vehicule);

        // READ
        System.out.println("Nombre de vehicules : " + vehiculeService.retrieveAllVehicules().size());
        System.out.println("Vehicule trouve : " + vehiculeService.retrieveVehicule(vehicule.getIdVehicule()).getMarque());
        System.out.println("Nombre d'agences : " + agenceService.retrieveAllAgences().size());

        // UPDATE
        vehicule.setStatut(StatutVehicule.LOUE);
        vehiculeService.updateVehicule(vehicule);

        // DELETE : le véhicule d'abord (il référence l'agence), puis l'agence
        vehiculeService.removeVehicule(vehicule.getIdVehicule());
        agenceService.removeAgence(agence.getIdAgence());
    }
}
