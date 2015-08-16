package uk.co.keithsjohnson.postcode.location.request.receiver.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PostcodeLocationFinderQueueSender {

	private static final String POSTCODELOCATIONFINDERQUEUE = "PostcodeLocationFinderQueue";

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	public void send(String message) {
		Message<String> messageObject = MessageBuilder.withPayload(message).build();
		System.out.println("SQS " + POSTCODELOCATIONFINDERQUEUE + " message senting: " + messageObject.toString());
		this.queueMessagingTemplate.send(POSTCODELOCATIONFINDERQUEUE, messageObject);
		System.out.println("SQS " + POSTCODELOCATIONFINDERQUEUE + " message sent: " + messageObject.toString());
	}

}
