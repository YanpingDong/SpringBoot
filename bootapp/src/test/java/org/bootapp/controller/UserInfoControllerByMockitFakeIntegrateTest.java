package org.bootapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Field;

import org.bootapp.dao.ForTestDao;
import org.bootapp.exception.handle.ControllerExcptionAdvice;
import org.bootapp.exception.handle.MyException;
import org.bootapp.service.ForTestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.WebApplicationContext;

public class UserInfoControllerByMockitFakeIntegrateTest {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;

	@Mock
	private ForTestDao forTestDao;
	
	@InjectMocks
	private ForTestService fortestService;
	
	private UserInfoController userInfoController = new UserInfoController();
	
	//miss user gender
	private String missParamReqGender = "/user/123";
	private String nonexistentUserReq = "/user/0?gender=female";

	@Before
	public void setupMockMvc() {
		
		MockitoAnnotations.initMocks(this);
		
		
        /* * 如果要使用完全默认Spring Web Context, 例如不需要对Controller注入,
         * 则使用 WebApplicationContext mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
         */
		
		//======================================parting line==============================================
		
		
		 /** Build a MockMvc instance by registering one or more @Controller instances and configuring Spring MVC infrastructure programmatically. 
		 * This allows full control over the instantiation and initialization of controllers and their dependencies, 
		 * similar to plain unit tests while also making it possible to test one controller at a time. 
		 * When this builder is used, the minimum infrastructure required by the DispatcherServlet to serve requests with annotated controllers 
		 * is created automatically and can be customized, 
		 * resulting in configuration that is equivalent to what MVC Java configuration provides except using builder-style methods.  
		 */
		
		Field forTestServiceField = ReflectionUtils.findField(UserInfoController.class, "forTestService");
		ReflectionUtils.makeAccessible(forTestServiceField);
		ReflectionUtils.setField(forTestServiceField, userInfoController, fortestService);
		 
		 mockMvc = MockMvcBuilders
				     .standaloneSetup(userInfoController)
				     .setControllerAdvice(new ControllerExcptionAdvice())
				     .build();
	}
	
	@Test
	public void getNoexistUsrerInfoTest() throws MyException
	{
		org.mockito.BDDMockito.given(forTestDao.getInfo(0))
		   .willReturn(null);
		try {
			MvcResult mvcResult = mockMvc.perform( get(nonexistentUserReq) )
					.andExpect(status().is4xxClientError())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
			
			System.out.println(mvcResult.getResponse().getContentAsString() + " you can do more test!");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void missParametersQuestTest(MockMvc mockMvc, RequestBuilder requestBuilder) throws Exception {
		mockMvc.perform(requestBuilder)
				.andExpect(status().is4xxClientError())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andReturn(); 
	}
	
	
	@Test
	public void getMissedParameterUserInfoTest() {
		try {
			missParametersQuestTest(mockMvc, get(missParamReqGender));
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
