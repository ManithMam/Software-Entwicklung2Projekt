package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.items.Item;

public class LibraryKey extends Item {

    protected LibraryKey(){
        this.id = ++idCount;
        setName("Library key");
        setDesc("A key to access the library");
        setPickable(true);
        itemList.add(this);
    }

}
