/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Given(value = "Given the greeting controller is available")
	@When(value=" When the client sends a GET request to \"/greeting\" with parameter \"name\" as \"Spring Community\"")
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, World!"));
	}
	
	@Test
	@Given(value = " Given the greeting controller is available")
	@When(value="When the client sends a GET request to \"/greeting\" with an empty parameter \"name\"")
	public void paramGreetingWithEmptyNameShouldReturnDefaultMessage() throws Exception {
	    // Given: The greeting controller is available

	    this.mockMvc.perform(get("/greeting").param("name", ""))
	        .andDo(print())
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.content").value("Hello, World!"));
	}
	
	
	@Given(value = "Given the greeting controller is available")
	@When(value="When the client sends a GET request to a non-existent route")
	public void requestingNonExistentRouteShouldReturn404() throws Exception {
	    // Given: The greeting controller is available

	    this.mockMvc.perform(get("/nonexistent"))
	        .andDo(print())
	        .andExpect(status().isNotFound());
	}




	@Test
	@Given(value="Given the greeting controller is available")
	@When(value="When the client sends a GET request to \"/greeting\" with an empty parameter \"name\"")
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
	}

}
