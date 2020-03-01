package com.example.consumingwebservices.service;

import com.example.consumingwebservice.wsdl.GetCountryResponse;

public interface CountryService {

	GetCountryResponse getCountry(String country);

}