package famousLLD.snakeNLadder;

public class Snake {
    private int fromCell;
    private int toCell;

    Snake(int fromCell, int toCell) {
        this.fromCell = fromCell;
        this.toCell = toCell;
    }


    public int getToCell(){
        return toCell;
    }
}
