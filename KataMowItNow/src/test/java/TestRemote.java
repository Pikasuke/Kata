import com.Mower;
import com.societegenerale.Cardinals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRemote {

    @Test
    public void givenAStringCreateNewMower() {

        Mower mower = Remote.createMower("1 1 N");

        Assertions.assertEquals(1, mower.getX());
        Assertions.assertEquals(1, mower.getY());
        Assertions.assertEquals(Cardinals.N, mower.getOrientation());
    }
}
