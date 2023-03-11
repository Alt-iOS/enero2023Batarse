package com.mayab.desarrollo.main;

import com.mayab.desarrollo.persistence.UserDAO;
import org.hibernate.Session;

import com.mayab.desarrollo.entities.Usuario;

public class Test {

	public static void main(String[] args) {
/*		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		//Add new user object
		Usuario user = new Usuario();
		user.setNombre("Usuario1");
		user.setPassword("password");
		user.setEmail("email@email.com");

		session.save(user);

		session.getTransaction().commit();
		HibernateUtil.shutdown();*/

		UserDAO dao= new UserDAO();
		Usuario user= new Usuario();
		//user.setNombre("USUARIO DAO");
		//user.setPassword("PasswordDAO");
		//user.setEmail("email@DAO.com");
		//int idUser=dao.createUser(user);
		//System.out.println("id ="+idUser);
		dao.deleteUser(2);

	}
}
