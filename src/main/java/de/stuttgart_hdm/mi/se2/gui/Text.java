package de.stuttgart_hdm.mi.se2.gui;

public enum Text {
    //0
    SELECT_ROOM_WITH_PICK_BUTTON( "Please select a room and use \"Pick Room\" button!"),
    //1
    SELECT_ROOM("Please select a room!"),
    //2
    PICKUP_DENIED( "You can not pick that up"),
    //3
    ROOM_LOCKED("The room is locked!%n%s%n"),
    //4
    SELECT_ITEM("Select Item!"),
    //5
    NO_CASE("No case: %d available"),
    //6
    ERROR("ERROR"),
    //7,
    INVENTORY("Inventory (%d/3)"),
    //8
    CURRENT_ROOM("Current room: "),
    //9
    ACCESS_RIGHT_CHANGE_TO_TRUE("Changed access rights of %s to true."),
    //10
    PICK_ROOM_PRESSED("Pick Room button was pressed"),
    //11
    PREVIOUS_ROOM("Previous room: "),
    //12
    CLEAR_TEXT(""),
    //13
    CHANGE_ROOM_BUTTON_PRESSED("Change Room button was pressed"),
    //14
    INSPECT_BUTTON_PRESSED("Inspect button was pressed"),
    //15
    OPTION_BUTTON_PRESSED("Option button was pressed in game"),
    //16
    BACK_TO_MENU_BUTTON_PRESSED("Back to Menu button was pressed in game"),
    //17
    PICK_UP_BUTTON_PRESSED("Pick up button was pressed"),
    //18
    UNSELECT_ITEM_INFO("Use Ctr-Click to unselect Item!"),
    //19
    USED_ITEM_INFO("Opened door with: "),
    //20
    ROOM_LOCKED_DIFFERENT_FORMAT("The room is locked!%n%s%n%s%s");

    private final String message;

    Text(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
