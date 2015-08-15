package uk.co.keithsjohnson.postcode.location.finder.service.impl;

import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationDisplayAuditProcessor;

@Component
public class PostcodeLocationDisplayAuditProcessorImpl implements PostcodeLocationDisplayAuditProcessor {

	/**
	 * Process Message from PostcodeLocationDisplayAuditQueue
	 */
	@Override
	public void processPostcodeLocationDisplayAuditQueueMessage(String message) {

		// Write PostcodeLocationDisplayed to DynamoDB PostcodeLocationAudit
		// table

	}
}
