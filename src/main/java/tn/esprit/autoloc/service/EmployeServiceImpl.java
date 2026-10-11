package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private EmployeRepository employeRepository;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe addEmploye(Employe c) {
        return employeRepository.save(c);
    }

    @Override
    public Employe updateEmploye(Employe c) {
        return employeRepository.save(c);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return employeRepository.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    public List<Employe> addEmployes(List<Employe> employes) {
        List<Employe> saved = new ArrayList<>();
        for (Employe c : employes) {
            saved.add(employeRepository.save(c));
        }
        return saved;
    }
}
