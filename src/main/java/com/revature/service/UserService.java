package com.revature.service;

import com.revature.DAO.UserDAO;
import com.revature.dto.AddUserDTO;
import com.revature.model.User;

public class UserService {
	
	private static UserDAO userDAO;
	
	public UserService() {
		this.userDAO = new UserDAO();
	}
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public static User addUser(AddUserDTO addUserDTO) {
		
		User user = userDAO.addUser(addUserDTO);
		return user;
	}

}
