package _00_init;

import org.hibernate.Session;

import _00_init.util.HibernateUtil;

public class CreateTable {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
