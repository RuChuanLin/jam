package _04_band.model;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;
import _01_member.model.Member;

public class BandHBN implements BandDAO {

	@Override
	public int saveBand(Band band) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(band);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return updateCount;
	}

	@Override
	public long[] getAllpage(String key) {
		long msg[] = new long[2];
		String hql = "select count(*) from Band " + "where category like :key or area like :key or "
				+ "style like :key or title like :key ";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("key", "%" + key + "%");
			msg[0] = (long) q.getSingleResult();
			msg[1] = (long) Math.ceil(msg[0] / 12.0);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return msg;
	}

	@Override
	public List<Band> getAllItem(String key, int page) {
		String hql = "from Band where category like :key or area like :key or " + "style like :key or title like :key ";
		List<Band> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<Band> q = session.createQuery(hql);
			q.setParameter("key", "%" + key + "%");
			q.setFirstResult(page * 12);
			q.setMaxResults(12);
			list = q.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Band getItem(int bandId) {
		Band band = null;
		String hql = "from Band where bandId = :bandId ";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("bandId", bandId);
			band = (Band) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return band;
	}

	@Override
	public int updateBand(Band band) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			session.update(band);
			updateNumber++;
			System.out.println("updateNumber: " + updateNumber);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return updateNumber;
	}

	@Override
	public int offBand(int bandId) {
		String hql = "update Band set bandStatus = false where bandId=:bandId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("bandId", bandId);
			updateNumber = q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}
		return updateNumber;
	}

}
