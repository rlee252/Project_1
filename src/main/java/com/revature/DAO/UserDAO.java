package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dto.AddUserDTO;
import com.revature.dto.LoginDTO;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.exceptions.DatabaseException;

import com.revature.model.User;
import com.revature.model.UserRoles;
import com.revature.util.ConnectionUtil;
import com.revature.util.SessionUtility;

public class UserDAO {
	Session session = SessionUtility.getSessionFactory().openSession();

	public User getUserByUsernameAndPassword(LoginDTO loginDTO) throws  ClientNotFoundException, DatabaseException, SQLException {

		try (Session session = SessionUtility.getSessionFactory().openSession()) {
			 String userTest = loginDTO.getUsername();
			 String passTest = loginDTO.getPassword();
			 User username  = (User) session.createQuery("FROM User u WHERE u.username = ?1 AND u.password = ?2 ")
										   .setParameter(1, userTest)
										   .setParameter(2, passTest)
										   .getSingleResult();
			 System.out.println(username);
			 

				return username;
			
			
		} catch (NoResultException e) {
		throw new ClientNotFoundException("Client with username/password was not found.");
		}
	}

	public User addUser(AddUserDTO addUserDTO) {
		Transaction tx1 = session.beginTransaction();
	
		
		String username = addUserDTO.getUsername();
		String password = addUserDTO.getPassword();
		String firstname = addUserDTO.getFirstname();
		String lastname = addUserDTO.getLastname();
		String email = addUserDTO.getEmail();
		String role = addUserDTO.getRole();
		
		
		UserRoles userrole = new UserRoles(0, role);
		session.save(userrole);
		
		User userAdd = new User(0,userrole,username,password,firstname,lastname,email);
		session.save(userAdd);
		tx1.commit();
		return userAdd;
		

	}
}
