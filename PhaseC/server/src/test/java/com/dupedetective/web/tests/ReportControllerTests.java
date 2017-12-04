package com.dupedetective.web.tests;

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

import com.dupedetective.data.Report;
import com.dupedetective.web.controllers.ReportController;
import com.dupedetective.web.repository.ReportRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ReportController.class, secure = false)
public class ReportControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ReportRepository reportRepo;
	
	Report rpt = new Report("12","23","32");
	 
	String exampleReportJson = "{\"submissionId\":\"12\",\"refFileId\":\"23\",\"similarFileId\":\"2017\"}";
	java.util.List<Report> listOfReports = new ArrayList<Report>();
	
	/*
	 *  testing the get request to return an report object when the report id is sent 
	 *  as parameter to the get request
	 */
	@Test
	public void getReportByIdTest() throws Exception{
		Mockito.when(
				reportRepo.findOne(Mockito.anyString())).thenReturn(rpt);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/reports/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{submissionId:'12',refFileId:'23'}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	/*
	 *  testing the delete request to return a status 200(Success code) when 
	 *  a report with the specified report id, that is a part of the url, is deleted
	 */
	@Test
	public void deleteAssignmentTest() throws Exception{
		Mockito.doNothing().when(reportRepo).delete(Mockito.anyString());
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/api/reports/1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
	
	/*
	 *  testing the get request to return a list of report object when the submission id is sent 
	 *  as parameter to the get request
	 */
	@Test
	public void getReportsBySubmissionId() throws Exception{
		listOfReports.add(rpt);
		Mockito.when(
				reportRepo.findReportsBySubmissionId(Mockito.anyString())).thenReturn(listOfReports);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/submissions/1/reports").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "[{submissionId:'12',refFileId:'23'}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	/*
	 *  testing the get request to return a list of report object when the RefFileId and SimilarFileId is sent 
	 *  as parameter to the get request
	 */
	@Test
	public void getReportByRefFileIdAndSimilarFileIdTests() throws Exception{
		Mockito.when(
				reportRepo.findReportByRefFileIdAndSimilarFileId(Mockito.anyString(),Mockito.anyString())).thenReturn(rpt);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/reports/single").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{submissionId:'12',refFileId:'23'}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
}
