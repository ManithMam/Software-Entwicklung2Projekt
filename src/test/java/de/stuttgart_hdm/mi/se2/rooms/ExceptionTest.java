package de.stuttgart_hdm.mi.se2.rooms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    private RoomFactory roomFactory;
    private Room disneyland;

    @BeforeEach
    public void before() {
        roomFactory = new RoomFactory();
    }

    @Test
    public void testCreatingRoom()
    {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> disneyland = roomFactory.createRoom("Disneyland"));
        assertEquals("Roomtype not existing", e.getMessage());
    }
}
