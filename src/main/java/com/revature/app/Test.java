package com.revature.app;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.model.UserRoles;
import com.revature.util.SessionUtility;
import java.sql.Timestamp;
public class Test {

	public static void main(String[] args) {
		Session session = SessionUtility.getSessionFactory().openSession();

		//how to view 
		
//		User user1 = session.get(User.class, 5); // when we use .get() our user object is in the persistent state
//		System.out.println(user1);
		
//		Transaction tx = session.beginTransaction();
//		Reimbursement reim = new Reimbursement(0,"FOOD","PENDING",null);
//		session.save(reim);
//		reim.setUser(user); // I can actually set my reim to this particular user
//		tx.commit();
		
//		Reimbursement reim2 = session.get(Reimbursement.class, 2);
//		System.out.println(reim2);
		
//		Transaction tx = session.beginTransaction();
//		UserRoles userRole1 = new UserRoles(0,"Employee");
//		session.save(userRole1);
//		tx.commit();
		
		UserRoles ur1 = session.get(UserRoles.class,1);
		//System.out.println(ur1);
		
//		Transaction tx = session.beginTransaction();
//		User user = new User(0,null,"myUserName","password","Raymond", "Lee", "rlee252@gmail.com");
//		session.save(user);
//		user.setUserRole(ur1);
//		tx.commit();	
		
		User user2 = session.get(User.class, 2);
		System.out.println(user2);
	}

}
