package org.school.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.school.dao.School;
import org.school.dto.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SchoolControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
      //  this.mockMvc = MockMvcBuilders.standaloneSetup(SchoolController.class).build();
    }

    @Test
    public void getSchoolDetailWhenSchoolExists() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/school/{schoolId}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                        .andReturn();

        String content =  result.getResponse().getContentAsString();
        ApiResponse<School> responseBody = objectMapper.readValue(content, new TypeReference<>() {});
        Assertions.assertEquals( 1, responseBody.data().getId());
        Assertions.assertEquals("Nona Academy", responseBody.data().getName());
    }

    @Test
    public void getSchoolDetailWhenSchoolDoesNotExist() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/school/{schoolId}", 3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content =  result.getResponse().getContentAsString();
        ApiResponse<School> responseBody = objectMapper.readValue(content, new TypeReference<>() {});
        assertNull(responseBody.data());
        Assertions.assertEquals("no.school.found",responseBody.errors().getFirst().errorCode());
        Assertions.assertEquals("There is no school in the system with id: " + 3,responseBody.errors().getFirst().errorMessage());
    }

    @AfterEach
    void tearDown() {
    }
}