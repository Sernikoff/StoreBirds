
public class Birds {
protected String name;
protected int count;
protected int price;
protected Categories category;

static Birds [] birds = new Birds[8];
 

public void setName(String name) {
	this.name = name;
}

public void setBirds(Birds bird) {
	for (int i = 0; i<this.birds.length; i++){
		if (birds[i]==null){
			birds[i]=bird; 
			break;
		}
	}
}

public static  Birds[] getBirds() {
	return birds;
}

public String getName() {
	return name;
}

public void setCount(int count) {
	this.count-= count;
}
public void setPrice(int price) {
	this.price = price;
}
public int getCount() {
	return count;
}
public int getPrice() {
	return price;
}
public Categories getCategory() {
	return category;
}



}
