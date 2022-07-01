package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class Note1 extends Item {

    protected Note1(){
        this.id = ++idCount;
        setName("Letter");
        setDesc("What's this? \"Try your best, try hard for me,\nyou can never escape!\" This ain't funny!\n I better get going quick!");
        setPickable(false);
        itemList.add(this);
    }

}
