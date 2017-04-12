package _03_course.model;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import _00_init.HibernateUtil;
import _01_member.model.Member;

public class CourseHBN implements CourseDAO {

	@Override
	public int saveCourse(Course co) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(co);
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
		String hql = "select count(*) from Course c join Member m on c.teacherId = m.userId "
				+ "where c.category like :key or c.instruments like :key or "
				+ "c.area like :key or c.expectedArea like :key or "
				+ "m.alias like :key order by c.updatetime desc";
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
	public List<Course> getAllItem(String key, int page) {
		String hql = "select c from Course c join Member m on c.teacherId = m.userId "
				+ "where c.category like :key or c.instruments like :key or "
				+ "c.area like :key or c.expectedArea like :key or "
				+ "m.alias like :key order by c.updatetime desc";
		List<Course> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<Course> q = session.createQuery(hql);
			q.setParameter("key", "%" + key + "%");
			q.setFirstResult((page) * 12);
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
	public String[] getTeacher(int teacherId) {
		String[] teacher = new String[3];
		String hql = "from Member where userId = :userId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("userId", teacherId);
			Member mem= (Member) q.getSingleResult();
			teacher[0] = mem.getAccount();
			teacher[1] = mem.getAlias();
			teacher[2] = mem.getPic();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return teacher;
	}

	@Override
	public Course getItem(int courseId) {
		Course co = null;
		String hql = "from Course where courseId = :courseId ";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("courseId", courseId);
			co = (Course) q.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			System.out.println(e.getMessage());
		}
		return co;
	}

	@Override
	public int updateCourse(Course co) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			session.update(co);
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
	public int offCourse(int courseId) {
		String hql = "update Course set status = false where courseId=:courseId";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateNumber = 0;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery(hql);
			q.setParameter("courseId", courseId);
			updateNumber = q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateNumber;
	}

	@Override
	public int newBid(ReserveRecord rr) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		int updateCount = 0;
		try {
			tx = session.beginTransaction();
			session.save(rr);
			tx.commit();
			updateCount = 1;
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return updateCount;
	}

	@Override
	public List<ReserveRecord> getBid(int courseId) {
		String hql = "from BidRecord where courseId = :courseId";
		List<ReserveRecord> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<ReserveRecord> q = session.createQuery(hql);
			q.setParameter("courseId", courseId);
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
