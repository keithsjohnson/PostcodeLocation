package uk.co.keithsjohnson.postcode.location.finder.service.impl;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.keithsjohnson.postcode.location.finder.service.api.model.PostcodeLocationDisplay;

@Component
public class ConvertPostcodeLocationDisplayToJSON {

	public String convert(PostcodeLocationDisplay postcodeLocationDisplay) {
		ObjectMapper mapper = new ObjectMapper();
		String postcodeLocationDisplayString;
		try {
			postcodeLocationDisplayString = mapper.writeValueAsString(postcodeLocationDisplay);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Cannot convert to PostcodeLocationDisplay to String: " + e.getMessage(), e);
		}

		return postcodeLocationDisplayString;
	}
}
