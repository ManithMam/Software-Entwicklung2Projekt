package items.keyItems;

import items.Item;

public class LibraryKey extends Item {

    public LibraryKey(){
        this.id = ++idCount;
        setName("Library key");
        setDesc("A key to access the library");
        setPickable(true);
        itemList.add(this);
    }

}
