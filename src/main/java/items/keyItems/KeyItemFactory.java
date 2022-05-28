package items.keyItems;

import items.Item;
import items.commonItems.BaseballBat;
import items.commonItems.Hammer;
import items.commonItems.Rope;

public class KeyItemFactory {

    public Item createItem(String itemType){

        switch (itemType){
            case "Bathroom key":
                return new BathroomKey();
            case "Car key":
                return new CarKey();
            case "Kitchen key":
                return new KitchenKey();
            case "Library key":
                return new LibraryKey();
            default:
                return null;
        }
    }

    public void createAllKeyItems(){
        Item bathroomKey = new BathroomKey();
        Item carKey = new CarKey();
        Item kitchenKey = new KitchenKey();
        Item libraryKey = new LibraryKey();
    }

}
