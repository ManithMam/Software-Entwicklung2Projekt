package rooms;

import de.stuttgart_hdm.mi.se2.rooms.Room;
import de.stuttgart_hdm.mi.se2.rooms.RoomFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionTest {

    private RoomFactory roomFactory = new RoomFactory();
    private Room disneyland;

    @Test
    public void testCreatingRoom()
    {
        Throwable e = assertThrows(IllegalArgumentException.class, () -> disneyland = roomFactory.createRoom("Disneyland"));
        assertEquals("Roomtype not existing", e.getMessage());
    }
}
