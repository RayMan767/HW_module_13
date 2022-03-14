public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");


        Referee referee = new Referee(players);

        // Запускаем игру
        referee.run();


    }
}
