import java.io.IOException;

// OS23 - process runtime timer
// parent process starts a child and measures how long the child runs this is similar to how the OS can account process execution time

public class OS23 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" OS23 - process runtime measurement ");
        System.out.println("=========================================");
        long start = System.currentTimeMillis();
        try {
            // we start another java program here think of this as: parent -> child
            ProcessBuilder pb = new ProcessBuilder("java", "OS23Child");
            pb.inheritIO();

            System.out.println("parent: starting child process");
            Process child = pb.start();
            // parent waits until the child finishes. this is similar to wait()/waitpid() in C.
    
            child.waitFor();
        } catch (IOException e) {
            System.out.println("could not start child process");
        } catch (InterruptedException e) {
            System.out.println("parent was interrupted while waiting");
            Thread.currentThread().interrupt();
        }
        long end = System.currentTimeMillis();
        System.out.println("parent: child finished");
        System.out.println("runtime (ms): " + (end - start));
        System.out.println("=========================================");
    }
}
