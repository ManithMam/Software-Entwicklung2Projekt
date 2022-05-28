package items.commonItems;

import items.Item;

public class Cookbook extends Item {

    public Cookbook(){
        this.id = ++idCount;
        setName("Cookbook");
        setDesc("A book full of tasty recipes");
        setPickable(true);
        itemList.add(this);
    }

}
