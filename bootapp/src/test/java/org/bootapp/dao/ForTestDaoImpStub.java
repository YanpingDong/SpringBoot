package org.bootapp.dao;

import org.bootapp.dao.ForTestDao;
import org.springframework.stereotype.Repository;

/**
 * mock ForTestDao in test
 * 
 * mock the ALL possible situation in real DAO
 */
@Repository("forTestDaoImp")
public class ForTestDaoImpStub implements ForTestDao {

	private int NON_EXSIT = 0;
	
	@Override
	public String getInfo(int id) {
		// situation 1: can't find info 
		if( NON_EXSIT == id)
			return null;
		
		// situation 2: can find
		return "read info from stub";
		
		// of course we can mock the exception 
	}

}