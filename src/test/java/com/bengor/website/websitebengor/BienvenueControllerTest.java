package com.bengor.website.websitebengor;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bengor.website.websitebengor.BienvenueController;

@RunWith(SpringRunner.class)
@WebMvcTest(BienvenueController.class)
public class BienvenueControllerTest {

    private MockMvc mockMvc;    
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
	@Test
	public void testBienvenue() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk()).andExpect(view().name("bienvenue"));
	}

}
