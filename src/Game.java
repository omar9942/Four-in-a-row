import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private final String[][] gameMap = new String[6][7];
    private final Scanner inputs;
    private String player;

    public Game(){
        for (String[] row : gameMap){
            Arrays.fill(row, " ");
        }
        inputs = new Scanner(System.in);
        player = "X";
    }

    public void printMap(){
        System.out.println("|1 2 3 4 5 6 7|");
        int number = 1;
        for (String[] strings : gameMap) {
            for (String string : strings) {
                if (number % 7 != 0) {
                    System.out.print("|" + string);
                } else {
                    System.out.println("|" + string + "|");
                }
                number++;
            }
        }
    }

    public void play(){
        System.out.print("Player ["+player+"] Choose a column from 1 to 7 : ");
        String playerInput = inputs.nextLine();
        while (!playerInput.matches("[1-7]")){
            System.out.println("YOU CAN ONLY CHOOSE FROM 1 TO 7");
            System.out.print("Player ["+player+"] Choose a column from 1 to 7 : ");
            playerInput = inputs.nextLine();
        }

        while (!gameMap[0][Integer.parseInt(playerInput)-1].equals(" ")){
            System.out.println("THAT COLUMN IS FULL PLAY AGAIN");
            System.out.print("Player ["+player+"] Choose a column from 1 to 7 : ");
            playerInput = inputs.nextLine();
        }

        int playerCol = Integer.parseInt(playerInput)-1;

        for (int i = gameMap.length-1; i >= 0; i--) {
            if (gameMap[i][playerCol].equals(" ")){
                gameMap[i][playerCol] = player;
                break;
            }
        }

    }

    public void changePlayer(){
        if (player.equals("X")){
            player = "O";
        } else {
            player = "X";
        }
    }

    public boolean thereIsAWinner(){
        ArrayList<String> winPossibilities = new ArrayList<>();
        /* Vertical wins (columns) */
        winPossibilities.add(gameMap[0][0] + gameMap[1][0] + gameMap[2][0] + gameMap[3][0] + gameMap[4][0] + gameMap[5][0]);
        winPossibilities.add(gameMap[0][1] + gameMap[1][1] + gameMap[2][1] + gameMap[3][1] + gameMap[4][1] + gameMap[5][1]);
        winPossibilities.add(gameMap[0][2] + gameMap[1][2] + gameMap[2][2] + gameMap[3][2] + gameMap[4][2] + gameMap[5][2]);
        winPossibilities.add(gameMap[0][3] + gameMap[1][3] + gameMap[2][3] + gameMap[3][3] + gameMap[4][3] + gameMap[5][3]);
        winPossibilities.add(gameMap[0][4] + gameMap[1][4] + gameMap[2][4] + gameMap[3][4] + gameMap[4][4] + gameMap[5][4]);
        winPossibilities.add(gameMap[0][5] + gameMap[1][5] + gameMap[2][5] + gameMap[3][5] + gameMap[4][5] + gameMap[5][5]);
        winPossibilities.add(gameMap[0][6] + gameMap[1][6] + gameMap[2][6] + gameMap[3][6] + gameMap[4][6] + gameMap[5][6]);
        /* Horizontal wins (rows) */
        winPossibilities.add(gameMap[0][0] + gameMap[0][1] + gameMap[0][2] + gameMap[0][3] + gameMap[0][4] + gameMap[0][5] + gameMap[0][6]);
        winPossibilities.add(gameMap[1][0] + gameMap[1][1] + gameMap[1][2] + gameMap[1][3] + gameMap[1][4] + gameMap[1][5] + gameMap[1][6]);
        winPossibilities.add(gameMap[2][0] + gameMap[2][1] + gameMap[2][2] + gameMap[2][3] + gameMap[2][4] + gameMap[2][5] + gameMap[2][6]);
        winPossibilities.add(gameMap[3][0] + gameMap[3][1] + gameMap[3][2] + gameMap[3][3] + gameMap[3][4] + gameMap[3][5] + gameMap[3][6]);
        winPossibilities.add(gameMap[4][0] + gameMap[4][1] + gameMap[4][2] + gameMap[4][3] + gameMap[4][4] + gameMap[4][5] + gameMap[4][6]);
        winPossibilities.add(gameMap[5][0] + gameMap[5][1] + gameMap[5][2] + gameMap[5][3] + gameMap[5][4] + gameMap[5][5] + gameMap[5][6]);
        /* Diagonal Wins */
        winPossibilities.add(gameMap[0][0] + gameMap[1][1] + gameMap[2][2] + gameMap[3][3] + gameMap[4][4] + gameMap[5][5]);
        winPossibilities.add(gameMap[1][0] + gameMap[2][1] + gameMap[3][2] + gameMap[4][3] + gameMap[5][4]);
        winPossibilities.add(gameMap[2][0] + gameMap[3][1] + gameMap[4][2] + gameMap[5][3]);
        winPossibilities.add(gameMap[0][1] + gameMap[1][2] + gameMap[2][3] + gameMap[3][4] + gameMap[4][5] + gameMap[5][6]);
        winPossibilities.add(gameMap[0][2] + gameMap[1][3] + gameMap[2][4] + gameMap[3][5] + gameMap[4][6]);
        winPossibilities.add(gameMap[0][3] + gameMap[1][4] + gameMap[2][5] + gameMap[3][6]);
        winPossibilities.add(gameMap[0][6] + gameMap[1][5] + gameMap[2][4] + gameMap[3][3] + gameMap[4][2] + gameMap[5][1]);
        winPossibilities.add(gameMap[1][6] + gameMap[2][5] + gameMap[3][4] + gameMap[4][3] + gameMap[5][2]);
        winPossibilities.add(gameMap[2][6] + gameMap[3][5] + gameMap[4][4] + gameMap[5][3]);
        winPossibilities.add(gameMap[0][5] + gameMap[1][4] + gameMap[2][3] + gameMap[3][2] + gameMap[4][1] + gameMap[5][0]);
        winPossibilities.add(gameMap[0][4] + gameMap[1][3] + gameMap[2][2] + gameMap[3][1] + gameMap[4][0]);
        winPossibilities.add(gameMap[0][3] + gameMap[1][2] + gameMap[2][1] + gameMap[3][0]);

        for (String line : winPossibilities){
            if (line.contains(player + player + player + player)){
                return true;
            }
        }
        return false;
    }

    public boolean isFull(){
        return !Arrays.asList(gameMap[0]).contains(" ");
    }

    public String getPlayer() {
        return player;
    }
}
