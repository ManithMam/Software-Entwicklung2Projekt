package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class KeyItemFactory {

    public Item createItem(String itemType){

        return switch (itemType) {
            case "Baseball bat" -> new BaseballBat();
            case "Clock" -> new Clock();
            case "Exit key" -> new ExitKey();
            case "Flashlight" -> new Flashlight();
            case "Kitchen torch" -> new KitchenTorch();
            case "Knife" -> new Knife();
            case "Toothbrush" -> new Toothbrush();
            default -> throw new IllegalArgumentException("KeyItem not existing");
        };
    }

    public ObservableList<Item> createAllKeyItems(){

        final ObservableList <Item> keyItemList = FXCollections.observableArrayList();
        keyItemList.add(createItem("Baseball bat"));
        keyItemList.add(createItem("Clock"));
        keyItemList.add(createItem("Kitchen torch"));
        keyItemList.add(createItem("Library key"));
        keyItemList.add(createItem("Knife"));
        keyItemList.add(createItem("Exit key"));
        keyItemList.add(createItem("Toothbrush"));
        keyItemList.add(createItem("Flashlight"));
        return keyItemList;
    }

}
