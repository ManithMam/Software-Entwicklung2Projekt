package items.commonItems;

import items.Item;

public class BaseballBat extends Item {

    public BaseballBat(){
        this.id = ++idCount;
        setName("Baseball bat");
        setDesc("A strong negotiation device");
        setPickable(true);
        itemList.add(this);
    }

}
