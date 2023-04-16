package lk.ijse.hotel.bo.custom;

import lk.ijse.hotel.bo.SuperBO;
import lk.ijse.hotel.dto.ReservationDTO;
import org.hibernate.Session;

import java.util.List;

public interface ReservationBO extends SuperBO {
    ReservationDTO saveReservation( ReservationDTO reservationDTO)throws Exception;
    ReservationDTO updateReservation(ReservationDTO reservationDTO)throws Exception;
    boolean deleteReservation(ReservationDTO reservationDTO)throws Exception;
    List<ReservationDTO> getAllReservation()throws Exception;
    ReservationDTO searchReservation(String id)throws Exception;
    String generateIDReservation()throws Exception;
}
