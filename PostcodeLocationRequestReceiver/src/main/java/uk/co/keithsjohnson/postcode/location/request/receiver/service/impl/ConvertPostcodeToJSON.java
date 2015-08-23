package uk.co.keithsjohnson.postcode.location.request.receiver.service.impl;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import uk.co.keithsjohnson.postcode.location.request.receiver.service.api.Postcode;

@Component
public class ConvertPostcodeToJSON {

	public String convertStringSinglePostcode(String singlePostcodeString) {
		Postcode[] postcodeArray = new Postcode[1];
		postcodeArray[0] = new Postcode();
		postcodeArray[0].setPostcode(singlePostcodeString);
		String postcodeJSONString = convert(postcodeArray);
		return postcodeJSONString;
	}

	public String convert(Postcode[] postcodes) {
		ObjectMapper mapper = new ObjectMapper();
		String postcodesString;
		try {
			postcodesString = mapper.writeValueAsString(postcodes);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Cannot convert to Postcode[] to String: " + e.getMessage(), e);
		}

		return postcodesString;
	}
}
