package org.bootapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.test.config.controller.UserInfoControllerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserInfoControllerConfig.class)
@WebIntegrationTest("server.port:0")
public class UserInfoControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	//miss user gender
	private String missParamReqGender = "/user/123";
	private String nonexistentUserReq = "/user/0?gender=female";
	
	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
    @After
	public void releaseMockMvc(){
		mockMvc = null;
	}
	
	public void missParametersQuestTest(MockMvc mockMvc, RequestBuilder requestBuilder) throws Exception {
		mockMvc.perform(requestBuilder)
				.andExpect(status().is4xxClientError())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print())
				.andReturn(); 
	}
	
	/**
	 * the following have two tests:
	 * 1.getMissedParameterUserInfo : test missed parameter situation. check the return whether or not match our expectation
	 * 2.getNonexistentUsrerInfo : test nonexistent user. check the return whether or not match our expectation
	 */
	@Test
	public void getMissedParameterUserInfo() {
		try {
			missParametersQuestTest(mockMvc, get(missParamReqGender));
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

	@Test
	public void getNonexistentUsrerInfo(){
		try {
			MvcResult mvcResult = mockMvc.perform( get(nonexistentUserReq) )
					.andExpect(status().is4xxClientError())
					.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
					.andDo(MockMvcResultHandlers.print())
					.andReturn();
			
			System.out.println(mvcResult.getResponse().getContentAsString() + " you can do more test!");
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
