package de.stuttgart_hdm.mi.se2.rooms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoomFactory {

    private static final Logger log = LogManager.getLogger(RoomFactory.class);

    public Room createRoom(String roomType)
    {
        return switch (roomType) {
            case "Basement" -> new Basement();                                                      //TODO: ist es hier möglich Logger zu informieren ?
            case "Kitchen" -> new Kitchen();
            case "Hallway" -> new Hallway();
            case "Library" -> new Library();
            case "Bathroom" -> new Bathroom();
            default -> throw new IllegalArgumentException("Roomtype not existing");
        };
    }
}
