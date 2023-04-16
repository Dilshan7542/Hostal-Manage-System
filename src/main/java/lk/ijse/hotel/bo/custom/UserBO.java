package lk.ijse.hotel.bo.custom;

import lk.ijse.hotel.bo.SuperBO;
import lk.ijse.hotel.dto.UserDTO;
import org.hibernate.Session;

import java.util.List;

public interface UserBO extends SuperBO {
    UserDTO saveUser(UserDTO userDTO) throws Exception;
    UserDTO updateUser(UserDTO userDTO) throws Exception;
    boolean deleteUser(String id) throws Exception;
    List<UserDTO> getAllUser() throws Exception;
    UserDTO searchUser(String id) throws Exception;
    String generateIDUser() throws Exception;
}
