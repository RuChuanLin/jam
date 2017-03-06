package _999_test.tx.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;

public class TXDAO implements TX {

	public String saveObject(TXObject txo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(txo);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}
		return "success";

	}
	public String updateObject(TXObject txo) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			txo = (TXObject) session.get(TXObject.class, txo.getPk());
			txo.setNumber(654321);
			txo.setAccount("戈戈戈戈戈戈戈");
			
			session.update(txo);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			System.out.println(e.getMessage());
		}
		return "success";

	}
}
