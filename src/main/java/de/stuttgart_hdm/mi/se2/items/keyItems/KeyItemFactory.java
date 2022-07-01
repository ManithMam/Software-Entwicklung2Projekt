package de.stuttgart_hdm.mi.se2.items.keyItems;

import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.Item;
import de.stuttgart_hdm.mi.se2.items.furniture.FurnitureFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class KeyItemFactory {

    private static final Logger log = LogManager.getLogger(KeyItemFactory.class);

    public Item createItem(String itemType) throws IllegalArgumentException{

        switch (itemType) {
            case "Baseball bat" -> {
                log.info("Baseball bat was created");
                return new BaseballBat();
            }
            case "Watch" -> {
                log.info("Watch was created");
                return new Watch();
            }
            case "Exit key" -> {
                log.info("Exit key was created");
                return new ExitKey();
            }
            case "Flashlight" -> {
                log.info("Flashlight was created");
                return new Flashlight();
            }
            case "Kitchen torch" -> {
                log.info("Kitchen torch was created");
                return new KitchenTorch();
            }
            case "Knife" -> {
                log.info("Knife was created");
                return new Knife();
            }
            case "Toothbrush" -> {
                log.info("Toothbrush was created");
                return new Toothbrush();
            }
            default -> throw new IllegalArgumentException("KeyItem not existing");
        }
    }

    public ObservableList<Item> createAllKeyItems(){

        final ObservableList <Item> keyItemList = FXCollections.observableArrayList();

        try {
            keyItemList.add(createItem("Baseball bat"));
            keyItemList.add(createItem("Watch"));
            keyItemList.add(createItem("Kitchen torch"));
            keyItemList.add(createItem("Knife"));
            keyItemList.add(createItem("Exit key"));
            keyItemList.add(createItem("Toothbrush"));
            keyItemList.add(createItem("Flashlight"));
        }
        catch (IllegalArgumentException aE){
            log.error(aE);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }
        return keyItemList;
    }

}
