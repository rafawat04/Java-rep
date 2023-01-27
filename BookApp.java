import java.util.*;

public class BookApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("本のページ数を入力して下さい >");
        int pageNum = sc.nextInt();
        System.out.print("本の価格を入力して下さい >");
        int price = sc.nextInt();
        Book b = new Book(pageNum, price);

        System.out.print("ノートのページ数を入力して下さい >");
        pageNum = sc.nextInt(); // int 入れないで使い直した
        System.out.print("ノートの価格を入力して下さい >");
        price = sc.nextInt(); // int 入れないで使い直した
        NoteBook nb = new NoteBook(pageNum, price);

        boolean finishApp = true;
        while (finishApp) {
            System.out.print("1. 本の情報表示 / 2. ノートの情報表示 / 3. ノートに追加書込 / 4.   終了>");
            int select = sc.nextInt();

            switch (select) {

                case 1:
                    b.showInfo();
                    break;
                case 2:
                    nb.showInfo();
                    break;
                case 3:
                    System.out.println("書き込む内容を入力して下さい >");
                    String str = sc.next();
                    nb.writeContent(str);
                    continue;
                default:
                    System.out.println("アプリケーションを終了します。");
                    finishApp = false;
                    return;

            }
        }
    }

}

class Book {
    int pageNum;
    int price;

    Book(int pageNum, int price) {
        this.pageNum = pageNum;
        this.price = price;

    }

    void showInfo() {
        System.out.printf("ページ数:%d%n価格:%d%n", this.pageNum, this.price);
    }

}

class NoteBook extends Book {
    String info = " ";

    NoteBook(int pageNum, int price) {
        super(pageNum, price);
    }

    void writeContent(String str) {
        // this.info = this.info + str; same as below 元々あった内容を更新していく
        this.info += str;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("内容:%s%n", this.info);
    }

}