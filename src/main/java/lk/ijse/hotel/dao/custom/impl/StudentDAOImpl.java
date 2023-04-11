package lk.ijse.hotel.dao.custom.impl;

import lk.ijse.hotel.dao.custom.StudentDAO;
import lk.ijse.hotel.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public Student save(Session session, Student entity) {
        session.save(entity);
        return entity;
    }

    @Override
    public Student update(Session session, Student entity) {
        session.update(entity);
        return entity;
    }

    @Override
    public boolean delete(Session session, String id) {
        final Student student = session.get(Student.class, id);
        session.delete(student);
        return student!=null;
    }

    @Override
    public List<Student> getAll(Session session) {
        final Query query = session.createQuery("FROM Student");
        query.setCacheable(true);
        return (List<Student>) query.getResultList();

    }

    @Override
    public Student search(Session session, String id) {
       return session.get(Student.class,id);
    }

    @Override
    public String generateID(Session session) {
        final Query query = session.createQuery("FROM Student ORDER BY studentID DESC");
        query.setCacheable(true);
        final List<Student> list = query.getResultList();
        return list.size()==0 ? null:list.get(0).getStudentID();
    }
}
