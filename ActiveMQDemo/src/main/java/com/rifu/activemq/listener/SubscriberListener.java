package com.rifu.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SubscriberListener implements MessageListener{

	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		try {
			System.out.println("����Ƶ����"+((TextMessage)msg).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
