package uk.co.keithsjohnson.postcode.location.client.api;

import uk.co.keithsjohnson.postcode.location.client.model.PostcodeLocation;

public interface PostcodeLocationDisplayer {

	void sendPostcodeLocationForDisplayOnMap(PostcodeLocation postcodeLocation);
}
