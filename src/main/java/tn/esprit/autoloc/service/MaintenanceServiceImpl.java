package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.MaintenanceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private MaintenanceRepository maintenanceRepository;

    @Override
    public List<Maintenance> retrieveAllMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance addMaintenance(Maintenance c) {
        return maintenanceRepository.save(c);
    }

    @Override
    public Maintenance updateMaintenance(Maintenance c) {
        return maintenanceRepository.save(c);
    }

    @Override
    public Maintenance retrieveMaintenance(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance).orElse(null);
    }

    @Override
    public void removeMaintenance(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }

    @Override
    public List<Maintenance> addMaintenances(List<Maintenance> maintenances) {
        List<Maintenance> saved = new ArrayList<>();
        for (Maintenance c : maintenances) {
            saved.add(maintenanceRepository.save(c));
        }
        return saved;
    }
}
