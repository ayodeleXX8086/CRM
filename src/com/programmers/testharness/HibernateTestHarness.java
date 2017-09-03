package com.programmers.testharness;

import java.util.Scanner;

import javax.persistence.OptimisticLockException;

import com.programmers.domain.Tutor;
import com.programmers.services.NoResultsFoundException;
import com.programmers.services.TutorManagement;

public class HibernateTestHarness 
{
	public static void main(String[] args)
	{		
		TutorManagement tutorManagement = new TutorManagement();
		
		// STEP 1
		Tutor newTutor;
		try 
		{
			newTutor = tutorManagement.findTutorByIdWithSupervisionGroup(41);
			System.out.println("The name of the tutor " + newTutor.getName());			
			System.out.println("The tutor has " + newTutor.getSupervisionGroup().size() + " students.");
		} 
		catch (NoResultsFoundException e) 
		{
			System.out.println("No result found");
		}


	}

}
