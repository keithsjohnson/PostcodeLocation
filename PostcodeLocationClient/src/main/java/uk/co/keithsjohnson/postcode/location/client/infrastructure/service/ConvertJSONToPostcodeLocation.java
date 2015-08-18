package uk.co.keithsjohnson.postcode.location.client.infrastructure.service;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.keithsjohnson.postcode.location.client.model.PostcodeLocation;

@Component
public class ConvertJSONToPostcodeLocation {

	public PostcodeLocation convert(String postcodeLocationJSONString) {
		ObjectMapper mapper = new ObjectMapper();

		PostcodeLocation postcodeLocation = null;
		try {
			postcodeLocation = mapper.readValue(postcodeLocationJSONString, PostcodeLocation.class);
		} catch (Exception e) {
			throw new RuntimeException("Cannot convert JSON String to PostcodeLocation: " + postcodeLocationJSONString,
					e);
		}

		return postcodeLocation;
	}
}
