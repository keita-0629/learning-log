import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void addTask(Scanner scanner, ArrayList<Task> list) {

        System.out.println("タスク追加です");
        System.out.println("タスクを入力してください");

        scanner.nextLine();
        String taskName = scanner.nextLine();
        Task task = new Task(taskName);
        list.add(task);

        System.out.println("タスクを追加しました");

    }

    public static void showTasks(ArrayList<Task> list) {

        System.out.println("タスク一覧です");

        if (list.isEmpty()) {
            System.out.println("タスクはありません");
            return;
        }

        String mark;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isDoneTask()) {
                mark = "[x]";
            } else {
                mark = "[ ]";
            }
            System.out.println(mark + (i + 1) + "." + list.get(i).getTaskName());

        }
    }

    public static void deleteTask(Scanner scanner, ArrayList<Task> list) {
        System.out.println("削除する番号を選んでください");

        int deleteNumber = scanner.nextInt();

        if (deleteNumber >= 1 && deleteNumber <= list.size()) {
            list.remove(deleteNumber - 1);
            System.out.println("タスクを削除しました");
        } else {
            System.out.println("番号がありません");
        }

    }

    public static void completeTask(Scanner scanner, ArrayList<Task> list) {
        System.out.println("完了にする番号を選んでください");

        int doneNumber = scanner.nextInt();

        if (doneNumber >= 1 && doneNumber <= list.size()) {
            list.get(doneNumber - 1).setDoneTask(true);
            System.out.println("タスクを完了にしました");
        } else {
            System.out.println("番号がありません");
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<Task>();

        while (true) {
            System.out.println("=== ToDoアプリ ===");
            System.out.println("1.タスク追加");
            System.out.println("2.タスク一覧");
            System.out.println("3.タスク削除");
            System.out.println("4.タスク完了");
            System.out.println("5.終了");

            System.out.println("番号を入力してください：");
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    addTask(scanner, list);
                    break;

                case 2:
                    showTasks(list);
                    break;

                case 3:
                    deleteTask(scanner, list);
                    break;

                case 4:
                    completeTask(scanner, list);
                    break;

                case 5:
                    System.out.println("終了します");
                    scanner.close();
                    return;

                default:
                    System.out.println("1〜5を入力してください");
                    break;
            }
        }
    }
}