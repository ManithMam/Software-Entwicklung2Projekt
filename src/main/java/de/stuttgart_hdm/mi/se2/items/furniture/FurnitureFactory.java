package de.stuttgart_hdm.mi.se2.items.furniture;



import de.stuttgart_hdm.mi.se2.gui.Resource;
import de.stuttgart_hdm.mi.se2.gui.Utils;
import de.stuttgart_hdm.mi.se2.gui.view.GameView;
import de.stuttgart_hdm.mi.se2.items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import static de.stuttgart_hdm.mi.se2.Main.items;

public class FurnitureFactory {

    private static final Logger log = LogManager.getLogger(FurnitureFactory.class);

    public Item createFurniture(String itemType) throws IllegalArgumentException{

        switch (itemType) {
            case "Sofa" -> {
                log.info("Sofa has been created");
                return new Sofa();
            }
            case "Chair" -> {
                log.info("Chair has been created");
                return new Chair();
            }
            case "Table" -> {
                log.info("Table has been created");
                return new Table();
            }
            case "Bed" -> {
                log.info("Bed has been created");
                return new Bed();
            }
            case "Sink" -> {
                log.info("Sink has been created");
                return new Sink();
            }
            case "Toilet" -> {
                log.info("Toilet has been created");
                return new Toilet();
            }
            default -> throw new IllegalArgumentException("Furniture not existing");
        }
    }

    public ObservableList<Item> createAllFurniture(){

        final ObservableList <Item> furnitureList = FXCollections.observableArrayList();

        try {
            furnitureList.add(createFurniture("Bed"));
            furnitureList.add(createFurniture("Chair"));
            furnitureList.add(createFurniture("Sink"));
            furnitureList.add(createFurniture("Sofa"));
            furnitureList.add(createFurniture("Table"));
            furnitureList.add(createFurniture("Toilet"));
        }
        catch (IllegalArgumentException aE){
            log.error(aE);
            Parent root = Utils.loadFxml(Resource.ERROR_SCREEN);
            GameView.getPrimaryStage().getScene().setRoot(root);
            root.requestFocus();
        }
        return furnitureList;
    }

}
