package tn.esprit.tpfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.BlocServiceImpl;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    IBlocService blocService;
    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs dsqfgh
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }
    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blId) {
        Bloc bloc = blocService.retrieveBloc(blId);
        return bloc;
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc c) {
        Bloc bloc = blocService.addBloc(c);
        return bloc;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blId) {
        blocService.removeBloc(blId);
    }
    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        Bloc bloc = blocService.modifyBloc(c);
        return bloc;
    }
    @PutMapping("/affecter-bloc-a-un-foyer/{bloc-id}/{foyer-id}")
    public void affecterBlocAFoyer(@PathVariable("bloc-id") Long idBloc,
                                             @PathVariable("foyer-id") Long idFoyer) {
        blocService.assignBlocToFoyer(idBloc, idFoyer);
    }
    @PostMapping("/creer-bloc-avec-foyer")
    public Bloc createBlocWithFoyer(@RequestBody Bloc bloc) {
        return blocService.createBlocWithFoyer(bloc);
    }

    @PutMapping("/desaffecter-bloc-de-foyer/{blocId}")
    public void unassignBlocFromFoyer(@PathVariable("blocId") Long idBloc) {
        blocService.unassignBlocFromFoyer(idBloc);
    }


}


