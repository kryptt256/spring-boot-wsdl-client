/**
 * 
 */
package com.example.consumingwebservices.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.consumingwebservice.wsdl.GetCountryRequest;
import com.example.consumingwebservice.wsdl.GetCountryResponse;

/**
 * @author vvmaster
 *
 */
@Service
public class CountryServiceImpl extends WebServiceGatewaySupport implements CountryService {

	  private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);
	  
	  @Value("${country.ws.url}")
	  private String countryWSUrl;
	  
	  public CountryServiceImpl(Jaxb2Marshaller marshaller) {
		  this.setUnmarshaller(marshaller);
		  this.setMarshaller(marshaller);
		  this.setDefaultUri(countryWSUrl);
	  }
	  
	  @Override
	public GetCountryResponse getCountry(String country) {
	    GetCountryRequest request = new GetCountryRequest();
	    request.setName(country);

	    log.info("Requesting location for " + country);
	    getWebServiceTemplate().setCheckConnectionForFault(true);
	    GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
	            .marshalSendAndReceive(countryWSUrl, request);

	    return response;
	  }

	}
