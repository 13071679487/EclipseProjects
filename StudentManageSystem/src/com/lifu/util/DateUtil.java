package com.lifu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��������װ�����ַ����Ĺ���
 * @author Lifu
 *
 */
public class DateUtil {
	public static String formatDate(Date date,String format){
		String result="";
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		if(date!=null){
			result=sdf.format(date);
		}
		return result;
	}
	public static Date formatString(String str,String format)throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.parse(str);
	}
}
