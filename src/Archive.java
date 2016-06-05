import java.util.Arrays;

public class Archive {
	int date;
	Transaction [] transactionToday =  new Transaction[20];
	Transaction [][] allTransaction =  new Transaction[30][20];
	
	Archive(){
		date = 5;
	}
	
	public void setTransactionToday(Transaction transToday) {
		for (int i = 0; i<20; i++){
			if (transactionToday[i]==null){
				transactionToday[i]=transToday;
				break;
			}
		}
	}

	public void setDate(int date) {
		if (this.date!=date){
			setAllTransaction(transactionToday);
			transactionToday = new Transaction[20];
		    this.date = date;}
	}

	public void setAllTransaction(Transaction[] transactionToday) {
        allTransaction[date] = transactionToday;
	}

	public Transaction[][] getAllTransaction() {
		return allTransaction;
	}
	
	public Transaction[] getTransactionToday() {
		return transactionToday;
	}
}
