package lk.ijse.hotel.dao.custom.impl;

import lk.ijse.hotel.dao.custom.ReservationDAO;
import lk.ijse.hotel.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public Reservation save(Session session, Reservation entity) {
        session.save(entity);
        return entity;
    }

    @Override
    public Reservation update(Session session, Reservation entity) {
        session.update(entity);
        return entity;
    }

    @Override
    public boolean delete(Session session, String id) {
        final Reservation reservation = session.get(Reservation.class, id);
        session.delete(reservation);
        return reservation!=null;
    }

    @Override
    public List<Reservation> getAll(Session session) {
        final Query query = session.createQuery("FROM Reservation");
        query.setCacheable(true);
        return (List<Reservation>)query.getResultList();
    }

    @Override
    public Reservation search(Session session, String id) {
        return session.get(Reservation.class,id);
    }

    @Override
    public String generateID(Session session) {
        final Query query = session.createQuery("FROM Reservation ORDER BY resID DESC");
        query.setCacheable(true);
        final List<Reservation> resultList =query.getResultList();
            return resultList.size()==0 ? null:resultList.get(0).getResID();
    }
}
