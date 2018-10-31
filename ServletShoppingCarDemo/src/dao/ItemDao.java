package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Item;
import util.DBHelper;

public class ItemDao {
	
	public Item getItemById(int id){
		Item item=null;
		Connection conn=null;
		try{
			String sql="select * from items where id="+id;
			conn=DBHelper.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				item=new Item();
				item.setId(id);
				item.setItem_city(rs.getString("item_city"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_number(rs.getInt("item_number"));
				item.setItem_price(rs.getDouble("item_price"));
				item.setItem_picture(rs.getString("item_picture"));
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return item;
	}
	public ArrayList<Item> getAllItem(){
		Connection conn=null;
		ArrayList<Item> results = new ArrayList<>();
		try {
			String sql="select * from items";
			conn=DBHelper.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Item item=new Item();
				item.setId(rs.getInt("id"));
				item.setItem_city(rs.getString("item_city"));
				item.setItem_name(rs.getString("item_name"));
				item.setItem_number(rs.getInt("item_number"));
				item.setItem_price(rs.getDouble("item_price"));
				item.setItem_picture(rs.getString("item_picture"));
				results.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return results;
	}
}
