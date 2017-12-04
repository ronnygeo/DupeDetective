package com.dupedetective.data.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dupedetective.data.Assignment;
import com.dupedetective.data.ModelReport;
import com.dupedetective.data.Report;
import com.dupedetective.data.ReportLine;
import com.dupedetective.data.Submission;
import com.dupedetective.data.User;

/**
 * Tests of Data classes
 */
public class DataTests {

	Assignment assign = new Assignment("1","ProblemSet1","CS5500",2017,true,"12/2/17","1/2/17","1/2/17");
	User u = new User("1","nikhila","nik@gmail","nikhi","nikhi",false);
	Submission subm = new Submission("FirstSubmission","12","1","12/12/17","List","a+b=c");
	Report rep = new Report("1","12","122");
	ReportLine rLine = new ReportLine(1,2,3,4,5,2.0f);
	
	@Test
	public void testSetAndGetId() {
		assign.setId("1");
		assertEquals("1",assign.getId());
	}

	@Test
	public void testSetAndGetName() {
		assign.setName("ProblemSet1");
		assertEquals("ProblemSet1",assign.getName());
	}
	
	@Test
	public void testSetAndGetCourse() {
		assign.setCourse("CS5500");;
		assertEquals("CS5500",assign.getCourse());
	}
	@Test
	public void testSetAndGet() {
		assign.setYear(2017);
		assertEquals(2017,assign.getYear());
		assign.setAnalyzed(true);
		assertEquals(true,assign.isAnalyzed());
	}
	@Test
	public void testSetAndGetIsAnalyzed() {
		Assignment agn = new Assignment();
		assign.setAnalyzed(true);
		assign.setAnalyzedDate("12/2/17");
		assertEquals("12/2/17",assign.getAnalyzedDate());
	}
	
	@Test
	public void testSetAndGetCreationDate() {
		assign.setCreationDate("12/2/17");
		assertEquals("12/2/17",assign.getCreationDate());
	}
	
	@Test
	public void testSetAndGetDueDate() {
		assign.setDueDate("12/2/17");
		assertEquals("12/2/17",assign.getDueDate());
	}
	
	@Test
	public void testSetAndGetUserId() {
		u.setId("1");
		assertEquals("1",u.getId());
	}

	@Test
	public void testSetAndGetUserName() {
		u.setName("nikhila");
		assertEquals("nikhila",u.getName());
	}
	
	@Test
	public void testSetAndGetUsername() {
		u.setUsername("nikhi");
		assertEquals("nikhi",u.getUsername());
	}
	
	@Test
	public void testSetAndGetEmail() {
		u.setEmail("nikhi@gmail");
		assertEquals("nikhi@gmail",u.getEmail());
	}
	
	@Test
	public void testSetAndGetPassword() {
		User user1 = new User("nik","nik@hmail","nikhi","nikhi",true);
		User user2 = new User();
		u.setPassword("nikhi");
		u.setGrader(false);
		assertEquals(false,u.isGrader());
		assertEquals("nikhi",u.getPassword());
	}
	
    
    @Test
	public void testSetAndGetSubmission() {
		subm.setId("1");
		subm.setName("first");
		subm.setAssignmentId("2");
		subm.setFilecontent("a+b=c");
		subm.setFilename("lists");
		subm.setStudentId("12");
		subm.setSubmittedOn("12/12/12");
		Submission subm1 = new Submission("1","23","221");
		Submission subm2 = new Submission();
		assertEquals("1",subm.getId());
		assertEquals("first",subm.getName());
		assertEquals("2",subm.getAssignmentId());
		assertEquals("a+b=c",subm.getFilecontent());
		assertEquals("lists",subm.getFilename());
		assertEquals("12",subm.getStudentId());
		assertEquals("12/12/12",subm.getSubmittedOn());
		assertEquals("1",subm1.getId());
	}
    
    @Test
    public void testSetAndGetReportLine() {
		rLine.setRefOffset(1);
		rLine.setRefLength(2);
		rLine.setSimilarOffset(3);
		rLine.setSimilarLength(4);
		rLine.setModel(5);
		rLine.setScore(2.0f);
		ReportLine rline1 = new ReportLine();
		rline1.setRefOffset(1);
		assertEquals("1", rLine.getRefOffset().toString());
		assertEquals("2", rLine.getRefLength().toString());
		assertEquals("3", rLine.getSimilarOffset().toString());
		assertEquals("4", rLine.getSimilarLength().toString());
		assertEquals("5", rLine.getModel().toString());
		assertEquals("2.0", rLine.getScore().toString());
	}

    @Test
    public void testSetAndGetReport(){
    	Report rep1 = new Report();
    	rep1.setId("1");
    	rep.setId("1");
    	rep.setSubmissionId("11");
    	rep.setSimilarFileId("3");
    	rep.setMd5Result(false);
    	rep.setOverallScore(12.0f);
    	rep.setRefFileId("22");
    	ModelReport modRep = new ModelReport(1);
    	List<ModelReport> mr = new ArrayList<ModelReport>();
    	rep.addModel(modRep);
    	float i = rep.getOverallScore();
    	mr.add(modRep);
    	rep.setModels(mr);
    	assertEquals("1",rep.getId());
    	assertEquals("11",rep.getSubmissionId());
    	assertEquals("3",rep.getSimilarFileId());
    	assertFalse(rep.getMd5Result());
    	assertEquals("1",rep.getModels().get(0).getModel().toString());
    	assertEquals("22",rep.getRefFileId());	
    }

    @Test
	public void testComputeScore() {

	}
    
    @Test
    public void testSetAndGetModelReport(){
		List<ReportLine> lines = new ArrayList<ReportLine>();
		List<ReportLine> lines1 = new ArrayList<ReportLine>();
    	lines.add(rLine);
    	ModelReport modRep = new ModelReport(1);
    	ModelReport mRep1 = new ModelReport();
    	mRep1.computeScore();
    	float i = mRep1.getScore();
    	mRep1.addLines(lines);
    	mRep1.setLines(lines);
    	mRep1.setModel(1);
    	mRep1.setScore(0.1f);
    	modRep.setModel(2);
    	lines1=mRep1.getLines();
    	assertEquals("1", lines1.get(0).getRefOffset().toString());
    	assertEquals("1",mRep1.getModel().toString());
    	
    }
}
