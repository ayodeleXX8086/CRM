package com.programmers.services;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import com.programmers.domain.Tutor;
import com.programmers.hibernate.HibernateUtil;

/*
 * This is a starting point : it is far from perfect and will be improved
 * on the course videos. See the final code folder for the finished version.
 */
public class TutorManagement
{
	private static TutorManagement reference;

    /**
     * Use this method if you want to share the service across many servlets.
     *
     * This is simulating what a true container such as Spring would provide
     */
    public static TutorManagement getService()
    {
    	if (reference == null)
    		reference = new TutorManagement();
    	return reference;
    }

    public List<Tutor> getAllTutors()
    {
    	EntityManager em=HibernateUtil.getEntityManager();
    	List<Tutor> allTutors = em.createNamedQuery("allTutors").getResultList();
    	return allTutors;
    }

    public long getTotalSalaryBill()
    {
    	// gets the salary bill for the whole college
    	EntityManager em=HibernateUtil.getEntityManager();
    	Long result = (Long)em.createNamedQuery("totalSalary").getSingleResult();
    	if (result == null) result = 0L;
    	return result;
    }
    public Object[] getTutorTotalSalary() {
    	EntityManager em=HibernateUtil.getEntityManager();
    	List<Tutor>getTutors=em.createNamedQuery("allTutors").getResultList();
    	Long getTutorSalary=(Long) em.createNamedQuery("totalSalary").getSingleResult();
    	Object objarr[]=new Object[2];
    	objarr[0]=getTutors;
    	objarr[1]=getTutorSalary;
    	return objarr;
    }
    public Tutor findTutorByIdWithSupervisionGroup(int id) throws NoResultsFoundException
    {
       	// gets the salary bill for the whole college
    	EntityManager em  = HibernateUtil.getEntityManager();
    	Tutor tutor;
		try
    	{
        	tutor = (Tutor)em.createNamedQuery("tutorByIdWithEagerFetchOfStudents").setParameter("id", id).getSingleResult();
    	}
    	catch (javax.persistence.NoResultException e)
    	{
    		throw new NoResultsFoundException();
    	}
    	return tutor;
    }

	public String createNewTutor(String name, int salary)
	{
		EntityManager em=HibernateUtil.getEntityManager();
    	// generate a Staff Id. This is a very cheap way of doing it but it is a very
    	// long id!
    	String staffId = UUID.randomUUID().toString();
    	Tutor newTutor = new Tutor(staffId, name, salary);
    	em.persist(newTutor);
    	return staffId;
	}
}
