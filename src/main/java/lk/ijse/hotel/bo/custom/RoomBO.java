package lk.ijse.hotel.bo.custom;

import lk.ijse.hotel.bo.SuperBO;
import lk.ijse.hotel.dto.RoomDTO;
import org.hibernate.Session;

import java.util.List;

public interface RoomBO extends SuperBO {
    RoomDTO saveRoom(RoomDTO roomDTO)throws Exception;
    RoomDTO updateRoom(RoomDTO roomDTO)throws Exception;
    boolean deleteRoom(String id)throws  Exception;
    List<RoomDTO> getAllRoom()throws Exception;
    RoomDTO searchRoom(String id)throws Exception;
    String generateIDRoom()throws Exception;
}
