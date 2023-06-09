package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonItemFactory {

    private static final Logger log = LogManager.getLogger(CommonItemFactory.class);

    /**
     * Method to create individual items
     * @param itemType String containing the item Name
     * @return         Corresponding item
     * @throws IllegalArgumentException when itemType is not defined
     */

    public Item createItem(String itemType) throws IllegalArgumentException{

        switch (itemType) {
            case "Cookbook" -> {
                log.info("Cookbook was created");
                return new Cookbook();
            }
            case "Glasses" -> {
                log.info("Glasses were created");
                return new Glasses();
            }
            case "Note1" -> {
                log.info("Note1 was created");
                return new Note1();
            }
            case "Note2" -> {
                log.info("Note2 was created");
                return new Note2();
            }
            case "Note3" -> {
                log.info("Note3 was created");
                return new Note3();
            }
            case "Note4" -> {
                log.info("Note4 was created");
                return new Note4();
            }
            case "Note5" -> {
                log.info("Note5 was created");
                return new Note5();
            }
            case "Note6" -> {
                log.info("Note6 was created");
                return new Note6();
            }
            case "Pliers" -> {
                log.info("Note6 was created");
                return new Pliers();
            }
            case "Rope" -> {
                log.info("Rope was created");
                return new Rope();
            }
            case "Book" -> {
                log.info("Book was created");
                return new Book();
            }
            case "CD" -> {
                log.info("CD was created");
                return new CD();
            }
            default -> throw new IllegalArgumentException("Item not existing");
        }
    }

    /**
     * Method to create all common items at once
     * @return Observable List of common items
     * @throws IllegalArgumentException when itemType is not defined, shows error screen
     */
    public ObservableList<Item> createAllItems() throws IllegalArgumentException {

        final ObservableList<Item> itemList = FXCollections.observableArrayList();

        try {
            itemList.add(createItem("Book"));
            itemList.add(createItem("CD"));
            itemList.add(createItem("Cookbook"));
            itemList.add(createItem("Glasses"));
            itemList.add(createItem("Note1"));
            itemList.add(createItem("Note2"));
            itemList.add(createItem("Note3"));
            itemList.add(createItem("Note4"));
            itemList.add(createItem("Note5"));
            itemList.add(createItem("Note6"));
            itemList.add(createItem("Pliers"));
            itemList.add(createItem("Rope"));
        }
        catch (IllegalArgumentException aE){
            log.error(aE);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }
        return itemList;

    }

}
