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
 * 订阅者
 * @author Lifu
 *
 */
public class JMSSubscriber {
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; // 连接工厂
		Connection connection = null; // 连接
		Session session; // 会话 接受或者发送消息的线程
		Destination destination; // 消息的目的地
		MessageConsumer messageConsumer; // 消息的消费者
		
		// 实例化连接工厂
		connectionFactory=new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
				
		try {
			connection=connectionFactory.createConnection();  // 通过连接工厂获取连接
			connection.start(); // 启动连接
			session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); // 创建Session
			destination=session.createTopic("Topic one");
			messageConsumer=session.createConsumer(destination); // 创建消息消费者
			messageConsumer.setMessageListener(new SubscriberListener()); // 注册消息监听
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
