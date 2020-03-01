/**
 * 
 */
package com.example.consumingwebservices.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.wsdl.GetCountryResponse;
import com.example.consumingwebservices.service.CountryService;

/**
 * @author vvmaster
 *
 */
@RestController
@RequestMapping("/")
public class CountryResource {
	
	private CountryService countryService;
	
	@Autowired
	public CountryResource(CountryService countryClient) {
		this.countryService = countryClient;
	}
	
	@GetMapping("/country/{country}")
	public GetCountryResponse getCountryData(@PathVariable("country") String country) {
		return this.countryService.getCountry(country);
	}

}
