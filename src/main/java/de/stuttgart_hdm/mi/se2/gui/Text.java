package de.stuttgart_hdm.mi.se2.gui;


/**
 * Text for GameController
 */
public enum Text {

    PROMPT_TO_PICK_ROOM("Please select a room!"),

    PICKUP_DENIED( "You can not pick that up"),

    ROOM_LOCKED("The room is locked!%n%s%n"),

    SELECT_ITEM("Select Item!"),

    ERROR("ERROR"),

    INVENTORY("Inventory (%d/3)"),

    CURRENT_ROOM("Current room: "),

    ACCESS_RIGHT_CHANGE_TO_TRUE("Changed access rights of %s to true."),

    PICK_ROOM_PRESSED("Picked room with double-click"),

    PREVIOUS_ROOM("Previous room: "),

    CLEAR_TEXT(""),

    CHANGE_ROOM_BUTTON_PRESSED("Change Room button was pressed"),

    INSPECT_BUTTON_PRESSED("Inspect button was pressed"),

    OPTION_BUTTON_PRESSED("Option button was pressed in game"),

    BACK_TO_MENU_BUTTON_PRESSED("Back to Menu button was pressed in game"),

    PICK_UP_BUTTON_PRESSED("Pick up button was pressed"),

    UNSELECT_ITEM_INFO("Use Ctr-Click to unselect Item!"),

    USED_ITEM_INFO("Opened door with: "),

    ROOM_LOCKED_DIFFERENT_FORMAT("The room is locked!%n%s%n%s%s"),

    PROMPT_TO_DOUBLE_CLICK("Double click to select room!");

    private final String message;


    Text(String message) {
        this.message = message;
    }


    public String getMessage(){
        return this.message;
    }
}
