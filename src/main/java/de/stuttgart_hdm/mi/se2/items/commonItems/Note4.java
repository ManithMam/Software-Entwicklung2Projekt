package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note4 extends Item {

    /**
     * Inheritance from abstract class Item
     * Item properties set through getters to keep encapsulation
     */

    protected Note4(){
        this.id = ++idCount;
        setName("Note between books");
        setDesc("\"...her heart burns with passion, every step she takes.\nA light she ignites, with no darkness to survive.\"\n Now it's really getting weird.");
        setPickable(false);
        itemList.add(this);
    }

}
