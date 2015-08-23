package uk.co.keithsjohnson.postcode.location.finder.service.impl;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.finder.infrastructure.sqs.PostcodeLocationDisplayAuditQueueSender;
import uk.co.keithsjohnson.postcode.location.finder.infrastructure.sqs.PostcodeLocationDisplayQueueSender;
import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationDetailsRetriever;
import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationFinderProcessor;
import uk.co.keithsjohnson.postcode.location.finder.service.api.model.Postcode;
import uk.co.keithsjohnson.postcode.location.finder.service.api.model.PostcodeLocationDisplay;

@Component
public class PostcodeLocationFinderProcessorImpl implements PostcodeLocationFinderProcessor {

	@Autowired
	private PostcodeLocationDetailsRetriever postcodeLocationDetailsRetriever;

	@Autowired
	private PostcodeLocationDisplayQueueSender postcodeLocationDisplayQueueSender;

	@Autowired
	private PostcodeLocationDisplayAuditQueueSender postcodeLocationDisplayAuditQueueSender;

	@Autowired
	private ConvertPostcodeLocationDisplayToJSON convertPostcodeLocationDisplayToJSON;

	@Autowired
	private ConvertJSONToPostcode convertJSONToPostcode;

	/**
	 * Process Message from PostcodeLocationFinderQueue
	 */
	@Override
	public void processPostcodeLocationFinderQueueMessage(String postcodesJSONString) {

		List<Postcode> postcodesList = convertJSONToPostcode.convert(postcodesJSONString);

		postcodesList.stream().forEach(processPostcode);
	}

	private Consumer<Postcode> processPostcode = (Postcode postcode) -> {
		// Lookup Postcode from DynamoDB PostcodeLocation table
		PostcodeLocationDisplay postcodeLocationDisplay = postcodeLocationDetailsRetriever
				.retrievePostcodeLocationDisplayForPostcode(postcode.getPostcode());

		// If found write PostcodeLocation message to
		// PostcodeLocationDisplayQueue
		postcodeLocationDisplayQueueSender.send(convertPostcodeLocationDisplayToJSON.convert(postcodeLocationDisplay));

		// If found write PostcodeLocation message to
		// PostcodeLocationDisplayAuditQueue
		postcodeLocationDisplayAuditQueueSender.send(postcode.getPostcode());

	};
}
