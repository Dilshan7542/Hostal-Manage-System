package lk.ijse.hotel.bo.custom;

import lk.ijse.hotel.bo.SuperBO;
import lk.ijse.hotel.dto.StudentDTO;
import org.hibernate.Session;

import java.util.List;

public interface StudentBO extends SuperBO {
    StudentDTO saveStudent(StudentDTO studentDTO)throws Exception;
    StudentDTO updateStudent(StudentDTO studentDTO)throws Exception;
    boolean deleteStudent(String id) throws  Exception;
    List<StudentDTO> getAllStudent()throws Exception;
    StudentDTO searchStudent(String id)throws Exception;
    String generateIDStudent()throws Exception;
}
