package uk.ac.brunel.cs1702;

import java.util.ArrayList;
import java.util.List;


public class MyStore {

	private List<ItemForSale> items = null;
	
	public MyStore() {
		this.items = new ArrayList<ItemForSale>();
	}
	
	public void setItems(List<ItemForSale> items){
		this.items = items;
	}

	public static void main(String[] args) {
       
        MyStore myStore = new MyStore();
        // Item name, number of days to sell in, price
        myStore.items.add(new ItemForSale("Herbal Health Supplements", 10, 5));
        myStore.items.add(new ItemForSale("Aged Parmesan cheese", 20, 10));
        myStore.items.add(new ItemForSale("Local soda drink", 20, 3));
        myStore.items.add(new ItemForSale("World War I Medals", 0, 80));
        myStore.items.add(new ItemForSale("Tickets to Iron Maiden concert", 15, 20));
        myStore.items.add(new ItemForSale("Special cake baked in store", 3, 6));

        myStore.updateInventory();
       
        System.out.println("Inventory Updated!");
    }
	
    public void updateInventory() {
        for (int i = 0; i < items.size(); i++) {        	
    		switch(items.get(i).getName())
    		{
        		case "Aged Parmesan cheese":
        			cheeseCase(i);
        			break;
        			
        		case "Tickets to Iron Maiden concert":
        			concertCase(i);
        			break;
        			
        		case "Special cake baked in store":
        			specialCakeCase(i);
        			break;
        			
        		case "World War I Medals":
        			warMedalCase(i);
        			break;
        			
        		default:
        			defaultCase(i);
        			//items.get(i).setPrice(items.get(i).getPrice() - 1);
        	}

    		// Check price
    		// Cannot be negative or above 50
    		// However, WW1 medal is an exception to this rule
    		if (items.get(i).getPrice() < 0) {
    			items.get(i).setPrice(0);
    		} else if (items.get(i).getPrice() > 50 && !(items.get(i).getName() == "World War I Medals")) {
    			items.get(i).setPrice(50);
    		}
    		
    		if (!items.get(i).getName().equals("World War I Medals") && !items.get(i).getName().equals("Aged Parmesan cheese")) {
    			items.get(i).setNumberOfDaysToSellIn(items.get(i).getNumberOfDaysToSellIn() - 1);
    		}
        }
    }
    
    public void cheeseCase(int index) {
    	if (items.get(index).getNumberOfDaysToSellIn() > 0) {
			items.get(index).setPrice(items.get(index).getPrice() + 1);
		}    	
    }
    
    public void concertCase(int index) {
        items.get(index).setPrice(items.get(index).getPrice() + 1);

        if (items.get(index).getNumberOfDaysToSellIn() <= 10) {
        	items.get(index).setPrice(items.get(index).getPrice() + 1);
        }

        if (items.get(index).getNumberOfDaysToSellIn() <= 5) {
        	items.get(index).setPrice(items.get(index).getPrice() + 1);
        }
        
        if (items.get(index).getNumberOfDaysToSellIn() <= 0) {
			items.get(index).setPrice(0);
        }
    }

    public void warMedalCase(int index) {
    	items.get(index).setPrice(80);
    }

    public void specialCakeCase(int index) {
    	items.get(index).setPrice(items.get(index).getPrice() - 2);
    }
    
    public void defaultCase(int index) {
    	items.get(index).setPrice(items.get(index).getPrice() - 1);
    }
}


