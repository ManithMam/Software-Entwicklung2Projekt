package rooms;

public class Test {

    static Room basement = new Basement();
    static Room bathroom = new Bathroom();

    public static void main(String[] args) {
        System.out.println(basement.getName());
        System.out.println(bathroom.getName());
    }


}
