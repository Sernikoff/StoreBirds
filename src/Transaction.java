
public class Transaction{
	String buyer;
	Birds product;
	int price;
	int count;
	int total;
	Object[] t;
	
	Transaction(){
	}
	
	Transaction(String buyer, Birds product, int count){
		this.buyer = buyer;
		this.product = product;
		price = product.getPrice();
		this.count= count;
		total = price*count;
		product.setCount(count);
		t = new Object[5];
		t[0] =  buyer;
		t[1] = product.getName();
		t[2] = new Integer(price);
		t[3] = new Integer(count);
		t[4] = new Integer(total);
	}
	
	


	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public void setProduct(Birds product) {
		this.product = product;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getBuyer() {
		return buyer;
	}

	public Birds getProduct() {
		return product;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}

	public int getTotal() {
		return total;
	}

	public Object[] getT() {
		
		return t;
	}	
	
}
