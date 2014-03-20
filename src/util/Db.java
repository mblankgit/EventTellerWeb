package util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import db.Event;

public class Db {
	
	
	private SessionFactory sf;
	
	public Db(){
		buildSession();
	}

	public void close(){
		sf.close();
	}
	
	
	private void buildSession(){
		Configuration cfg = new Configuration();
		cfg.configure();
		ServiceRegistry serviceRegistry =new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sf = cfg.configure().buildSessionFactory(serviceRegistry);
	}
	
	
	
	public int queryCount(String query){
		Session session = sf.openSession();
		int count = ((Long)session.createQuery(query).uniqueResult()).intValue();
		session.close();
		return count;
	}
	
	@SuppressWarnings("rawtypes")
	public List query(String query){
		Session session = sf.openSession();
		List res = session.createQuery(query).list();
		session.close();
		return res;		
	}
	
	public Object getElementById(String sql){
		Session session = sf.openSession();
		Object res = session.createQuery(sql).uniqueResult();
		session.close();
		return res;
	}
	
	@SuppressWarnings("rawtypes")
	public List getElement(String query, int start, int max){
		Session session = sf.openSession();
		List res = session.createQuery(query).setMaxResults(max).list();
		session.close();
		return res;		
	}
	
	public Event getEventById(Long id){
		Session session = sf.openSession();
		String sql = "from Event as obj where obj.id = " + id;
		Event res = (Event)session.createQuery(sql).uniqueResult();
		session.close();
		if(res != null){
			return res;
		}
		return null;
	}

}
