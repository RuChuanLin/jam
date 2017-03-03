package _01_member.model;

import java.io.IOException;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;

public class MemberService implements MemberDAO {
	private static List<String> accountList = null;

	public MemberService() {
		if (accountList == null) {
			accountList = new ArrayList<>();
			getAccountList();
		}
	}

	// 得到所有account的List物件
	@Override
	public void getAccountList() {
		List<?> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery("from Member").list();
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

	// 儲存註冊帳號資料
	@Override
	public void saveMember(Member mem) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(mem);
			tx.commit();
			accountList.add(mem.getAccount());
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Member getMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	// 用帳號搜尋該會員的Id 暱稱
	@Override
	public Member getMemberIdAlias(String account) {
		// String hql = "select m.userId, m.alias from Member m where account =
		// :account";
		// Member mb = null;
		// Session session =
		// HibernateUtil.getSessionFactory().getCurrentSession();
		// Transaction tx = null;
		// try{
		// tx = session.beginTransaction();
		// Query q = session.createQuery(hql);
		// q.setParameter("account", account);
		// mb = (Member) q.uniqueResult();
		// tx.commit();
		// }catch(Exception e){
		// tx.rollback();
		// System.out.println(e.getMessage());
		// }
		return null;
	}

	// 用帳號搜尋該會員的資料
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
			mb = (Member) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return mb;
	}

	// 檢查用戶是否已存在
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
	public int updateMember(Member mem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkPassword(String account, String password) {
		boolean result = false;
		Member mb = getMemberByAccount(account);
		System.out.println(mb.toString());
		System.out.println(mb.getAccount());
		System.out.println(mb.getPassword());
		if (password.trim().equals(mb.getPassword())) {
			result = true;
		}
		return result;
	}

	@Override
	public Collection<Member> getAllMembers() {
		Collection<Member> allMembers = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			allMembers = session.createQuery("from Member").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return allMembers;
	}

}
