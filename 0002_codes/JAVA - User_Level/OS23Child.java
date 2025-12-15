// OS23Child (this code does nothing useful on purpose, just sleeps for a bit to simulate a running process

public class OS23Child {
    public static void main(String[] args) {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
        }
    }
}
