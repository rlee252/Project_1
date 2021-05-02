package com.revature.app;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.dto.ReimbViewDTO;
import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.User;
import com.revature.util.SessionUtility;

public class Test2 {

	public static void main(String[] args) {
		Session session = SessionUtility.getSessionFactory().openSession();
		
		List<Reimbursement> reimb = session.createQuery("FROM Reimbursement r")
										   .getResultList();
	
	List<ReimbViewDTO> reimbViewDTO = new ArrayList<>();
	
	for (Reimbursement r: reimb) {
		int id = ((Reimbursement) r).getReimbId();
		
	//	String description =  ((Reimbursement) r).getDescription();
		
	//	ReimbursementStatus reimbStat = ((Reimbursement) r).getReimbStatus();
	//	String status = reimbStat.getReimbStatus();
		
	//	ReimbursementType reimbType = ((Reimbursement) r).getReimbType();
	//	String type = reimbType.getReimbType();
		
	//	int amount = ((Reimbursement) r).getReimbAmount();
		
	//	Timestamp created = ((Reimbursement) r).getCreatedOn();
		
	//	Blob reimbReceipt =  ((Reimbursement) r).getReceipt();
		
		//System.out.println(r);
		
		//ReimbViewDTO viewDTO = new ReimbViewDTO();
		//viewDTO.setCreatedOn(created);
		//viewDTO.setDescription(description);
		//viewDTO.setReceipt(reimbReceipt);
		//viewDTO.setReimbAmount(amount);
		//viewDTO.setReimbId(id);
		//viewDTO.setReimbStatus(status);
		//viewDTO.setReimbType(type);
		
		//reimbViewDTO.add(viewDTO);
	}
	//System.out.println(reimbViewDTO);
}

}
