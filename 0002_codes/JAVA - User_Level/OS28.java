// OS28 - process tree simulation (this is not a real OS process tree)
// It is a small model to show how parent/child relationships look
import java.util.ArrayList;
import java.util.List;

public class OS28 {

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" OS28 - process tree simulation ");
        System.out.println("=========================================");
        Node init = new Node(1, "init");
        Node shell = new Node(120, "shell");
        Node editor = new Node(340, "editor");
        Node compiler = new Node(410, "compiler");
        Node browser = new Node(512, "browser");
        Node music = new Node(530, "music");

        init.add(shell);
        shell.add(editor);
        shell.add(compiler);
        shell.add(browser);
        browser.add(music);

        printTree(init, 0);

        System.out.println("=========================================");
    }
    private static void printTree(Node n, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(n.pid + " - " + n.name);

        for (Node child : n.children) {
            printTree(child, level + 1);
        }
    }

    static class Node {
        int pid;
        String name;
        List<Node> children = new ArrayList<>();

        Node(int pid, String name) {
            this.pid = pid;
            this.name = name;
        }
        void add(Node child) {
            children.add(child);
        }
    }
}
