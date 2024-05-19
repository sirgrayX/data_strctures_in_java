import java.io.File;
import java.util.Scanner;

public class Directory {
    public static void printDirTree(File dirFile) {
        var sepPointer = "|------";
        var c = dirFile.getPath().split("\\\\").length - 1;
        System.out.println(
                sepPointer.repeat(c + 1) + dirFile.getName());
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var root = new File(sc.nextLine());

        var queue = new Queue<File>();
        queue.enqueue(root);
        System.out.println(root);

        while (!queue.isEmpty()) {
            var directory = queue.dequeue();
            var files = directory.listFiles();
            if (!directory.equals(root)) {
                printDirTree(directory);
            }
            if (files != null) {
                for (var file : files) {
                    if (file.isDirectory()) {
                        queue.enqueue(file);
                    } else {
                        printDirTree(file);
                    }
                }
            }
        }
    }
}
