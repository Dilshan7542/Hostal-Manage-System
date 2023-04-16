package lk.ijse.hotel.dao.custom.impl;

import lk.ijse.hotel.dao.custom.CustomDAO;
import lk.ijse.hotel.entity.Custom;
import lk.ijse.hotel.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CustomDAOImpl implements CustomDAO {

    @Override
    public List<Custom> getAllReservationDetails(Session session) {
        final Query query = session.createQuery("SELECT r.resID,r.date,r.status,s.id,s.name,rm.roomID,rm.type,rm.key_money,rm.qty FROM Reservation as r INNER JOIN Room as rm ON r.room.roomID=rm.roomID INNER JOIN Student as s ON s.id=r.student.id");
        query.setCacheable(true);
        final List<Object[]> list = query.getResultList();
        List<Custom> customList=new ArrayList<>();
        for (Object[] o : list) {
            customList.add(new Custom(
                    (String)o[0],
                    (Date) o[1],
                    (String)o[2],
                    (String)o[3],
                    (String)o[4],
                    (String)o[5],
                    (String)o[6],
                    (String)o[7],
                    (Integer) o[8]

            ));
        }
        return customList;
    }
}
