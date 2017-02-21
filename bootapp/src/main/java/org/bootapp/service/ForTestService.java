package org.bootapp.service;

import org.bootapp.dao.ForTestDao;
import org.bootapp.exception.handle.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ForTestService {
	private static final Logger logger = LoggerFactory.getLogger(ForTestService.class);
	
	@Autowired(required=false)
	@Qualifier(value="forTestDaoImp")
	private ForTestDao forTestDao;
	
	public String getInfo(int id) throws MyException {	
		
		String userInfo = forTestDao.getInfo(id);
		// If can't get user info throw error.
    	if(null == userInfo)
    	{
    		if(logger.isDebugEnabled())
    			logger.debug("start to get info from DB");
    		
    		throw new MyException("Didn't find user by " + String.valueOf(id) );
    	}
    	
    	return userInfo;
	}
	
}
