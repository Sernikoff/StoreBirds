
public class Launcher {

	public static void main(String[] args) {
		ActionStore as = new ActionStore();
		as.demoShop();

		BirdshopUI ui = new BirdshopUI(as);
//SimpleTable st = new SimpleTable(as);
//st.createAndShowGUI();
		//new SimpleTable(as).createAndShowGUI();
		
	}

}
