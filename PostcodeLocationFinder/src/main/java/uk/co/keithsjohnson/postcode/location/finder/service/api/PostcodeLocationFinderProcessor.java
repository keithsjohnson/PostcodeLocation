package uk.co.keithsjohnson.postcode.location.finder.service.api;

public interface PostcodeLocationFinderProcessor {

	void processPostcodeLocationFinderQueueMessage(String message);
}
