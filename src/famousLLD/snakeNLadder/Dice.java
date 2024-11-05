package famousLLD.snakeNLadder;

import java.util.Random;

public class Dice {
    int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }


    public int getFaceCountOnDice() {
        return new Random().nextInt(6) + 1;
    }

    public int getCountOnDice() {
        int sum = 0;
        int numberOfDice  = this.numberOfDice;
        while (numberOfDice > 0) {
            sum += getFaceCountOnDice();
            numberOfDice--;
        }
        return sum;
    }
}
