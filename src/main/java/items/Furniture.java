package items;

import java.util.ArrayList;

public abstract class Furniture implements furnitureInterface {

    protected int id;
    protected static int idCount = 0;
    private String name;
    private String desc;
    protected ArrayList<Furniture> furnitureList = new ArrayList<Furniture>();

    public int getId(){return this.id;}

    public String getDesc(){return this.desc;}

    public String getName(){return this.name;}

    public void setId(int id){this.id = id;}

    public void setName(String name){this.name = name;}

    public void setDesc(String desc){this.desc = desc;}
}
