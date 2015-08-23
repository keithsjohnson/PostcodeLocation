package uk.co.keithsjohnson.postcode.location.finder.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.keithsjohnson.postcode.location.finder.service.api.model.Postcode;

@Component
public class ConvertJSONToPostcode {

	public List<Postcode> convert(String postcodeJSONString) {
		ObjectMapper mapper = new ObjectMapper();

		Postcode[] postcodes = null;
		try {
			postcodes = mapper.readValue(postcodeJSONString, Postcode[].class);
		} catch (Exception e) {
			throw new RuntimeException("Cannot convert JSON String to Postcode: " + postcodeJSONString, e);
		}

		List<Postcode> postcodesList = Arrays.asList(postcodes);

		return postcodesList;
	}
}
