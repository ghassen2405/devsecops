package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    @Autowired
    BlocRepository blocRepository;
    FoyerRepository foyerRepository;
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }
    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }
    public void removeBloc(Long blId) {
        blocRepository.deleteById(blId);
    }
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
    public Bloc createBlocWithFoyer(Bloc bloc){
        return blocRepository.save(bloc);
    }

    public Bloc assignBlocToFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc not found"));
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(() -> new RuntimeException("Foyer not found"));
        bloc.setFoyer(foyer);
        return blocRepository.save(bloc);
    }
    public Bloc unassignBlocFromFoyer(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(() -> new RuntimeException("Bloc not found"));
        bloc.setFoyer(null);
        return blocRepository.save(bloc);
    }
}


