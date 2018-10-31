package com.rifu.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("myBean")
public class Pojo {
	public void printMessage(){
		Date date=new Date(); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//System.out.println("myBean is execute at:"+sdf.format(date));
	}
}
