package com.programmers.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tutor.class)
public abstract class Tutor_ {

	public static volatile SetAttribute<Tutor, Student> supervisionGroup;
	public static volatile SetAttribute<Tutor, Subject> subjectsQualifiedToTeach;
	public static volatile SingularAttribute<Tutor, String> name;
	public static volatile SingularAttribute<Tutor, Integer> id;
	public static volatile SingularAttribute<Tutor, Integer> salary;
	public static volatile SingularAttribute<Tutor, Integer> version;
	public static volatile SingularAttribute<Tutor, String> staffId;

}

