package com.dupedetective.web.tests;

import com.dupedetective.data.User;
import com.dupedetective.web.controllers.UserController;
import com.dupedetective.web.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository userRepo;
	
	User u = new User("1","nikhila","nik@gmail","nikhi","nikhi",false);
	User u1 = new User("2","prashanth","prashanth@gmail","pra","pra",false);
	
	String exampleCreateUserJson = "{\"name\":\"srikar\",\"email\":\"srikar@gmail\",\"username\":\"sri\",\"password\":\"sri\",\"grader\": false}";
	
	/**
	 *  testing the get request to return a user object when the username and password are sent 
	 *  as parameters to the get request
	 */
	@Test
	public void getUserByUserNameTests() throws Exception{
		Mockito.when(
				userRepo.findUserByUsernameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(u);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/users/login?username=nikhi&password=nikhi").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{name:nikhila,email:nik@gmail,username:nikhi,password:nikhi,grader:false}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	/**
	 *  testing the post request to return a status 200(Success code) when 
	 *  a user object is sent as a part of the request body to create the object
	 */
	@Test
	public void createUserTests() throws Exception{
		User mockUser = new User("123","srikar","srikar@gmail","sri","sri",false);
		Mockito.when(userRepo.save(Mockito.any(User.class))).thenReturn(mockUser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/users")
				.accept(MediaType.APPLICATION_JSON).content(exampleCreateUserJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
	
	/**
	 *  testing the get request to return a user object when the user id is sent 
	 *  as parameter to the get request
	 */
	@Test
	public void getUserByIdTests() throws Exception{
		Mockito.when(
				userRepo.findOne(Mockito.anyString())).thenReturn(u);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/users/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "{name:nikhila,email:nik@gmail,username:nikhi,password:nikhi,grader:false}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
	/**
	 *  testing the delete request to return a status 200(Success code) when 
	 *  a user with the specified user id, that is a part of the url, is deleted
	 */
	@Test
	public void deleteUserTest() throws Exception{
		Mockito.doNothing().when(userRepo).delete(Mockito.anyString());
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/api/users/1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
	
	

}
