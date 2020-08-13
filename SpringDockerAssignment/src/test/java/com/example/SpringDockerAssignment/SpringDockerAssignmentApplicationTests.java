package com.example.SpringDockerAssignment;

import com.example.SpringDockerAssignment.Controller.CandidateController;
import com.example.SpringDockerAssignment.Model.Candidate;
import com.example.SpringDockerAssignment.Service.CandidateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CandidateController.class)
class SpringDockerAssignmentApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CandidateService candidateService;

	Candidate mockCandidate = new Candidate(1,15,"Zakwaan","Male","Lahore","15-09-2006");

	@Test
	void getCandidate() throws UnsupportedEncodingException, JSONException {
		Mockito.when(
				candidateService.getCandidate(Mockito.anyInt())).
				thenReturn(java.util.Optional.ofNullable(mockCandidate));

		try {
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/candidates/1")
					.accept(MediaType.APPLICATION_JSON))
					.andReturn();

			String expected = "{id : 1 , age : 15 , name : Zakwaan , gender : Male , city : Lahore , dob : 15-09-2006}";

			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void addCandidates() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/candidates")
				.content(mapper.writeValueAsString(mockCandidate))
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		Assert.assertEquals(200,result.getResponse().getStatus());
	}

	@Test
	void getAllCandidate() throws UnsupportedEncodingException, JSONException {
		List<Candidate> candidateList = new ArrayList<>();
		Mockito.when(
				candidateService.getAllCandidates()).
				thenReturn(candidateList);

		try {
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/candidates")
					.accept(MediaType.APPLICATION_JSON))
					.andReturn();

			JSONAssert.assertEquals(candidateList.toString(), result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void updateCandidates() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/candidates/1")
				.content(mapper.writeValueAsString(mockCandidate))
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		Assert.assertEquals(200,result.getResponse().getStatus());
	}

	@Test
	void deleteCandidates() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/candidates/1"))
				.andReturn();

		Assert.assertEquals(200,result.getResponse().getStatus());
	}

}
