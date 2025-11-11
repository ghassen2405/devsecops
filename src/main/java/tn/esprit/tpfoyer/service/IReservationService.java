package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(String id);
    Reservation addReservation(Reservation reservation);
    void removeReservation(String id);
    Reservation modifyReservation(Reservation reservation);
    //Reservation createReservationWithChambre(Reservation reservation);
}
