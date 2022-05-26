package rooms;

public class Test {

   static RoomFactory roomFactory = new RoomFactory();

   public static void main(String[] args) {
      Room basement = roomFactory.createRoom("Basement");
      Room kitchen = roomFactory.createRoom("Kitchen");

      System.out.println("" + basement.getDescription() + kitchen.getId());
   }
}
