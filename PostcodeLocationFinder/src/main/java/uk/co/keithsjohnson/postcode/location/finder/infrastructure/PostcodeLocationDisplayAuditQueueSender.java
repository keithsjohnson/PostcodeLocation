package uk.co.keithsjohnson.postcode.location.finder.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PostcodeLocationDisplayAuditQueueSender {

	private static final String POSTCODELOCATIONDISPLAYAUDITQUEUE = "PostcodeLocationDisplayAuditQueue";

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	public void send(String message) {
		Message<String> messageObject = MessageBuilder.withPayload(message).build();
		System.out
				.println("SQS " + POSTCODELOCATIONDISPLAYAUDITQUEUE + " message senting: " + messageObject.toString());
		this.queueMessagingTemplate.send(POSTCODELOCATIONDISPLAYAUDITQUEUE, messageObject);
		System.out.println("SQS " + POSTCODELOCATIONDISPLAYAUDITQUEUE + " message sent: " + messageObject.toString());
	}

}
