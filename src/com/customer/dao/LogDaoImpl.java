package com.customer.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.model.Log;

@Repository
public class LogDaoImpl implements LogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void log(Log log) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.getTransaction();
			session.save(log);
			transaction.commit();
			session.flush();
			session.close();
		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}

	}
}
