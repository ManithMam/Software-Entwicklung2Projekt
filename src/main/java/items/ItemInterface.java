package items;

public interface ItemInterface {
    int getId();

    boolean isPickable();

    String getDesc();

    String getName();

    void setId(int id);

    void setName(String name);

    void setPickable(boolean pickable);

    void setDesc(String desc);
}
