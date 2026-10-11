package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private PaiementRepository paiementRepository;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement c) {
        return paiementRepository.save(c);
    }

    @Override
    public Paiement updatePaiement(Paiement c) {
        return paiementRepository.save(c);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {
        return paiementRepository.findById(idPaiement).orElse(null);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        paiementRepository.deleteById(idPaiement);
    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> paiements) {
        List<Paiement> saved = new ArrayList<>();
        for (Paiement c : paiements) {
            saved.add(paiementRepository.save(c));
        }
        return saved;
    }
}
