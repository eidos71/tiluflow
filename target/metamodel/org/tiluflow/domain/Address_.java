package org.tiluflow.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ extends org.tiluflow.domain.BaseEntity_ {

	public static volatile SingularAttribute<Address, String> zipcode;
	public static volatile SingularAttribute<Address, String> state;
	public static volatile SingularAttribute<Address, Account> account;
	public static volatile SingularAttribute<Address, String> line1;
	public static volatile SingularAttribute<Address, String> line2;
	public static volatile SingularAttribute<Address, String> city;

}

