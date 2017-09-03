package com.programmers.hibernateutil;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.programmers.hibernate.HibernateUtil;

public class HibernateFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException {
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
		 em=HibernateUtil.getEntityManagerFactory().createEntityManager();
		  tx=em.getTransaction();
		HibernateUtil.setEntityManager(em); 
		tx.begin();
		chain.doFilter(request, response);
		tx.commit();
		}catch(Exception ex) {
			if(tx!=null)tx.rollback();
			
		}finally {
			em.close();	
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
