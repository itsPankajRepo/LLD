package famousLLD.snakeNLadder;

import java.util.Objects;

public class Cell {
    private int id;
    private Snake snake;
    private Ladder ladder;


    public int getId(){
        return this.id;
    }

    public Cell(int id, Snake snake, Ladder ladder) {
        this.id = id;
        this.snake = snake;
        this.ladder = ladder;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public Snake getSnake() {
        return this.snake;
    }

}
