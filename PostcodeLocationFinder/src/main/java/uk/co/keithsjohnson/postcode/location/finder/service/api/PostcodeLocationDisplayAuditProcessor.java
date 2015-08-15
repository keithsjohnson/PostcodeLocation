package uk.co.keithsjohnson.postcode.location.finder.service.api;

public interface PostcodeLocationDisplayAuditProcessor {

	void processPostcodeLocationDisplayAuditQueueMessage(String message);
}
