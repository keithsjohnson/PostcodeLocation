package uk.co.keithsjohnson.postcode.location.request.receiver.service.impl;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.keithsjohnson.postcode.location.request.receiver.service.api.Postcode;

@Component
public class ConvertJSONToPostcode {

	public Postcode[] convert(String postcodeJSONString) {
		ObjectMapper mapper = new ObjectMapper();

		Postcode[] postcodes = null;
		try {
			postcodes = mapper.readValue(postcodeJSONString, Postcode[].class);
		} catch (Exception e) {
			throw new RuntimeException("Cannot convert JSON String to Postcode: " + postcodeJSONString, e);
		}

		return postcodes;
	}
}
