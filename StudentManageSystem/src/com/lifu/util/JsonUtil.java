package com.lifu.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	/**
	 * 将结果集转换成jsonarray
	 * 
	 * @param rs
	 * @return
	 * @throws Exception
	 */
	public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception {
		ResultSetMetaData md = rs.getMetaData();
		int num = md.getColumnCount();
		JSONArray array = new JSONArray();
		while (rs.next()) {
			JSONObject obj = new JSONObject();
			for (int i = 1; i <= num; i++) {
				Object o = rs.getObject(i);
				if (o instanceof Date) {
					obj.put(md.getColumnName(i), DateUtil.formatDate((Date) o, "yyyy-MM-dd"));
				} else
					obj.put(md.getColumnName(i), rs.getObject(i));
			}
			array.add(obj);
		}
		return array;

	}
}
