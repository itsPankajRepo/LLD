package famousLLD.snakeNLadder;

public class Ladder {
    private int fromCell;
    private int toCell;

    Ladder(int fromCell, int toCell) {
        this.fromCell = fromCell;
        this.toCell = toCell;
    }

    public int getToCell(){
        return toCell;
    }
}
