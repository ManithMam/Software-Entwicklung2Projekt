package de.stuttgart_hdm.mi.se2.items;

import java.util.List;
import java.util.ArrayList;

public abstract class Item implements ItemInterface {

    protected int id;
    protected static int idCount = 0;
    private String name;
    private boolean pickable;
    private String desc;
    protected static List<Item> itemList = new ArrayList<>();
    protected static List<Item> furnitureList = new ArrayList<>();

    public int getId(){return this.id;}

    public boolean isPickable(){return this.pickable;}

    public String getDesc(){return this.desc;}

    public String getName(){return this.name;}

    public void setId(int id){this.id = id;}

    public void setName(String name){this.name = name;}

    public void setPickable(boolean pickable){this.pickable = pickable;}

    public void setDesc(String desc){this.desc = desc;}

    @Override
    public String toString() {
        return this.name;
    }
}
