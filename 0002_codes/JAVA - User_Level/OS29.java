/*
 * OS29 - Zombie and orphan process concept (conceptual demo)
 * java does not expose real zombie/orphan processes, so we model the idea using states and timing
 */

public class OS29 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" OS29 - zombie / orphan concept ");
        System.out.println("=========================================");
        ProcessInfo parent = new ProcessInfo(100, "parent");
        ProcessInfo child = new ProcessInfo(200, "child");
        parent.child = child;
        System.out.println("parent running (pid " + parent.pid + ")");
        System.out.println("child started (pid " + child.pid + ")");

        //child finishes execution but parent does NOT collect exit status yet
        child.state = "terminated";
        System.out.println("\nchild finished, parent did not wait()");
        System.out.println("child state: " + child.state + "  -> zombie");

        //parent now exits without waiting
        parent.state = "terminated";
        System.out.println("\nparent exits without waiting");
        System.out.println("child is now adopted by init (pid 1)");
        System.out.println("child cleaned up by OS");
        System.out.println("=========================================");
    }
    static class ProcessInfo {
        int pid;
        String name;
        String state = "running";
        ProcessInfo child;

        ProcessInfo(int pid, String name) {
            this.pid = pid;
            this.name = name;
        }
    }
}
