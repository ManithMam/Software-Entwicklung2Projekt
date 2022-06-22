package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

import java.util.ArrayList;
import java.util.List;

public class KeyItemFactory {

    public Item createItem(String itemType){

        return switch (itemType) {
            case "Bathroom key" -> new BathroomKey();
            case "Car key" -> new CarKey();
            case "Kitchen key" -> new KitchenKey();
            case "Library key" -> new LibraryKey();
            default -> null;
        };
    }

    public List<Item> createAllKeyItems(){

        final List keyItemList = new ArrayList<Item>();
        keyItemList.add(createItem("Bathroom key"));
        keyItemList.add(createItem("Car key"));
        keyItemList.add(createItem("Kitchen key"));
        keyItemList.add(createItem("Library key"));
        return keyItemList;
    }

}
