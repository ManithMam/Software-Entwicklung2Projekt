package rooms;

public class Test {

    static Room basement = new Basement();
    static Room bathroom = new Bathroom();
    static Room currentRoom = new Bathroom();

    public static void main(String[] args) {
        changeRoom(bathroom);
    }

    private static void changeRoom(Room newRoom) {
        if (newRoom.getAccess()) {
            currentRoom = newRoom;
        } else {
            System.out.printf("" + newRoom.neededItem());
        }
    }
}
