package web.tests;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.ArrayList;

import org.hibernate.validator.constraints.NotBlank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.data.annotation.Id;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import cs5500.project.data.Assignment;
import cs5500.project.web.controllers.AssignmentController;
import cs5500.project.web.repository.AssignmentRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AssignmentController.class, secure = false)
public class AssignmentControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AssignmentRepository assignRepo;
	
	
	Assignment assign = new Assignment("1","ProblemSet1","CS5500",2017,true,"12/2/17","1/2/17","1/2/17");
	java.util.List<Assignment> listOfAssignments = new ArrayList<Assignment>();
	
	
	String exampleAssignmentJson = "{\"id\":\"1\",\"name\":\"ProblemSet1\",\"course\":\"CS5500\",\"year\":2017,\"isAnalyzed\":true,\"dueDate\":\"12/2/17\",\"creationDate\":\"1/2/17\",\"analyzedDate\":\"1/2/17\"}";
	
	@Test
	public void getAssignmentByIdTest() throws Exception{
		Mockito.when(
				assignRepo.findOne(Mockito.anyString())).thenReturn(assign);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/assignments/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,name:ProblemSet1,course:CS5500}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	
}
