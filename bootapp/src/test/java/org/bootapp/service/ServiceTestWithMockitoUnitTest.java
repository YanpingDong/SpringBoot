package org.bootapp.service;

import org.bootapp.dao.ForTestDao;
import org.bootapp.exception.handle.MyException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ServiceTestWithMockitoUnitTest {
	
	@InjectMocks
	private ForTestService fortestService;
	
	@Mock
	private ForTestDao forTestDao;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getInfoTest() throws MyException
	{
		org.mockito.BDDMockito.given(forTestDao.getInfo(0))
		   .willReturn("exist");
		System.out.println(fortestService.getInfo(0));
	}
}
