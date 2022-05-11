package classes;

public class Player {
    private Room currentRoom;

    public Player(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    private void changeRoom(Room newRoom){
        this.currentRoom = newRoom;
    }

    private void inspectRoom(){
        System.out.println(this.currentRoom.getDescription());
    }
}
