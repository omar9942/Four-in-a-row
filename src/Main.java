public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        while (true){
            game.printMap();
            game.play();
            if (game.thereIsAWinner()){
                game.printMap();
                System.out.println("---------------");
                System.out.println("PLAYER [" + game.getPlayer() + "] WINS");
                System.out.println("---------------");
                break;
            } else if (game.isFull()){
                game.printMap();
                System.out.println("---------------");
                System.out.println("--IT'S A DRAW--");
                System.out.println("---------------");
                break;
            } else {
                game.changePlayer();
            }
        }
    }
}
