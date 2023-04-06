import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BowlingTest {


    //TODO
    /*
    strike strike
    strike strike frame
    strike strike spare strike frame
    10em tour
    strike 2 bonus
    spare 1 bonus

     */
    @Test
    public void givenNoThrowScoreIsZero() {
        Assertions.assertEquals(0,
                BowlingCalculator.score(List.of()));
    }
    @Test
    public void givenOneThrowScoreIsThatThrow() {
        Assertions.assertEquals(7,
                BowlingCalculator.score(List.of(7)));
    }
    @Test
    public void givenOneFrameScoreIsSumOfThrow() {
        Assertions.assertEquals(9,
                BowlingCalculator.score(List.of(7,2)));
    }
    @Test
    public void givenTwoFramesScoreIsSumOfThrow() {
        Assertions.assertEquals(15,
                BowlingCalculator.score(List.of(7,2,3,3)));
    }
    @Test
    public void givenOneSpareWithoutNextThrowScoreIsTen() {
        Assertions.assertEquals(10,
                BowlingCalculator.score(List.of(7,3)));
    }
    @Test
    public void givenOneSpareWithNextThrowScoreIsTenPlusThrow() {
        Assertions.assertEquals(10+3+3,
                BowlingCalculator.score(List.of(6,4,3)));
    }
    @Test
    public void givenTenPinsWithThreeThrowSpareBonusDoesntCount() {
        Assertions.assertEquals(14,
                BowlingCalculator.score(List.of(6,2,2,4)));
    }
    @Test
    public void givenASpareInSecondFrameSpareBonusCounts() {
        Assertions.assertEquals(5+2 + 6+4 +3+ 3,
                BowlingCalculator.score(List.of(5,2,6,4,3)));
    }
    @Test
    public void givenTwoSparesSpareBonusCounts() {
        Assertions.assertEquals( 6+4 +5+ 5+5 +2+ 2 ,
                BowlingCalculator.score(List.of(6,4,5,5,2)));
    }
    @Test
    public void givenAStrikeBonusCount() {
        Assertions.assertEquals( 10+ 3+2 + 3+2,
                BowlingCalculator.score(List.of(10, 3, 2)));
    }
    @Test
    public void givenAStrikeThenASpareAllBonusCount() {
        Assertions.assertEquals( 10 + 6+4 + 6+4 + 3 + 3,
                BowlingCalculator.score(List.of(10,6,4,3)));
    }
    @Test
    public void givenStrikeAndSpareInRoundAllBonusCount() {
        Assertions.assertEquals( 10 + 6+4 + 6+4 + 10 + 10 + 9+1 +9+1+ 8 + 8+1,
                BowlingCalculator.score(List.of(10,6,4,10,9,1,8,1)));
    }
    @Test
    public void giventwoStrikeAnASpareABonusCount() {
        Assertions.assertEquals( 10 +(10+9) +10 +(9+0) + 9,
                BowlingCalculator.score(List.of(10,10,9,0)));
    }
    @Test
    public void givenFiveStrikeAnASpareABonusCount() {
        Assertions.assertEquals( 10+ (10+10) + 10+(10+10) + 10+(10+10) + 10 +(10+9) +10 +(9+0) + 9,
                BowlingCalculator.score(List.of(10,10,10,10,10,9,0)));
    }
    @Test
    public void givenFullFramePartyCountScore() {
        Assertions.assertEquals( 10*9,
                BowlingCalculator.score(List.of(9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0,9,0)));
    }
    @Test
    public void givenSpareOnLastFrameBonusDoesntCount() {
        Assertions.assertEquals( 19,
                BowlingCalculator.score(List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6,4,9)));
    }
    @Test
    public void givenFullSpareandNine() {
        Assertions.assertEquals( 110,
                BowlingCalculator.score(List.of(1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1,9,1)));
    }

    @Test
    public void givenElevenStrikeAnFourZeroABonusCount() {
        Assertions.assertEquals( 8*30 + 10 +(10+4) + 10 + 4,
                BowlingCalculator.score(List.of(10,10,10,10,10,10,10,10,10,10,10,4,0)));
    }
    @Test
    public void givenTwelveStrikeAnANineABonusCount() {
        Assertions.assertEquals( 9*30 + 10 + 10 + 9,
                BowlingCalculator.score(List.of(10,10,10,10,10,10,10,10,10,10,10,10,9)));
    }
    @Test
    public void givenFullStrikeScoreIsPerfect300() {
        Assertions.assertEquals( 300,
                BowlingCalculator.score(List.of(10,10,10,10,10,10,10,10,10,10,10,10,10)));
    }
}
