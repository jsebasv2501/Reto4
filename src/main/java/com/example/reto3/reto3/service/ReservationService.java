package com.example.reto3.reto3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reto3.reto3.model.Reservation;
import com.example.reto3.reto3.repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r){
        if(r.getIdReservation() == null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> mAux = reservationRepository.getReservation(r.getIdReservation());
            if(mAux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }

    public Reservation update(Reservation r){
        if(r.getIdReservation() != null){
            Optional<Reservation> rAux = reservationRepository.getReservation(r.getIdReservation());
            if(!rAux.isEmpty()){
                if(r.getStartDate() != null){
                    rAux.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate() != null){
                    rAux.get().setDevolutionDate(r.getDevolutionDate());
                }

                if(r.getStatus() !=null){
                    rAux.get().setStatus(r.getStatus());
                }

                if(r.getMachine() != null){
                    rAux.get().setMachine(r.getMachine());;
                }

                if(r.getClient() != null){
                    rAux.get().setClient(r.getClient());;
                }

                if(r.getScore() != null){
                    rAux.get().setScore(r.getScore());
                }
                reservationRepository.save(rAux.get());
                return rAux.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean deleteReservation(int id){
        Boolean aBoolean = getReservation(id).map(reservation -> {
            reservationRepository.borrar(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
