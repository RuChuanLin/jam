package _02_transaction.model;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;
import _01_member.model.Member;

public class UsedItemHBN implements UsedItemDAO {

	@Override
	public int saveItem(UsedItem uim) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(uim);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int savePic(UsedItemPic uip) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(uip);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int[] getAllpage(String key) {
		int msg[] = new int[2];
		String hql = "select count(*) from UsedItem where title like :key && onSale in :onSale";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("key", "%" + key + "%");
			q.setParameter("onSale", "(0,1)");
			msg[1] = (int) q.getSingleResult();
			msg[2] = (int) Math.ceil(msg[1] / 12);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public List<UsedItem> getAllItem(String key, int page) {
		String hql = "from UsedItem where title like :key && onSale in :onSale order by updatedDate desc";
		List<UsedItem> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<UsedItem> q = session.createQuery(hql);
			q.setParameter("key", "%" + key + "%");
			q.setParameter("onSale", "(0,1)");
			q.setFirstResult((page - 1) * 12);
			q.setMaxResults(12);
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
	public String[] getName(int seller) {
		String hql = "from Member where userId = :userId";
		Member mb = null;
		String[] name = new String[2];
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", seller);
			mb = (Member) q.getSingleResult();
			name[0] = mb.getAccount();
			name[1] = mb.getAlias();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return name;
	}

	@Override
	public int getNewId(int seller) {
		int itemId = 0;
		String hql = "select usedItemId from UsedItem where seller = :seller order by usedItemId desc";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("seller", seller);
			q.setMaxResults(1);
			itemId = (int) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return itemId;
	}

	@Override
	public String getFirstPic(int itemId) {
		String pic = null;
		String hql = "select picBase64 from UsedItemPic where itemId = :itemId && picOrder = 1";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("itemId", itemId);
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
	public UsedItem getItem(int itemId) {
		UsedItem ui = null;
		String hql = "from UsedItem where itemId = :itemId ";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("itemId", itemId);
			q.setMaxResults(1);
			ui = (UsedItem) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return ui;
	}

	@Override
	public List<String> getAllPic(int itemId) {
		String hql = "select picBase64 from UsedItemPic where itemId = :itemId";
		List<String> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<String> q = session.createQuery(hql);
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
	public int updateItem(UsedItem uim) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			session.update(uim);
			updateNumber++;
			System.out.println("updateNumber: " + updateNumber);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateNumber;
	}

	@Override
	public int updatePic(int itemId, String[] pic) {
		String updatahql = "update UsedItemPic set picBase64=:pic where itemId=:itemId && picOrder=:picOrder";
		String deletehql = "delete UsedItemPic where itemId=:itemId && picOrder=:picOrder";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			Query q = null;
			for (int i = 0; i < pic.length; i++) {
				if (pic[i].trim().length() != 0) {
					q = session.createQuery(updatahql);
					q.setParameter("pic", pic[i]);
					q.setParameter("itemId", itemId);
					q.setParameter("picOrder", i + 1);
					q.executeUpdate();
					updateNumber++;
				} else {
					q = session.createQuery(deletehql);
					q.setParameter("itemId", itemId);
					q.setParameter("picOrder", i + 1);
					q.executeUpdate();
					updateNumber++;
				}
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateNumber;
	}

	@Override
	public int offItem(int itemId, byte onSale) {
		String hql = "update UsedItem set onSale=:onSale where itemId=:itemId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("onSale", onSale);
			q.setParameter("itemId", itemId);
			updateNumber = q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateNumber;
	}

	@Override
	public int newBid(BidRecord br) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(br);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public List<BidRecord> getBid(int itemId) {
		String hql = "from BidRecord where itemId = :itemId";
		List<BidRecord> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<BidRecord> q = session.createQuery(hql);
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

}
