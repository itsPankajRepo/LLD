package famousLLD.snakeNLadder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Random;

public class Game {
    private Dice dice;
    private Board board;
    private Deque<Player> playersQue;
    private int numberOfSnake;
    private int numberOfLadder;
    private int boardSize;


    public Game(int numberOfDice, int numberOfPlayer, int boardSize, int numberOfSnake, int numberOfLadder) {
        this.dice = new Dice(numberOfDice);
        this.playersQue = new ArrayDeque<>(numberOfPlayer);
        playersQue.addFirst(new Player("Pankaj", 0));
        playersQue.addFirst(new Player("Arshdeep", 0));
        this.board = new Board(boardSize);
        this.numberOfSnake = numberOfSnake;
        this.numberOfLadder = numberOfLadder;
        this.boardSize = boardSize;

        initialiseGame();
    }


    public void initialiseGame() {
        initializeCells();
        generateSnakeOnCells(numberOfSnake);
        generateLadderOnCells(numberOfLadder);
        System.out.println("Initialization is done");
    }


    public void initializeCells() {
        Cell[][] cell = board.cells;
        int start = 0;
        boolean evenLine = true;
        for (int i = 0; i < cell.length; i++) {
            if (evenLine) {
                for (int j = 0; j < cell[0].length; j++) {
                    cell[i][j] = new Cell(start, null, null);
                    start++;
                }
                evenLine = false;
            } else {

                for (int j = cell[0].length - 1; j >= 0; j--) {
                    cell[i][j] = new Cell(start, null, null);
                    start++;
                }
                evenLine = true;
            }
        }

    }


    public void generateSnakeOnCells(int numberOfSnake) {
        while (numberOfSnake > 0) {
            Random random = new Random();
            var biteIndex = random.nextInt(101);
            var tailIndex = random.nextInt(101);
            if (tailIndex >= biteIndex)
                continue;

            int row = biteIndex / boardSize;
            int col = tailIndex % boardSize;
            if (row >= boardSize || col >= boardSize)
                continue;
            var cell = board.cells[row][col];
            if (Objects.nonNull(cell.getLadder()) || Objects.nonNull(cell.getSnake()))
                continue;

            cell.setSnake(new Snake(biteIndex, tailIndex));

            numberOfSnake--;
        }
    }

    public void generateLadderOnCells(int numberOfLadder) {
        while (numberOfLadder > 0) {
            Random random = new Random();
            var startLadder = random.nextInt(101);
            var endLadder = random.nextInt(101);

            if (startLadder >= endLadder)
                continue;
            int row = startLadder / boardSize;
            int col = startLadder % boardSize;
            if (row >= boardSize || col >= boardSize)
                continue;
            var cell = board.cells[row][col];

            if (Objects.nonNull(cell.getLadder()) || Objects.nonNull(cell.getSnake()))
                continue;

            cell.setLadder(new Ladder(startLadder, endLadder));

            numberOfLadder--;
        }
    }


    public void playGame() {
        String winner = null;
        System.out.println("Let's start the game");
        System.out.println("*************************************");

        while (Objects.isNull(winner)) {
            var player = playersQue.poll();
            System.out.println("Player : " + player.name + " going to throw the dice having current position "+ player.currentPosition);
            var number = dice.getCountOnDice();
            System.out.println(player.name + " got " + number + " on dice");
            var currentPositionOfPlayer = player.currentPosition + number;
            player.currentPosition = checkSnakeOrLadderPresentOnCell(currentPositionOfPlayer);
            System.out.println("After throwing the dice current position of " + player.name + " is " + player.currentPosition);

            if (player.currentPosition >= boardSize * boardSize)
                winner = player.name;

            playersQue.addLast(player);
            System.out.println("--------------------------------------");
        }

        System.out.println("HUURRAYYY!! " + winner + " won the game");

    }


    public int checkSnakeOrLadderPresentOnCell(int playerCurrentPosition) {
        int row = playerCurrentPosition / boardSize;
        int col = playerCurrentPosition % boardSize;
        if (row >= boardSize || col >= boardSize)
            return boardSize * boardSize;
        var cell = board.cells[row][col];
        if (Objects.nonNull(cell.getLadder())) {
            System.out.println("Found ladder at position " + cell.getId());
            playerCurrentPosition = cell.getLadder().getToCell();
        }

        if (Objects.nonNull(cell.getSnake())) {
            System.out.println("Found Snake at position " + cell.getId());
            playerCurrentPosition = cell.getSnake().getToCell();
        }
        return playerCurrentPosition;
    }


    public static void main(String[] args) {
        Game game = new Game(1, 2, 10, 5, 5);
        game.playGame();
    }
}
