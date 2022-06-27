package de.stuttgart_hdm.mi.se2.rooms;

import de.stuttgart_hdm.mi.se2.items.Item;

import de.stuttgart_hdm.mi.se2.items.keyItems.KitchenTorch;
import de.stuttgart_hdm.mi.se2.items.keyItems.Knife;

import java.util.List;

public class Library extends Room {


    protected Library() {
        this.id = ++idCounter;
        setAccess(false);
        setName("Library");
        setDescription("I can probably find some useful information in the books.\nHere are three bookshelf all filled up to the brim.\nThat could take some time.");
        setDoorDescription("The door knob feels colder then my ex´s heart.\nThe knob looks frozen\nI can barely touch it now");
        addItemsInRoom(getKeyItemList().stream().filter(Knife.class::isInstance).toList().get(0));
        final Item glasses = getItemFactory().createItem("Glasses");
        final Item chair = getFurnitureFactory().createFurniture("Chair");
        final Item book = getItemFactory().createItem("Book");
        final Item note6 = getItemFactory().createItem("Note6");
        addItemsInRoom(note6);
        addItemsInRoom(glasses);
        addItemsInRoom(chair);
        addItemsInRoom(book);
    }

    public List<Integer> neededItem()
    {
        return getKeyItemList().stream().filter(KitchenTorch.class::isInstance).map(Item::getId).toList();
    }
}
