package uk.co.keithsjohnson.postcode.location.finder.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PostcodeLocationDisplayQueueSender {

	private static final String POSTCODELOCATIONDISPLAYQUEUE = "PostcodeLocationDisplayQueue";

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	public void send(String message) {
		Message<String> messageObject = MessageBuilder.withPayload(message).build();
		System.out.println("SQS " + POSTCODELOCATIONDISPLAYQUEUE + " message senting: " + messageObject.toString());
		this.queueMessagingTemplate.send(POSTCODELOCATIONDISPLAYQUEUE, messageObject);
		System.out.println("SQS " + POSTCODELOCATIONDISPLAYQUEUE + " message sent: " + messageObject.toString());
	}

}
