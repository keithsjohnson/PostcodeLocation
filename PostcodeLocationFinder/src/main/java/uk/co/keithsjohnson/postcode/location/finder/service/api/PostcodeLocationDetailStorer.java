package uk.co.keithsjohnson.postcode.location.finder.service.api;

import uk.co.keithsjohnson.postcode.location.finder.service.api.model.PostcodeLocation;

public interface PostcodeLocationDetailStorer {

	void storePostcodeLocationDisplay(PostcodeLocation postcodeLocation);
}
