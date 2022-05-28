package items.furniture;

import items.Furniture;

public class Table extends Furniture {

    public Table(){
        this.id = ++idCount;
        setName("Table");
        setDesc("A sturdy wooden table");
        furnitureList.add(this);
    }

}
