package Items;


import java.util.ArrayList;

public class Items {

    private int id;
    private static int idCount = 0;
    private String name;
    private boolean pickable;
    private String desc;
    private ArrayList<Items> itemList = new ArrayList<Items>();


    public Items(String name, boolean pickable, String desc){
        this.id = ++idCount;
        this.name = name;
        this.pickable = pickable;
        this.desc = desc;

        itemList.add(this);
    }

    public Items(){
        this.id = ++idCount;
        this.name = "No name found";
        this.pickable = false;
        this.desc = "No description found";

        itemList.add(this);
    }

    public int getId(){return this.id;}

    public boolean isPickable(){return this.pickable;}

    public String getDesc(){return this.desc;}

    public String getName(){return this.name;}

    public void setId(int id){this.id = id;}

    public void setName(String name){this.name = name;}

    public void setPickable(boolean pickable){this.pickable = pickable;}

    public void setDesc(String desc){this.desc = desc;}



    /* NOTE: unused code for reference, to be removed

    private static final Map<String, Integer> idMap = new HashMap<>();
    private static final Map<Integer, Boolean> pableMap = new HashMap<>();
    private static final Map<Integer, String> descMap = new HashMap<>();

    public static void loadItems() {

        // reads text document and stores read keys and values in corresponding map to be accessed later

        toIdMap(readFile("src/main/resources/Items/idList.txt"));

        toPableMap(readFile("src/main/resources/Items/itemPable.txt"));

        toDescMap(readFile("src/main/resources/Items/itemDesc.txt"));

    }

    // convert an external text file into String
    public static String readFile(String fileName) {

        String fileToString = new String();

        // initializes FileInputStream
        try (FileInputStream fis = new FileInputStream(new File(fileName))) {
            int content;

            // reads a byte at a time, if it reached end of the file, returns -1
            while ((content = fis.read()) != -1) {

                //converts read integer to char, then stores in String fileToString
                fileToString += (char) content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileToString;
    }

    // create id Map from String containing id values
    private static void toIdMap(String idDis) {

        String itemName = new String();
        int itemId = 1;

        for (int index = 0; index < idDis.length(); index++) {

            // selects individual char from String
            char currentChar = idDis.charAt(index);

            // filters char for divider markers (",") and assigns item name
            if (currentChar != ',') {
                itemName += currentChar;
                itemName = itemName.replace("\n", "").replace("\r", "");
            }

            // adds item name with corresponding id to idMap
            else if (currentChar == ',') {
                idMap.put(itemName, itemId);

                itemName = "";
                itemId++;
            }
        }
    }

    // create map with pable values from text file
    private static void toPableMap(String fileName) {
        String itemName = new String();

        for (int index = 0; index < fileName.length(); index++) {

            // selects individual char from String
            char currentChar = fileName.charAt(index);

            // filters char for '=' symbol and assigns item name
            if (currentChar != '=') {
                itemName += currentChar;
            }

            // adds item id with pable value to pableMap
            else if (fileName.charAt(index + 2) == '1') {
                pableMap.put(getItemId(itemName), true);
                itemName = "";
                index += 4;
            } else {
                pableMap.put(getItemId(itemName), false);

                itemName = "";
                index += 4;
            }
        }
    }

    // create descMap from text file
    private static void toDescMap(String descList) {

        String itemDesc = new String();
        int idStage = 0;
        int currentId = 0;

        // value of idStage int determines the assignment of currentChar
        // 0 = new assignment; 1 = awaiting new digit of id / awaiting desc beginning; 2 = desc currently reading

        for (int index = 0; index < descList.length(); index++) {

            // selects individual char from String
            char currentChar = descList.charAt(index);

            if (idStage == 0) {
                currentId = Character.getNumericValue(currentChar);
                idStage = 1;
            } else if (idStage == 1) {
                if (currentChar != ' ') {
                    currentId = currentId * 10;
                    currentId += Character.getNumericValue(currentChar);
                } else {
                    idStage = 2;
                    index++;
                }
            } else if (idStage == 2) {
                if (currentChar != ')') {
                    itemDesc += currentChar;
                } else {
                    descMap.put(currentId, itemDesc);
                    idStage = 0;
                    index++;
                    currentId = 0;
                    itemDesc = "";
                }
            }
        }
    }

    // get item id from name
    public static int getItemId(String name) {
        int id;
        id = idMap.get(name);

        return id;
    }

    // get boolean value if item is pickupable or not via id input (not defined == not pickupable)
    public static boolean isPable(int id) {
        boolean pableValue = false;
        if (pableMap.get(id) != null) {
            pableValue = pableMap.get(id);
        }
        return pableValue;
    }

    // get item description from name (To fix: currently wrong id assigned)
    public static String getDesc(int id) {
        String desc;
        desc = descMap.get(id);

        return desc;
    }


     */
}
