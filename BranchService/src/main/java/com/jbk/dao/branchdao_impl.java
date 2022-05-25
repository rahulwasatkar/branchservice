package com.jbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Branch;

@Repository
public class branchdao_impl implements branchdao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Branch savestudent(Branch branch) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(branch);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			session.close();

		}
		return branch;
	}

	@Override
	public Branch getstudent(String branchid) {
		Session session = sf.openSession();
		Branch branch = null;
		try {
			branch = session.get(Branch.class, branchid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return branch;
	}

}
