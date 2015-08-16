package uk.co.keithsjohnson.postcode.location.finder.service.api;

import uk.co.keithsjohnson.postcode.location.finder.service.api.model.PostcodeLocationDisplay;

public interface PostcodeLocationDetailsRetriever {

	PostcodeLocationDisplay retrievePostcodeLocationDisplayForPostcode(String postcode);
}
