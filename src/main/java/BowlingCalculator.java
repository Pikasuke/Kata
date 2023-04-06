import java.util.List;

public class BowlingCalculator {

    private static int halfFrame;
    private static boolean spareToCount;
    private static int strikeToCount;
    private static Integer score;

    public static int score(List<Integer> pins) {
        initScore();
        for (int i = 0; i < pins.size(); i++) {
            Integer nbPins = pins.get(i);
            addScore(nbPins);
            addStrikeBonus(nbPins, i, pins);
            addSpareBonus(nbPins);
            checkBonus(pins, i);
        }
    return score;
    }

    private static void initScore() {
        score = 0;
        halfFrame = 0;
        spareToCount = false;
        strikeToCount = 0;
    }

    private static void checkBonus(List<Integer> pins, int i) {
        if (onNewFrame() && pins.get(i)==10) {
            strikeToCount += 2;
            nextFrame();
        } else {
            if (!onNewFrame() && frameScore(pins, i) == 10) {
                spareToCount = true;
            }
            continueFrame();
        }
    }

    private static void addScore(int pins) {
        score += pins;
    }
    private static void addSpareBonus(int pins) {
        if(halfFrame < 19) {
            if (spareToCount) {
                addScore(pins);
                spareToCount = false;
            }
        }
    }
    private static void addStrikeBonus(int pins, int i, List<Integer> pinsList) {
        if (strikeToCount > 0 ) {
            if (halfFrame < 18) {
                if (strikeToCount > 2) addScore(pins);
                addScore(pins);
                strikeToCount--;
            } else {
                strikeToCount = 0;
                addScore(pinsList.get(i-2));
            }
        }

    }

    private static void continueFrame() {
        halfFrame +=1;
    }

    private static void nextFrame() {
        halfFrame +=2;
    }

    private static boolean onNewFrame() {
        return halfFrame % 2 == 0;
    }

    private static int frameScore(List<Integer> pins, int i) {
        return pins.get(i - 1) + pins.get(i);
    }
}
