public class Player extends Thread {

    private String[] variants = {"roc", "scissors", "paper"};
    private String rezult = "";
    private String name = "";

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {

            rezult = variants[i];
            i++;
            if (i == 3) i = 0;
        }
    }

    // Получаем текущее состояние
    public String getRezult() {
        return rezult;
    }

    @Override
    public String toString() {
        return name;
    }
}
