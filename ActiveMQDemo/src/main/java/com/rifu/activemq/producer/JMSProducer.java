package com.rifu.activemq.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSProducer {
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER;
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL;
	
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; 	//���ӹ���
		Connection connection=null;		//����
		Session session=null;			//�Ự�����ܻ��߷�����Ϣ���߳�
		Destination destination;		//��Ϣ��Ŀ�ĵ�
		MessageProducer messageProducer;	//��Ϣ������
		
		connectionFactory=new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
		try {
			connection=connectionFactory.createConnection();		//ͨ��������ȡ����
			connection.start();									//��������
			/**
			 * true,��������ڷ�����Ϣʱ��Ҫ��������ڽ�����Ϣ��ʱ����
			 * AUTO_ACKNOWLEDGE,��Ϣ�ķ��ͺ�ȷ�Ͻ��յĻ��ƣ�һ��ʹ�����ֵ
			 */
			session=connection.createSession(true, Session.AUTO_ACKNOWLEDGE);	
			destination=session.createQueue("Message queue one");
			messageProducer = session.createProducer(destination);
			sendMessage(session, messageProducer); // ������Ϣ
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ������Ϣ
	 * @param session
	 * @param messageProducer
	 * @throws Exception
	 */
	public static void sendMessage(Session session,MessageProducer messageProducer)throws Exception{
		for(int i=0;i<10;i++){
			TextMessage message=session.createTextMessage("ActiveMQ ���͵���Ϣ"+i);
			System.out.println("������Ϣ��"+"ActiveMQ ���͵���Ϣ"+i);
			messageProducer.send(message);
		}
	}
}
