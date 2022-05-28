package items.commonItems;

import items.Item;

public class ItemFactory{

    public Item createItem(String itemType){

        switch (itemType){
            case "BaseballBat":
                return new BaseballBat();
            case "Cookbook":
                return new Cookbook();
            case "Glasses":
                return new Glasses();
            case "Hammer":
                return new Hammer();
            case "Knife":
                return new Knife();
            case "Rope":
                return new Rope();
            default:
                return null;
        }
    }

    public void createAllItems(){
        Item baseballBat = new BaseballBat();
        Item cookbook = new Cookbook();
        Item glasses = new Glasses();
        Item hammer = new Hammer();
        Item knife = new Knife();
        Item rope = new Rope();

    }

}
