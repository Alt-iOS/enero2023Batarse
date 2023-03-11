package com.mayab.desarrollo.persistence;

import com.mayab.desarrollo.entities.Usuario;
import org.hibernate.Session;
import com.mayab.desarrollo.main.HibernateUtil;
import java.util.List;

public class UserDAO implements IUserDAO{
    @Override
    public List<Usuario> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> list = session.createQuery("from Usuario").list();
        HibernateUtil.shutdown();
        return list;
    }

    @Override
    public int createUser(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (int) session.save(usuario);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return id;
    }

    @Override
    public boolean deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario u = session.get(Usuario.class, id);
        session.delete(u);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return true;
    }

    @Override
    public Usuario findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario u = session.get(Usuario.class, id);
        HibernateUtil.shutdown();
        return u;
    }

    @Override
    public Usuario updatePass(Usuario usuario, String NContra) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Usuario toUpdate = session.get(Usuario.class, usuario.getId());
        toUpdate.setPassword(NContra);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        return toUpdate;
    }
}
