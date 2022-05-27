package rooms;

public class RoomFactory {

    public Room createRoom(String roomType)
    {

        switch(roomType)
        {
            case "Basement":
                return new Basement();
            case "Kitchen":
                return new Hallway();
            case "Hallway":
                return new Kitchen();
            case "Library":
                return new Library();
            case "Bathroom":
                return new Bathroom();
            default:
                return null;
        }
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
