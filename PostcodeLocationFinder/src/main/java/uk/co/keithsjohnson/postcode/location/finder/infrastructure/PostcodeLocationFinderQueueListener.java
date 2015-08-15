package uk.co.keithsjohnson.postcode.location.finder.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationFinderProcessor;

@Component
public class PostcodeLocationFinderQueueListener {

	private static final String POSTCODELOCATIONFINDERQUEUE = "PostcodeLocationFinderQueue";

	@Autowired
	private PostcodeLocationFinderProcessor postcodeLocationFinderProcessor;

	@MessageMapping(POSTCODELOCATIONFINDERQUEUE)
	public void postcodeLocationFinderQueueListener(String message) {
		System.out.println("SQS " + POSTCODELOCATIONFINDERQUEUE + " message received processing: " + message);
		postcodeLocationFinderProcessor.processPostcodeLocationFinderQueueMessage(message);
		System.out.println("SQS " + POSTCODELOCATIONFINDERQUEUE + " message received processed: " + message);
	}

}
