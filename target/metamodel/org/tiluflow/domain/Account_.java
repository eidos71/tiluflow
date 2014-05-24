package org.tiluflow.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Account.class)
public abstract class Account_ {

	public static volatile SingularAttribute<Account, Integer> id;
	public static volatile SingularAttribute<Account, Boolean> enabled;
	public static volatile SingularAttribute<Account, String> username;
	public static volatile SingularAttribute<Account, String> email;
	public static volatile SingularAttribute<Account, String> lastname;
	public static volatile SingularAttribute<Account, String> firstname;
	public static volatile SingularAttribute<Account, Date> desactivationDate;
	public static volatile ListAttribute<Account, Address> addresses;
	public static volatile SingularAttribute<Account, String> password;

}

