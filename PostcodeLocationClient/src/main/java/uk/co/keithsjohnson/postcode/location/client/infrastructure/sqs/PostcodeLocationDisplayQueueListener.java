package uk.co.keithsjohnson.postcode.location.client.infrastructure.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.client.api.PostcodeLocationDisplayer;
import uk.co.keithsjohnson.postcode.location.client.infrastructure.service.ConvertJSONToPostcodeLocation;
import uk.co.keithsjohnson.postcode.location.client.model.PostcodeLocation;

@Component
public class PostcodeLocationDisplayQueueListener {

	private static final String POSTCODELOCATIONDISPLAYQUEUE = "PostcodeLocationDisplayQueue";

	@Autowired
	private PostcodeLocationDisplayer postcodeLocationDisplayer;

	@Autowired
	private ConvertJSONToPostcodeLocation convertJSONToPostcodeLocation;

	@MessageMapping(POSTCODELOCATIONDISPLAYQUEUE)
	public void postcodeLocationFinderQueueAuditListener(String postcodeLocationJSONString) {
		System.out.println(
				"SQS " + POSTCODELOCATIONDISPLAYQUEUE + " message received processing: " + postcodeLocationJSONString);
		PostcodeLocation postcodeLocation = convertJSONToPostcodeLocation.convert(postcodeLocationJSONString);
		postcodeLocationDisplayer.sendPostcodeLocationForDisplayOnMap(postcodeLocation);
		System.out.println(
				"SQS " + POSTCODELOCATIONDISPLAYQUEUE + " message received processed: " + postcodeLocationJSONString);
	}
}
