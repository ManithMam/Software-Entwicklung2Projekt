package de.stuttgart_hdm.mi.se2.rooms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoomFactory {

    private static final Logger log = LogManager.getLogger(RoomFactory.class);

    public Room createRoom(String roomType) throws IllegalArgumentException{
        switch (roomType) {
            case "Basement" -> {
                log.info("Basement was created");
                return new Basement();

            }
            case "Kitchen" -> {
                log.info("Kitchen was created");
                return new Kitchen();

            }
            case "Hallway" -> {
                log.info("Hallway was created");
                return new Hallway();


            }
            case "Library" -> {
                log.info("Library was created");
                return new Library();


            }
            case "Bathroom" -> {
                log.info("Bathroom was created");
                return new Bathroom();


            }
            case "Exit" -> {
                log.info("Exitroom was created");
                return new Exit();


            }
            default -> {
                log.warn("IllegalArgument was given. IllegalArgumentExceptions gets thrown.");
                throw new IllegalArgumentException("Roomtype not existing");
            }

        }
    }
}
