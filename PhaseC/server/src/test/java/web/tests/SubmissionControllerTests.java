package web.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

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

import cs5500.project.data.Submission;
import cs5500.project.web.controllers.SubmissionController;
import cs5500.project.web.repository.SubmissionRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SubmissionController.class, secure = false)
public class SubmissionControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SubmissionRepository submRepo;
	
	Submission subm = new Submission("FirstSubmission","12","1","12/12/17","List","a+b=c");
	 
	String exampleSubmissionJson = "{\"name\":\"FirstSubmission\",\"studentId\":12,\"assignmentId\":1,\"filename\":\"List\",\"filecontent\":\"a+b=c\"}";
	java.util.List<Submission> listOfSubmissions = new ArrayList<Submission>();
	
	/*
	 *  testing the get request to return an submission object when the submission id is sent 
	 *  as parameter to the get request
	 */
	@Test
	public void getSubmissionByIdTest() throws Exception{
		Mockito.when(
				submRepo.findOne(Mockito.anyString())).thenReturn(subm);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/submissions/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{name:FirstSubmission,filename:List}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	/*
	 *  testing the delete request to return a status 200(Success code) when 
	 *  a submission with the specified submission id, that is a part of the url, is deleted
	 */
	@Test
	public void deleteAssignmentTest() throws Exception{
		Mockito.doNothing().when(submRepo).delete(Mockito.anyString());
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/api/submissions/1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
	
	/*
	 *  testing the post request to return a status 200(Success code) when 
	 *  a submission object is sent as a part of the request body to create the object
	 */
	@Test
	public void createAssignmentTests() throws Exception{
		Submission mockSubm = new Submission("SecondSubmission","22","2","11/12/17","Lists","a+b-d=c");
		Mockito.when(submRepo.save(Mockito.any(Submission.class))).thenReturn(mockSubm);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/submissions")
				.accept(MediaType.APPLICATION_JSON).content(exampleSubmissionJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}

	/*
	 *  testing the get request to return a submission object when the student id and assignment id is sent 
	 *  as parameter to the get request
	 */
	@Test
	public void getSubmissionByAssignmentIdAndStudentIdTest() throws Exception{
		Mockito.when(
				submRepo.findSubmissionByAssignmentIdAndStudentId(Mockito.anyString(),Mockito.anyString())).thenReturn(subm);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/submissions/student?assignmentId=1&studentId=2").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{name:FirstSubmission,filename:List}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	
	
	
}
