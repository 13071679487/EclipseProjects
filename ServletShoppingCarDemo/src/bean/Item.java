package bean;

public class Item {
	private int id;
	private String item_name;
	private String item_city;
	private double item_price;
	private int item_number;
	private String item_picture;

	public Item() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_city() {
		return item_city;
	}

	public void setItem_city(String item_city) {
		this.item_city = item_city;
	}

	public double getItem_price() {
		return item_price;
	}

	public void setItem_price(double item_price) {
		this.item_price = item_price;
	}

	public int getItem_number() {
		return item_number;
	}

	public void setItem_number(int item_number) {
		this.item_number = item_number;
	}

	public String getItem_picture() {
		return item_picture;
	}

	public void setItem_picture(String item_picture) {
		this.item_picture = item_picture;
	}

}
