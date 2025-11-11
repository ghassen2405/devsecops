package tn.esprit.tpfoyer.service;
import tn.esprit.tpfoyer.entity.Bloc;
import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long blocId);
    public Bloc addBloc(Bloc c);
    public void removeBloc(Long blId);
    public Bloc modifyBloc(Bloc bloc);
    public Bloc assignBlocToFoyer(Long idBloc, Long idFoyer);
    public Bloc createBlocWithFoyer(Bloc bloc);
    public Bloc unassignBlocFromFoyer(Long idBloc);
// Here we will add later methods calling keywords and methods calling JPQL
}

