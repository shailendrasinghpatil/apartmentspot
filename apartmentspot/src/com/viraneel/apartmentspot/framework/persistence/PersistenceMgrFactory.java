package com.viraneel.apartmentspot.framework.persistence;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public final class PersistenceMgrFactory {
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	private static PersistenceManager pm = null;
	private PersistenceMgrFactory() {
	}

	public synchronized static  PersistenceManager get() {
		
		if(null == pm){
			pm = pmfInstance.getPersistenceManager();
		}
		return pm;
	}
}
