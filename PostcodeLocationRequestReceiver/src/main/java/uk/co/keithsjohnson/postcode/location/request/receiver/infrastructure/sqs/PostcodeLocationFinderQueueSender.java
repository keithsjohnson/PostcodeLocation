package uk.co.keithsjohnson.postcode.location.request.receiver.infrastructure.sqs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.request.receiver.service.api.Postcode;
import uk.co.keithsjohnson.postcode.location.request.receiver.service.impl.ConvertPostcodeToJSON;

@Component
public class PostcodeLocationFinderQueueSender {

	private static final String POSTCODELOCATIONFINDERQUEUE = "PostcodeLocationFinderQueue";

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Autowired
	private ConvertPostcodeToJSON convertPostcodeToJSON;

	public void send(String singlePostcode) {

		String postcodeJSONString = convertPostcodeToJSON.convertStringSinglePostcode(singlePostcode);

		sendJSONtoQueue(postcodeJSONString);
	}

	public void send(List<Postcode> postcodes) {
		String postcodeJSONString = convertPostcodeToJSON.convert(postcodes);

		sendJSONtoQueue(postcodeJSONString);
	}

	private void sendJSONtoQueue(String postcodeJSONString) {
		Message<String> messageObject = MessageBuilder.withPayload(postcodeJSONString).build();
		System.out.println("SQS " + POSTCODELOCATIONFINDERQUEUE + " message senting: " + messageObject.toString());
		this.queueMessagingTemplate.send(POSTCODELOCATIONFINDERQUEUE, messageObject);
		System.out.println("SQS " + POSTCODELOCATIONFINDERQUEUE + " message sent: " + messageObject.toString());
	}

}
