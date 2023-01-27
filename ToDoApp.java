import java.util.*;

public class ToDoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Todo> list = new ArrayList<>();

        System.out.println("****TodoApp****");
        while (true) {
            System.out.println("——操作を入力してください。——");
            System.out.print("1/登録 2/重要度変更 3/削除 4/終了>");
            int select = sc.nextInt();
            if (select == 4) {
                System.out.println("アプリケーションを終了します。");
                for (Todo t : list) {
                    System.out.println(t.showMemo());
                }
                return;
            }

            if (select == 1) {
                System.out.println("新規Todoを作成します。");
                System.out.print("Todo内容を入力してください>");
                String memo = sc.next();
                System.out.print("重要度を1~10(最大)で入力してください>");
                int priority = sc.nextInt();
                Todo t = new Todo(memo, priority);
                list.add(t);
                System.out.println("1件追加しました。");
                for (int i = 0; i < list.size(); i++) {
                    System.out.printf("%d・・・%s%n", i, list.get(i).showMemo());

                }
                sortInfo(list);

            } else if (select == 2) {
                System.out.print("重要度を変更します。番号を入力してください。 0~" + (list.size() - 1) + ">");
                int num = sc.nextInt();
                list.get(num).showMemo();
                System.out.print("重要度を再設定してください。>");
                int num2 = sc.nextInt();
                list.get(num).changePriority(num2);
                sortInfo(list);
                System.out.println("重要度を変更しました。");
                // Todo a = list.get(num2);
                // list.set(list.get(num).priority, a);

            } else if (select == 3) {
                System.out.print("Todoを削除します。番号を入力してください。0~" + (list.size() - 1) + ">");
                int num = sc.nextInt();
                list.remove(num);

                System.out.println("1件削除しました。");

            }
        }
    }

    static void sortInfo(ArrayList<Todo> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).priority < list.get(j).priority) {
                    Todo temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

}

class Todo {
    String memo;
    int priority;

    Todo(String memo, int priority) {
        this.memo = memo;
        this.priority = priority;
    }

    String showMemo() {
        return String.format("%s/重要度:%d", this.memo, this.priority);
    }

    void changePriority(int a) {
        this.priority = a;
    }

}
