package com.revature.DAO;

import java.sql.Blob;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

	public List<Reimbursement> getAllReimb(User user) {
		Session session = SessionUtility.getSessionFactory().openSession();
		
		List<Reimbursement> reimb = session.createQuery("FROM Reimbursement r")
										   .getResultList();
		
		return reimb;
	}

	public List<Reimbursement> getReimb2(User user) {
		Session session = SessionUtility.getSessionFactory().openSession();
		
		List<Reimbursement> reimb = session.createQuery("FROM Reimbursement r")
										   .getResultList();
	
		
		return reimb;
	}





}
