package com.rifu.activemq.consumer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.fusesource.mqtt.cli.Listener;

import com.rifu.activemq.listener.SubscriberListener;

/**
 * ������
 * @author Lifu
 *
 */
public class JMSSubscriber {
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER; // Ĭ�ϵ������û���
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; // Ĭ�ϵ���������
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL; // Ĭ�ϵ����ӵ�ַ
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; // ���ӹ���
		Connection connection = null; // ����
		Session session; // �Ự ���ܻ��߷�����Ϣ���߳�
		Destination destination; // ��Ϣ��Ŀ�ĵ�
		MessageConsumer messageConsumer; // ��Ϣ��������
		
		// ʵ�������ӹ���
		connectionFactory=new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
				
		try {
			connection=connectionFactory.createConnection();  // ͨ�����ӹ�����ȡ����
			connection.start(); // ��������
			session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // ����Session
			destination=session.createTopic("Topic one");
			messageConsumer=session.createConsumer(destination); // ������Ϣ������
			messageConsumer.setMessageListener(new SubscriberListener()); // ע����Ϣ����
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
