package items.furniture;

import items.Item;

public class FurnitureFactory {

    public Item createFurniture(String itemType){

        switch (itemType){
            case "Sofa":
                return new Sofa();
            case "Chair":
                return new Chair();
            case "Table":
                return new Table();
            default:
                return null;
        }
    }

    public void createAllFurniture(){
        Item sofa = new Sofa();
        Item chair = new Chair();
        Item table = new Table();
    }

}
