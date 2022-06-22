package de.stuttgart_hdm.mi.se2.rooms;

public class RoomFactory {

    public Room createRoom(String roomType)
    {

        return switch (roomType) {
            case "Basement" -> new Basement();
            case "Kitchen" -> new Kitchen();
            case "Hallway" -> new Hallway();
            case "Library" -> new Library();
            case "Bathroom" -> new Bathroom();
            default -> null;
        };
    }

    public void createAllRooms()
    {
        Room basement = new Basement();
        Room bathroom = new Bathroom();
        Room hallway = new Hallway();
        Room library = new Library();
        Room kitchen = new Kitchen();
    }
}
