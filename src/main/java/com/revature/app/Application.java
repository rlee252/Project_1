package com.revature.app;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Controller;
import com.revature.controller.ExceptionMapper;
import com.revature.controller.LoginController;
import com.revature.controller.StaticFileController;
import com.revature.util.ConnectionUtil;

import io.javalin.Javalin;

public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		Javalin app = Javalin.create((config)->{
			config.addStaticFiles("static");
		});
		
		mapControllers(app, new LoginController(), new ExceptionMapper(), new StaticFileController());
		
	//See if database is connected
//		try {
//			Connection connection =  ConnectionUtil.getConnection();
//			System.out.println(connection);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 

	
		
		app.start(7000);
	}
	
	private static void mapControllers(Javalin app, Controller... controllers) {
		for (Controller c: controllers) {
			c.mapEndpoints(app);
		}
	}
	
	
}
