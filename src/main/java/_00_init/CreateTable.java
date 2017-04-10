package _00_init;

import org.hibernate.Session;

public class CreateTable {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
