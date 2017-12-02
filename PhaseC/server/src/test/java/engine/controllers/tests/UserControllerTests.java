package engine.controllers.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cs5500.project.data.User;
import cs5500.project.web.controllers.UserController;
import cs5500.project.web.repository.AssignmentRepository;
import cs5500.project.web.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserRepository userRepo;
	
	User u = new User("1","nikhila","nik@gmail","nikhi","nikhi",false);
	
	String exampleUserJson = "{\"id\":\"1\",\"name\":\"nikhila\",\"email\":\"nik@gmail\",\"username\":\"nikhi\",\"password\":\"nikhi\",\"grader\": false}";
	
	@Test
	public void getUserByUserNameTests() throws Exception{
		Mockito.when(
				userRepo.findUserByUsernameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(u);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/users/login").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,name:nikhila,email:nik@gmail.com,username:nikhi,password:nikhi,grader:false}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}
