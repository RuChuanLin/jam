package _01_member.controller;

import java.io.IOException;
import java.sql.Clob;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;
import _01_member.model.Member;
import antlr.collections.List;

public class RegisterService implements RegisterServiceInterface {

	@Override
	public void allIDList() {
		
	}

	@Override
	public boolean idExists(String account) throws IOException {
//		boolean idExists = false;
//		String hql = "from "+ account;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try{
//			session.beginTransaction();
//			Query query = session.createQuery(hql);
//		}
		return false;
	}

	@Override
	public boolean checkPassword(String account, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member findUserData(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] clobToCharArray(Clob clob) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(Member mem) {
		// TODO Auto-generated method stub

	}

}
