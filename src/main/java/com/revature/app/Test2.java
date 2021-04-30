package com.revature.app;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.User;

public class Test2 {

	public static void main(String[] args) {
		ReimbursementType reimType = new ReimbursementType(0,"food");
		
		ReimbursementStatus reimStat = new ReimbursementStatus(0,"pending");
		
		User user = new User(0,null,"iLoveBagels","password","John", "Jacobs", "johnjacobs@gmail.com");
		
		User user3 = new User(0,null,"newUser","password","Billy", "Mays", "bm@gmail.com");
		
		List<Reimbursement> reimb = new ArrayList<>();
		
		System.out.println("hereeeeeeeeeeeee!!!!!!!!!!");
		
	reimb.add(new Reimbursement(0, reimStat,reimType,user,user3, 100, "something to say", null, null));
	reimb.add(new Reimbursement(1, reimStat,reimType,user,user3, 1200, "food is good", null, null));
	
		for (Reimbursement r: reimb) {
			int id = ((Reimbursement) r).getReimbId();
			String description =  ((Reimbursement) r).getDescription();
			ReimbursementStatus reimbStat = ((Reimbursement) r).getReimbStatus();
			String status = reimbStat.getReimbStatus();
			int amount = ((Reimbursement) r).getReimbAmount();
			System.out.println(id +" " + description + " " + status + " " + amount);
			
			
		}
	}

}
