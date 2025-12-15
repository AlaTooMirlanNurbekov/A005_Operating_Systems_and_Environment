// OS27 - process priority simulation (java cannot change real OS process priorities safely
//so this example simulates priority by giving more or less CPU time to different tasks.

public class OS27 {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println(" OS27 - priority simulation ");
        System.out.println("=========================================");
        Task high = new Task("HIGH", 10);
        Task medium = new Task("MEDIUM", 5);
        Task low = new Task("LOW", 2);
        long endTime = System.currentTimeMillis() + 3000;

        while (System.currentTimeMillis() < endTime) {
            high.runSlice();
            medium.runSlice();
            low.runSlice();
        }
        System.out.println();
        System.out.println("work done:");
        System.out.println("HIGH   = " + high.work);
        System.out.println("MEDIUM = " + medium.work);
        System.out.println("LOW    = " + low.work);
        System.out.println("=========================================");
    }
    static class Task {
        String name;
        int weight;
        long work = 0;
        Task(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }
        void runSlice() {
            //higher weight means more work per turn (similar to getting more CPU time)
            for (int i = 0; i < weight * 1000; i++) {
                work++;
            }
        }
    }
}
