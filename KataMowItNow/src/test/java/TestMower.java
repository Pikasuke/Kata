import org.Garden;
import org.Mower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class TestMower {

    Mower mower;

    @BeforeEach
    public void setUp() {
        mower = new Mower(1,1,"N", new Garden(5,5));
    }

    @Test
    public void mowerHadAPositionAndOrientation() {
        Assertions.assertEquals(1, mower.getX());
    }

    @Test
    public void aMowerFowardItsCoordinateUpdate() {
        mower.foward();
        Assertions.assertEquals(2, mower.getY());
        mower.setOrientation("E");
        mower.foward();
        Assertions.assertEquals(2, mower.getX());
        mower.setOrientation("W");
        mower.foward();
        Assertions.assertEquals(1, mower.getX());
    }

    @Test
    public void aMowerIsInstanciateWithGarden() {
        Assertions.assertEquals(5, mower.getGarden().getFieldX());
    }

    @Test
    public void aMowerDontMoveIfItIsOutOfBound() {
        Garden field = new Garden(5,5);
        mower.setY(5);
        mower.foward();
        Assertions.assertEquals(5, mower.getY());
        mower.setOrientation("S");
        mower.setY(0);
        mower.foward();
        Assertions.assertEquals(0, mower.getY());
        mower.setOrientation("E");
        mower.setX(5);
        mower.foward();
        Assertions.assertEquals(5, mower.getX());
    }

    @Test
    public void aMowerTurnOrientationUpdate() {
        mower.turn("D");
        Assertions.assertEquals("E", mower.getOrientation());
        mower.turn("D");
        Assertions.assertEquals("S", mower.getOrientation());
        mower.turn("D");
        Assertions.assertEquals("W", mower.getOrientation());
        mower.turn("D");
        Assertions.assertEquals("N", mower.getOrientation());
        mower.turn("G");
        Assertions.assertEquals("W", mower.getOrientation());
    }

    @Test
    public void afterReceivedInstructionsMowerGivesItsPosition() {
        String result = mower.execute("GAGAGAGAA");
        Assertions.assertEquals("1 2 N", result);
    }

    @Test
    public void afterReceiveOtherInstructionsMowerGivesItsPosition() {
        mower.setX(3);
        mower.setY(3);
        mower.setOrientation("E");
        String result = mower.execute("AADAADADDA");
        Assertions.assertEquals("5 1 E ", result);
    }

}
