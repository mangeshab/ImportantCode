package com.cjc.crud.web.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cjc.crud.web.dao.HomeDao;
import com.cjc.crud.web.model.Employee;

@Repository
public class HomeDaoImpl implements HomeDao
{
	@Autowired
	SessionFactory sf;
	@Override
	public void saveData(Employee e)
	{
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(e);
		
		tx.commit();
		
		session.close();
		
	}
	@Override
	public int logincheck(String uname, String pass) {
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("from Employee where username='"+uname+"' and password='"+pass+"'");
		
		int id=1;
		
		
		tx.commit();
		
		session.close();
		
		return id;
	}
	@Override
	public List displayData() {
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Criteria cr=session.createCriteria(Employee.class);
		
		List al=cr.list();
		
		tx.commit();
		
		session.close();
		
		return al;
	}
	@Override
	public void deleteData(int eid) {
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Query query=session.createQuery("delete from Employee where eid='"+eid+"'");
		
		query.executeUpdate();
		tx.commit();
		
		session.close();
		

		
	}
	@Override
	public Employee editData(Employee e) {
		
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Employee emp=session.get(Employee.class,e.getEid());
		return emp;
	}
	@Override
	public int updateData(Employee e) {
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("update Employee set name='"+e.getName()+"',username='"+e.getUsername()+"',password='"+e.getPassword()+"',birthdate='"+e.getBirthdate()+"',address='"+e.getAddress()+"',mobileno='"+e.getMobileno()+"' where eid='"+e.getEid()+"'");
		
		int id=	query.executeUpdate();
		tx.commit();
		session.close();
		return id;
	}

}
