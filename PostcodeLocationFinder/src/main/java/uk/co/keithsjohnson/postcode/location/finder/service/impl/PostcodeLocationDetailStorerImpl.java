package uk.co.keithsjohnson.postcode.location.finder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.finder.infrastructure.dynamodb.PostcodeLocationDetails;
import uk.co.keithsjohnson.postcode.location.finder.infrastructure.dynamodb.PostcodeLocationDetailsRepository;
import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationDetailStorer;
import uk.co.keithsjohnson.postcode.location.finder.service.api.model.PostcodeLocation;

@Component
public class PostcodeLocationDetailStorerImpl implements PostcodeLocationDetailStorer {

	@Autowired
	private PostcodeLocationDetailsRepository postcodeLocationDetailsRepository;

	@Override
	public void storePostcodeLocationDisplay(PostcodeLocation postcodeLocation) {

		PostcodeLocationDetails postcodeLocationDetails = new PostcodeLocationDetails();
		postcodeLocationDetails.setPostcode(postcodeLocation.getPostcode());
		postcodeLocationDetails.setLatitude(postcodeLocation.getLatitude());
		postcodeLocationDetails.setLongitude(postcodeLocation.getLongitude());
		postcodeLocationDetails.setPopulation(postcodeLocation.getPopulation());
		postcodeLocationDetails.setHouseholds(postcodeLocation.getHouseholds());

		postcodeLocationDetailsRepository.save(postcodeLocationDetails);
	}
}
