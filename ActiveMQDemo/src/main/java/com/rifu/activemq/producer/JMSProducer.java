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
		ConnectionFactory connectionFactory; 	//连接工厂
		Connection connection=null;		//连接
		Session session=null;			//会话，接受或者发送消息的线程
		Destination destination;		//消息的目的地
		MessageProducer messageProducer;	//消息生产者
		
		connectionFactory=new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
		try {
			connection=connectionFactory.createConnection();		//通过工厂获取连接
			connection.start();									//启动连接
			/**
			 * true,开启事物，在发送消息时需要开启事物，在接受消息的时候不用
			 * AUTO_ACKNOWLEDGE,消息的发送和确认接收的机制，一般使用这个值
			 */
			session=connection.createSession(true, Session.AUTO_ACKNOWLEDGE);	
			destination=session.createQueue("Message queue one");
			messageProducer = session.createProducer(destination);
			sendMessage(session, messageProducer); // 发送消息
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送消息
	 * @param session
	 * @param messageProducer
	 * @throws Exception
	 */
	public static void sendMessage(Session session,MessageProducer messageProducer)throws Exception{
		for(int i=0;i<10;i++){
			TextMessage message=session.createTextMessage("ActiveMQ 发送的消息"+i);
			System.out.println("发送消息："+"ActiveMQ 发送的消息"+i);
			messageProducer.send(message);
		}
	}
}
