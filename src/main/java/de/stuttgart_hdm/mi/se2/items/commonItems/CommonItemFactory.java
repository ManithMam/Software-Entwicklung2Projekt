package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class CommonItemFactory {

    public Item createItem(String itemType){

        return switch (itemType) {
            case "Cookbook" -> new Cookbook();
            case "Glasses" -> new Glasses();
            case "Hammer" -> new Hammer();
            case "Knife" -> new Knife();
            case "Rope" -> new Rope();
            default -> null;
        };
    }

    public void createAllItems(){
        Item cookbook = new Cookbook();
        Item glasses = new Glasses();
        Item hammer = new Hammer();
        Item knife = new Knife();
        Item rope = new Rope();

    }

}
