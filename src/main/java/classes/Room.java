package classes;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private String description;

    //private List<Item> itemList = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private String getDescription(){
        return this.description;
    }


}
