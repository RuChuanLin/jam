package _02_transaction.model;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;

public class NewItemHBN implements NewItemDAO {

	@Override
	public long[] getAllpage(String key) {
		long msg[] = new long[2];
		String hql = "select count(*) from NewItem where category like :key";
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
		}
		return msg;
	}

	@Override
	public List<NewItem> getAllItem(String key, int page) {
		String hql = "from NewItem where category like :key order by newItemId desc";
		List<NewItem> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<NewItem> q = session.createQuery(hql);
			q.setParameter("key", "%" + key + "%");
			q.setFirstResult((page - 1) * 12);
			q.setMaxResults(12);
			list = q.getResultList();

			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getFirstPic(int itemId) {
		String pic = null;
		String hql = "select picBase64 from NewItemPic where itemId = :itemId ";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("itemId", itemId);
			q.setMaxResults(1);
			pic = (String) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return pic;
	}

	@Override
	public NewItem getItem(int itemId) {
		NewItem ni = null;
		String hql = "from NewItem where newItemId = :itemId ";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("itemId", itemId);
			q.setMaxResults(1);
			ni = (NewItem) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return ni;
	}

	@Override
	public List<NewItemPic> getAllPic(int itemId) {
		String hql = "from NewItemPic where itemId = :itemId";
		List<NewItemPic> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<NewItemPic> q = session.createQuery(hql);
			q.setParameter("itemId", itemId);
			list = q.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return list;
	}

	@Override
	public int getNewId() {
		int id = -1;
		String hql = "select max(ni.newItemId) from NewItem ni";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setMaxResults(1);
			id = (int) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return id;
	}

	@Override
	public void saveNewPic(NewItemPic nip) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(nip);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void saveNewItem(NewItem newItem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(newItem);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}

	}

}
