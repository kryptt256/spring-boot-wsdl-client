package com.example.consumingwebservices.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import com.example.consumingwebservices.service.CountryService;

@SpringBootTest
@AutoConfigureMockMvc
class CountryResourceTest {

	private MockMvc mvc;
	
	@MockBean
	private CountryService countryService;
	
	@Autowired
	public CountryResourceTest(MockMvc mvc) {
		this.mvc = mvc;
	}
	
	@MockBean
	private GetCountryResponse response;
	
	@Test
	void itShouldInvokeSOAPServiceTest() throws Exception {
		BDDMockito.given(countryService.getCountry("")).willReturn( response );
		mvc.perform(get("/country/{country}", "Spain")).andExpect( status().isOk());
	}

}
