package uk.co.keithsjohnson.postcode.location.finder.infrastructure.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationDisplayAuditProcessor;

@Component
public class PostcodeLocationDisplayAuditQueueListener {

	private static final String POSTCODELOCATIONDISPLAYAUDITQUEUE = "PostcodeLocationDisplayAuditQueue";

	@Autowired
	private PostcodeLocationDisplayAuditProcessor postcodeLocationDisplayAuditProcessor;

	@MessageMapping(POSTCODELOCATIONDISPLAYAUDITQUEUE)
	public void postcodeLocationFinderQueueAuditListener(String message) {
		System.out.println("SQS " + POSTCODELOCATIONDISPLAYAUDITQUEUE + " message received processing: " + message);
		postcodeLocationDisplayAuditProcessor.processPostcodeLocationDisplayAuditQueueMessage(message);
		System.out.println("SQS " + POSTCODELOCATIONDISPLAYAUDITQUEUE + " message received processed: " + message);
	}
}
