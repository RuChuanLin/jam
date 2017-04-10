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
	public long[] getAllpage(String key) {
		long msg[] = new long[2];
		String hql = "select count(*) from UsedItem where title like :key and onSale in (0,1)";
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
	public List<UsedItem> getAllItem(String key, int page) {
		String hql = "from UsedItem where title like :key and onSale in (0,1) order by usedItemId desc";
		List<UsedItem> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<UsedItem> q = session.createQuery(hql);
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
		String hql = "select picBase64 from UsedItemPic where itemId = :itemId ";
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
	public UsedItem getItem(int itemId) {
		UsedItem ui = null;
		String hql = "from UsedItem where usedItemId = :itemId ";
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
	public List<UsedItemPic> getAllPic(int itemId) {
		String hql = "from UsedItemPic where itemId = :itemId";
		List<UsedItemPic> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<UsedItemPic> q = session.createQuery(hql);
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
		List<UsedItemPic> listUIP = getAllPic(itemId);
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();

			for (int i = 0; i < pic.length; i++) {
				if (i < listUIP.size()) {
					UsedItemPic uip = listUIP.get(i);
					if (pic[i].trim().length() != 0) {

						uip.setPicBase64(pic[i]);
						session.update(uip);
						System.out.println(i);
						updateNumber++;
					} else {
						session.delete(uip);
						updateNumber++;
					}
				} else {
					if (pic[i].trim().length() != 0) {
						UsedItemPic uip = new UsedItemPic(itemId, pic[i]);
						session.save(uip);
						System.out.println(i);
						updateNumber++;
					}
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

	@Override
	public int cancelBid(int itemId, int bidder) {
		String hql = "DELETE FROM BidRecord where itemId = :itemId and bidder = :bidder";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		Query q = null;
		try {
			tx = session.beginTransaction();
			q = session.createQuery(hql);
			q.setParameter("itemId", itemId);
			q.setParameter("bidder", bidder);
			q.executeUpdate();
			tx.commit();
			updateCount = -1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public void confirmBid(int itemId, int bidder) {
		String hql = "UPDATE BidRecord set status = 2 where itemId = :itemId and bidder = :bidder";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Query q = null;

		try {

			tx = session.beginTransaction();
			q = session.createQuery(hql);
			q.setParameter("itemId", itemId);
			q.setParameter("bidder", bidder);
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void setBidStatus(int itemId, int status) {
		String hql = "UPDATE BidRecord set status = :status where itemId = :itemId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		Query q = null;
		try {
			tx = session.beginTransaction();
			q = session.createQuery(hql);
			q.setParameter("status", status);
			q.setParameter("itemId", itemId);
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
	}

}
