package uk.co.keithsjohnson.postcode.location.finder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.finder.infrastructure.PostcodeLocationDisplayAuditQueueSender;
import uk.co.keithsjohnson.postcode.location.finder.infrastructure.PostcodeLocationDisplayQueueSender;
import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationFinderProcessor;

@Component
public class PostcodeLocationFinderProcessorImpl implements PostcodeLocationFinderProcessor {

	@Autowired
	private PostcodeLocationDisplayQueueSender postcodeLocationDisplayQueueSender;

	@Autowired
	private PostcodeLocationDisplayAuditQueueSender postcodeLocationDisplayAuditQueueSender;

	/**
	 * Process Message from PostcodeLocationFinderQueue
	 */
	@Override
	public void processPostcodeLocationFinderQueueMessage(String message) {

		// Lookup Postcode from DynamoDB PostcodeLocation table

		// If found write PostcodeLocation message to
		// PostcodeLocationDisplayQueue
		postcodeLocationDisplayQueueSender.send(message);

		// If found write PostcodeLocation message to
		// PostcodeLocationDisplayAuditQueue
		postcodeLocationDisplayAuditQueueSender.send(message);
	}
}
