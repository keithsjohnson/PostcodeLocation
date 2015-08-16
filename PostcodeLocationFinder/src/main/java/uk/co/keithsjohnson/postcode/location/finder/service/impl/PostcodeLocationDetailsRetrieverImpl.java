package uk.co.keithsjohnson.postcode.location.finder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.finder.infrastructure.dynamodb.PostcodeLocationDetails;
import uk.co.keithsjohnson.postcode.location.finder.infrastructure.dynamodb.PostcodeLocationDetailsRepository;
import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationDetailsRetriever;
import uk.co.keithsjohnson.postcode.location.finder.service.api.model.PostcodeLocationDisplay;

@Component
public class PostcodeLocationDetailsRetrieverImpl implements PostcodeLocationDetailsRetriever {

	@Autowired
	private PostcodeLocationDetailsRepository postcodeLocationDetailsRepository;

	@Override
	public PostcodeLocationDisplay retrievePostcodeLocationDisplayForPostcode(String postcode) {
		PostcodeLocationDetails postcodeLocationDetails = postcodeLocationDetailsRepository.findOne(postcode);

		PostcodeLocationDisplay postcodeLocationDisplay = new PostcodeLocationDisplay(
				postcodeLocationDetails.getPostcode(), postcodeLocationDetails.getLatitude(),
				postcodeLocationDetails.getLongitude());

		return postcodeLocationDisplay;
	}
}
