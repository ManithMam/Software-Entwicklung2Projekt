package de.stuttgart_hdm.mi.se2.items.commonItems;

import de.stuttgart_hdm.mi.se2.items.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonItemFactory {

    private static final Logger log = LogManager.getLogger(CommonItemFactory.class);

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
            default -> throw new IllegalArgumentException("Item not existing");
        }
    }

    public void createAllItems(){
        Item cookbook = new Cookbook();
        Item glasses = new Glasses();
        Item note1 = new Note1();
        Item note2 = new Note2();
        Item note3 = new Note3();
        Item note4 = new Note4();
        Item note5 = new Note5();
        Item note6 = new Note6();
        Item pliers = new Pliers();
        Item rope = new Rope();
        Item book = new Book();

    }

}
