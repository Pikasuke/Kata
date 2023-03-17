import com.Garden;
import com.Mower;
import com.societegenerale.Cardinals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMower {

    Mower mower;

    @BeforeEach
    public void setUp() {
        mower = new Mower(1,1, Cardinals.N, new Garden(5,5));
    }

    @Test
    public void mowerHadAPositionAndOrientation() {
        Assertions.assertEquals(1, mower.getX());
        Assertions.assertEquals("N", mower.getOrientation());
    }

    @Test
    public void aMowerFowardItsCoordinateUpdate() {
        mower.foward();
        Assertions.assertEquals(2, mower.getY());
        mower.setOrientation(Cardinals.S);
        mower.foward();
        Assertions.assertEquals(1, mower.getY());
        mower.setOrientation(Cardinals.E);
        mower.foward();
        Assertions.assertEquals(2, mower.getX());
        mower.setOrientation(Cardinals.W);
        mower.foward();
        Assertions.assertEquals(1, mower.getX());
    }

    @Test
    public void aMowerHasAGarden() {

        Assertions.assertEquals(5, mower.getGarden().getMaxX());
    }

    @Test
    public void aMowerDontMoveIfItIsOutOfBoundOnY() {
        Garden garden = new Garden(5,5);
        mower.setY(5);
        mower.foward();
        Assertions.assertEquals(5, mower.getY());
        mower.setOrientation(Cardinals.S);
        mower.setY(0);
        mower.foward();
        Assertions.assertEquals(0, mower.getY());
        mower.setOrientation(Cardinals.E);
        mower.setX(5);
        mower.foward();
        Assertions.assertEquals(5, mower.getX());
        mower.setOrientation(Cardinals.W);
        mower.setX(0);
        mower.foward();
        Assertions.assertEquals(0, mower.getX());
    }

    @Test
    public void aMowerTurnOrientationUpdate() {
        mower.turn("D");
        Assertions.assertEquals(Cardinals.E.toString(), mower.getOrientation());
        mower.turn("D");
        Assertions.assertEquals(Cardinals.S.toString(), mower.getOrientation());
        mower.turn("D");
        Assertions.assertEquals(Cardinals.W.toString(), mower.getOrientation());
        mower.turn("D");
        Assertions.assertEquals(Cardinals.N.toString(), mower.getOrientation());
        mower.turn("G");
        Assertions.assertEquals(Cardinals.W.toString(), mower.getOrientation());
    }

    @Test
    public void afterReceivedOneInstructionsMowerGivesItsPosition() {
        String result = mower.execute("A");
        Assertions.assertEquals("1 2 N ", result);
    }
    @Test
    public void afterReceivedInstructionsMowerGivesItsPosition() {
        String result = mower.execute("GAGAGAGAA");
        Assertions.assertEquals("1 2 N ", result);
    }

    @Test
    public void afterReceiveOtherInstructionsMowerGivesItsPosition() {
        mower.setX(3);
        mower.setY(3);
        mower.setOrientation(Cardinals.E);
        String result = mower.execute("AADAADADDA");
        Assertions.assertEquals("5 1 E ", result);
    }

}
