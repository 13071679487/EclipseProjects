package bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import dao.ItemDao;

/**
 * 
 * @author Lifu 购物车类，为了方便数据不采取存储在数据库的方式
 */
public class Cart {
	private HashMap<Item, Integer> goods; // 商品清单
	private Double totalPrice; // 总价格

	public Cart() {
		goods = new HashMap<>();
		totalPrice = 0.0;
	}

	public HashMap<Item, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Item, Integer> goods) {
		this.goods = goods;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 添加商品进购物车
	 * @param i
	 * @param n
	 */
	public boolean addItemToCart(Item i, Integer n) {
		printAllGoods();
		if(!isExist(i))
		{
			goods.put(i, n);
		}
		else {
			Item item=getItemInSet(i);
			goods.put(item, n+goods.get(item));
		}
		calcTotalPrice();
		return true;
	}
	
	private Item getItemInSet(Item i){
		Set<Item> keys=goods.keySet();
		Iterator<Item> it=keys.iterator();
		while(it.hasNext()){
			Item item=it.next();
			if(i.getId()==item.getId()){
				return item;
			}
		}
		return null;
	}
	private void printAllGoods(){
		Set<Item> keys=goods.keySet();
		Iterator<Item> i=keys.iterator();
		while(i.hasNext()){
			Item item=i.next();
			System.out.println(item.getId()+"--"+item.getItem_name()+"----"+goods.get(item));
		}
	}
	
	/**
	 * 从购物车中移除商品
	 * true,移除成功
	 * false,失败
	 * @param i
	 * @return
	 */
	public boolean removeFromCart(Item i) {
		if(isExist(i)){
			goods.remove(i);
			calcTotalPrice();
			return true;
		}
		return false;
	}
	
	/**
	 * 计算总金额
	 * @return
	 */
	public void calcTotalPrice(){
		double sum=0.0;
		Set<Item> keys=goods.keySet();
		Iterator<Item> i=keys.iterator();
		while(i.hasNext()){
			Item item=i.next();
			double price=item.getItem_price()*goods.get(item);
			sum+=price;
		}
		this.setTotalPrice(sum);
	}
	
	/**
	 * false,不存在相同的商品
	 * true,相反
	 * @param i
	 * @return
	 */
	public boolean isExist(Item i){
		Set<Item> keys=goods.keySet();
		Iterator<Item> it=keys.iterator();
		while(it.hasNext()){
			Item item=it.next();
			if(i.getId()==item.getId())
				return true;
		}
		return false;
	}
	
	/**
	 * 测试部分
	 */
	public static void main(String[] args) {
		ItemDao id=new ItemDao();
		ArrayList<Item> items=id.getAllItem();
		Item i1=items.get(0);
		Item i2=items.get(1);
		Item i3=items.get(2);
		Cart c=new Cart();
		c.addItemToCart(i1, 5);
		c.addItemToCart(i2, 3);
		Set<Item> keys=c.getGoods().keySet();
		Iterator<Item> it=keys.iterator();
		while(it.hasNext()){
			Item item=it.next();
			System.out.println(item.getItem_name()+"---单价"+item.getItem_price()+"数量:"+c.getGoods().get(item));
		}
		System.out.println("总价格是："+c.getTotalPrice());
		boolean b=c.removeFromCart(i3);
		if(b){
			System.out.println("移除成功");
		}else{
			System.out.println("移除失败");
		}
		System.out.println("总价格是："+c.getTotalPrice());
	}
	
}
