package de.stuttgart_hdm.mi.se2.items.furniture;



import de.stuttgart_hdm.mi.se2.items.Item;

//import static de.stuttgart_hdm.mi.se2.Main.items;

public class FurnitureFactory {

    public Item createFurniture(String itemType){

        return switch (itemType) {
            case "Sofa" -> new Sofa();
            case "Chair" -> new Chair();
            case "Table" -> new Table();
            case "Bed" -> new Bed();
            case "Sink" -> new Sink();
            case "Toilet" -> new Toilet();
            default -> throw new IllegalArgumentException("Furniture not existing");
        };
    }

    public void createAllFurniture(){
        Item sofa = new Sofa();
        Item chair = new Chair();
        Item table = new Table();
        Item bed = new Bed();
        Item toilet = new Toilet();
        Item sink = new Sink();
    }

}
