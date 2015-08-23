package uk.co.keithsjohnson.postcode.location.request.receiver.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uk.co.keithsjohnson.postcode.location.request.receiver.service.api.Postcode;

public class ConvertJSONToPostcodeTest {

	private ConvertJSONToPostcode testSubject;

	@Before
	public void setUp() {
		testSubject = new ConvertJSONToPostcode();
	}

	@Test
	public void shouldConvertSinglePostcodeToJSONString() {

		// Given
		String singlePostcode = "[{\"postcode\":\"ST7 2YB\"}]";

		// When
		Postcode[] postcodes = testSubject.convert(singlePostcode);

		// Then
		List<Postcode> postocdesList = Arrays.asList(postcodes);
		postocdesList.stream().forEach(System.out::println);
	}

	@Test
	public void shouldConvertTwoPostcodeToJSONString() {

		// Given
		String multiplePostcodes = "[{\"postcode\":\"ST7 2YB\"},{\"postcode\":\"ST5 4EP\"}]";

		// When
		Postcode[] postcodes = testSubject.convert(multiplePostcodes);

		// Then
		List<Postcode> postocdesList = Arrays.asList(postcodes);
		postocdesList.stream().forEach(System.out::println);
	}
}
