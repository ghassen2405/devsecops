package tn.esprit.tpfoyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversityRepository;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universityRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Université not found with id " + id));
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universityRepository.save(universite);
    }

    @Override
    public void removeUniversite(Long id) {
        if (!universityRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete: Université with id " + id + " not found.");
        }
        universityRepository.deleteById(id);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        if (!universityRepository.existsById(universite.getIdUniversite())) {
            throw new RuntimeException("Cannot update: Université with id " + universite.getIdUniversite() + " not found.");
        }
        return universityRepository.save(universite);
    }
}
