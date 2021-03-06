package _01_member.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;

public class MemberHBN implements MemberDAO {
	private static List<String> accountList = null;

	public MemberHBN() {
		if (accountList == null) {
			accountList = new ArrayList<>();
			getAccountList();
		}
	}

	@Override
	public void getAccountList() {
		List<?> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery("from Member").getResultList();
			for (Object o : list) {
				Member m = (Member) o;
				String account = m.getAccount();
				accountList.add(account);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int saveMember(Member mem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(mem);
			tx.commit();
			accountList.add(mem.getAccount());
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public Member getMember(int id) {
		String hql = "from Member where userId = :id";
		Member mb = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("id", id);
			mb = (Member) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return mb;
	}

	@Override
	public Member getMemberByAccount(String account) {
		String hql = "from Member where account = :account";
		Member mb = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("account", account);
			mb = (Member) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return mb;
	}

	@Override
	public boolean idExists(String account) {
		boolean exists = false;
		for (String s : accountList) {
			if (s.trim().equals(account)) {
				exists = true;
				break;
			}
		}
		return exists;
	}

	@Override
	public boolean checkPassword(String account, String password) {
		boolean result = false;
		Member mb = getMemberByAccount(account);
		if (password.trim().equals(mb.getPassword())) {
			result = true;
		}
		return result;
	}

	@Override
	public int updateMember(Member mem) {
		String hql = "update Member set intro=:intro,isNoted=:isNoted, email=:email, isOneClick=:isOneClick,instrument=:instrument, alias=:alias, pic=:pic, url=:url where account=:account";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("intro", mem.getIntro());
			q.setParameter("alias", mem.getAlias());
			q.setParameter("pic", mem.getPic());
			q.setParameter("account", mem.getAccount());
			q.setParameter("email", mem.getEmail());
			q.setParameter("isOneClick", mem.isOneClick());
			q.setParameter("instrument", mem.getInstrument());
			q.setParameter("isNoted", mem.isNoted());
			q.setParameter("url", mem.getURL());
			updateNumber = q.executeUpdate();
			System.out.println("updateNumber: " + updateNumber);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateNumber;
	}

	@Override
	public List<InnerMsg> getMsg(int userId) {
		String hql = "from InnerMsg where receiver = :userId order by time desc";
		List<InnerMsg> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<InnerMsg> q = session.createQuery(hql);
			q.setParameter("userId", userId);
			q.setMaxResults(11);
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
	public int newMsg(int userId) {
		int msg = 0;
		String hql = "Select count(*) from InnerMsg where receiver = :userId and state = false";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			msg = (int) (long) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public int allMsg(int userId) {
		int msg = 0;
		String hql = "Select count(*) from InnerMsg where receiver = :userId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", userId);
			msg = (int) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return msg;
	}

	@Override
	public int setMsg(InnerMsg msg) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(msg);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int deleteMsg(InnerMsg msg) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.delete(msg);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public int changeState(int id) {
		String hql = "from InnerMsg where pk = :pk";
		InnerMsg msg = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("pk", id);
			msg = (InnerMsg) q.getSingleResult();
			msg.setState(true);
			session.update(msg);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

}
