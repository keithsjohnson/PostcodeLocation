package uk.co.keithsjohnson.postcode.location.request.receiver.service.impl;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.postcode.location.request.receiver.service.api.Postcode;

public class ConvertPostcodeToJSONTest {

	private ConvertPostcodeToJSON testSubject;

	@Before
	public void setUp() {
		testSubject = new ConvertPostcodeToJSON();
	}

	@Test
	public void shouldConvertSinglePostcodeToJSONString() {

		// Given
		Postcode[] postcodes = new Postcode[1];
		postcodes[0] = new Postcode();
		postcodes[0].setPostcode("ST7 2YB");

		// When
		String postcodeJSONString = testSubject.convert(postcodes);

		// Then
		System.out.println(postcodeJSONString);
	}

	@Test
	public void shouldConvertTwoPostcodeToJSONString() {

		// Given
		Postcode[] postcodes = new Postcode[2];
		postcodes[0] = new Postcode();
		postcodes[0].setPostcode("ST7 2YB");
		postcodes[1] = new Postcode();
		postcodes[1].setPostcode("ST5 4EP");

		// When
		String postcodeJSONString = testSubject.convert(postcodes);

		// Then
		System.out.println(postcodeJSONString);
	}
}
