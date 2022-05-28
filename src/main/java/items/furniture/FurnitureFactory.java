package items.furniture;

import items.Furniture;

public class FurnitureFactory {

    public Furniture createFurniture(String itemType){

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
        Furniture sofa = new Sofa();
        Furniture chair = new Chair();
        Furniture table = new Table();
    }

}
