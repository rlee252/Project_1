package com.revature.DAO;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dto.FinanceManagerViewDTO;
import com.revature.dto.ReimbAddDTO;
import com.revature.dto.ReimbViewDTO;
import com.revature.model.Reimbursement;
import com.revature.model.ReimbursementStatus;
import com.revature.model.ReimbursementType;
import com.revature.model.User;
import com.revature.util.SessionUtility;

public class ReimbDAO {

	public List<Reimbursement> getReimb(User user2) {
		Session session = SessionUtility.getSessionFactory().openSession();
		int user = user2.getId();
		
		List<Reimbursement> reimb = session.createQuery("SELECT r FROM Reimbursement r JOIN r.reimbAuthor u WHERE u.id = ?1")
										   .setParameter(1, user)
										   .getResultList();
		
		
		return reimb;
	}

	public Reimbursement addReimb(ReimbAddDTO reimbAddDTO, User user) {
		Session session = SessionUtility.getSessionFactory().openSession();
		Transaction tx4 = session.beginTransaction();
		
		ReimbursementStatus reimStat = new ReimbursementStatus(0,"pending");
		session.save(reimStat);
		
		String reimbType = reimbAddDTO.getReimbType();
		ReimbursementType reimType = new ReimbursementType(0, reimbType);
		session.save(reimType);
		
		int amount = reimbAddDTO.getReimbAmount();
		String description = reimbAddDTO.getDescription();
		Blob receipt = reimbAddDTO.getReceipt();
		Reimbursement r = new Reimbursement(0,reimStat,reimType,user,null,amount,description,null,null);
		session.save(r);
		tx4.commit();
		
		return r;
	}

	public List<Reimbursement> getAllReimb() {
		Session session = SessionUtility.getSessionFactory().openSession();
		
		List<Reimbursement> reimb = session.createQuery("FROM Reimbursement r")
										   .getResultList();
		
		return reimb;
	}

	public List<ReimbViewDTO> getReimb2(User user) {
		int userId = user.getId();
		Session session = SessionUtility.getSessionFactory().openSession();
		
		List<Reimbursement> reimb = session.createQuery("SELECT r FROM Reimbursement r JOIN r.reimbAuthor u WHERE u.id = ?1")
				   .setParameter(1, userId)
				   .getResultList();
		List<ReimbViewDTO> reimbViewDTO = new ArrayList<>();
			
			for (Reimbursement r: reimb) {
				int id = ((Reimbursement) r).getReimbId();
				
				String description =  ((Reimbursement) r).getDescription();
				
				ReimbursementStatus reimbStat = ((Reimbursement) r).getReimbStatus();
				String status = reimbStat.getReimbStatus();
				
				ReimbursementType reimbType = ((Reimbursement) r).getReimbType();
				String type = reimbType.getReimbType();
				
				int amount = ((Reimbursement) r).getReimbAmount();
				
				Timestamp created = ((Reimbursement) r).getCreatedOn();
				
				Blob reimbReceipt =  ((Reimbursement) r).getReceipt();
				
					reimbViewDTO.add(new ReimbViewDTO(id, status,type,amount, description,null,null));
		
				}
			
			return reimbViewDTO;
	}

	public List<FinanceManagerViewDTO> getFinanceManagerView() {
Session session = SessionUtility.getSessionFactory().openSession();
		
		List<Reimbursement> reimb = session.createQuery("FROM Reimbursement r")
										   .getResultList();
		
		List<FinanceManagerViewDTO> financeManagerViewDTO = new ArrayList<>();
		
		for (Reimbursement r: reimb) {
			
			int userId = ((Reimbursement) r).getReimbAuthor().getId();
			String username = ((Reimbursement) r).getReimbAuthor().getUsername();
			String firstname = ((Reimbursement) r).getReimbAuthor().getFirstName();
			String lastname = ((Reimbursement) r).getReimbAuthor().getLastName();
			String email = ((Reimbursement) r).getReimbAuthor().getEmail();
			String role = ((Reimbursement) r).getReimbAuthor().getUserRole().getUserRole();
			
			//=========
			int id = ((Reimbursement) r).getReimbId();
			String description =  ((Reimbursement) r).getDescription();
			ReimbursementStatus reimbStat = ((Reimbursement) r).getReimbStatus();
			String status = reimbStat.getReimbStatus();	
			ReimbursementType reimbType = ((Reimbursement) r).getReimbType();
			String type = reimbType.getReimbType();
			int amount = ((Reimbursement) r).getReimbAmount();
			Timestamp created = ((Reimbursement) r).getCreatedOn();
			Blob reimbReceipt =  ((Reimbursement) r).getReceipt();
			
			ReimbViewDTO reimbView = new ReimbViewDTO(id, status,type,amount, description,null,null);
			
			financeManagerViewDTO.add(new FinanceManagerViewDTO(userId,username,firstname,lastname,email,role,reimbView));
			}
		
		return financeManagerViewDTO;
	}


}
