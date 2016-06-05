import java.util.Arrays;

public class ActionStore {
Goose   goose;
Duck    duck;
Chicken chicken;
Ostrich ostrich;
Falcon  falcon;
Eagle   eagle;
Transaction tr;
Archive archive;
int today;

	
	ActionStore(){
		goose   = new Goose();
		duck    = new Duck();
		chicken = new Chicken();
		ostrich = new Ostrich();
		falcon  = new Falcon();
		eagle   = new Eagle();
		archive = new Archive();
		today = 12;		
		}
	
	public void demoShop(){
		whatPriceProduct(goose);
		whatPriceProduct(duck);
		
		countStockProduct(goose);
		countStockProduct(falcon);
		countStockProduct(duck);
		
		
		processYesterdayTransaction();
		
		transactoin("Ivanov ", chicken, 4);
		transactoin("Petrov ", duck, 6);
		transactoin("Sidorov", falcon, 1);
		transactoin("Karpov ", eagle, 5);
		
		
		countTransactionsWeek();
		transactionsToday();
		printCatalog();
		
		countStockProduct(duck);
		
		
	}
	
	void whatPriceProduct(Birds bird){
		System.out.println(bird.getName()+" price - "+ bird.getPrice()+"$");
		System.out.println();
		
	}
	
	void countStockProduct(Birds bird){
		System.out.println(bird.getName()+" stock count - "+ bird.getCount()+" shtuk");
		System.out.println();
	}
	
	void processYesterdayTransaction(){
		today = 5;
		archive.setDate(today);
		transactoin("Ivanov ", goose, 4);
		transactoin("Petrov ", duck, 3);
		transactoin("Sidorov", falcon, 2);
		today = 6;
		archive.setDate(today);
		transactoin("Ivanov ", chicken, 1);
		today = 7;
		archive.setDate(today);
		transactoin("Ivanov ", chicken, 7);
		transactoin("Petrov ", duck, 3);
		transactoin("Sidorov", falcon, 2);
		today = 8;
		archive.setDate(today);
		transactoin("Ivanov ", goose, 3);
		transactoin("Petrov ", duck, 1);
		today = 9;
		archive.setDate(today);
		transactoin("Ivanov ", chicken, 3);
		transactoin("Petrov ", duck, 2);
		today = 10;
		archive.setDate(today);
		transactoin("Ivanov ", chicken, 12);
		transactoin("Petrov ", duck, 5);
		transactoin("Sidorov", falcon, 3);
		today = 11;
		archive.setDate(today);
		today = 12;
		archive.setDate(today);
	}
	
	void transactoin(String buyer, Birds product, int count){
		tr = new Transaction(buyer, product, count);
		archive.setTransactionToday(tr);
	}
	
	void countTransactionsWeek(){
		Transaction[][] tt = archive.getAllTransaction();
		for (int i = (today-7); i<today; i++){
			int num = 0;
			for(int j = 0; j<tt[i].length; j++) {
				if(tt[i][j]!=null){num++;
				}
				}
			System.out.println("On date: "+ i+ " - "+num+" transactions.");
			}
	}
	
	void transactionsToday(){
		Transaction [] t = archive.getTransactionToday();
		int allCount=0;
		int allTotal=0;
		System.out.println();
		System.out.println("¹ |   buyer  |  bird  |  price  |  count  | total");
		System.out.println("------------------------------------------------------");
		for (int i = 0; i<t.length; i++){
			if(t[i]!=null){
				allCount+=t[i].getCount();
				allTotal+=t[i].getTotal();
		System.out.println((i+1)+" |  "+t[i].getBuyer()+" | "+t[i].getProduct().getName()+"|   "+
				t[i].getProduct().getPrice()+"    |    "+t[i].getCount()+"    |  "+t[i].getTotal());
		System.out.println("------------------------------------------------------");
			}			
		}
		System.out.println("TOTAL                 |         |    "+allCount+"    |  "+allTotal);
		System.out.println();
	}	
	
	void printCatalog(){
		Birds[] b = Birds.getBirds();
		System.out.println("Category -"+Categories.HOME);
		for (int i = 0; i<b.length; i++){
			if (b[i]!=null && b[i].getCategory()==Categories.HOME){
		System.out.println("Bird - "+b[i].getName());	
		}
	}	
		System.out.println("Category -"+Categories.WILD);
		for (int i = 0; i<b.length; i++){
			if (b[i]!=null && b[i].getCategory()==Categories.WILD){
		System.out.println("Bird - "+b[i].getName());	
		}
	}	System.out.println();
}
}
