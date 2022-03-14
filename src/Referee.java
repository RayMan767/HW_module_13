import java.util.ArrayList;
import java.util.List;

public class Referee extends Thread {
    private boolean isWinner = false;
    // Массив игроков
    List<Player> players;
    // Массив с руками игроков
    List<String> variants = new ArrayList<>();

    // добавляем всех игроков
    public Referee(Player[] players) {
        this.players = List.of(players);
    }

    @Override
    public void run() {
        // Запускаем игроков
        for (Player player : players) {
            if (player != null)  player.start();
        }
        while (!isWinner) {
            System.out.println("one");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("two");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("three");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Смотрим кто что показал в этот момент
            for (Player player : players) {
                String str = player.getRezult();
                variants.add(str);
                System.out.println(player + " set " + str);
            }
            // Вычисляем результат
            if (variants.get(0).equals(variants.get(1))) {
                System.out.println("Replaying...");
                variants.clear();
            } else if ((variants.get(0).equals("scissors") && variants.get(1).equals("paper"))
                    || (variants.get(0).equals("roc") && variants.get(1).equals("scissors"))
                    || (variants.get(0).equals("paper") && variants.get(1).equals("roc"))) {
                System.out.println(players.get(0) + " WIN!");
                isWinner = true;
            } else {
                System.out.println(players.get(1) + " WIN!");
                isWinner = true;
            }
        }
        // останавливаем другие потоки
        for (Player player : players)
            player.interrupt();


    }
}
