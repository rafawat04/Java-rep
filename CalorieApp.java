import java.util.*;
import java.io.*;

public class CalorieApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Calories> list = new ArrayList<>();

        File file = new File("caloriesTrack.csv");
        if (file.exists()) {
            list = readFile(file);
        } else {
            list = new ArrayList<>();
        }
        System.out.println("カロリー計算アプリ");
        System.out.print("何日分のカロリー数の計算をしますか>>");
        int countDays = sc.nextInt();

        for (int i = 0; i < countDays; i++) {
            System.out.print("日付を入れてください>>");
            String day = sc.next();
            System.out.print("何たべましたか(カンマ区切りで入力)>>");
            String food = sc.next();
            System.out.print("一日の摂取したカロリー数を入力してください>>");
            int calories = sc.nextInt();
            Calories c = new Calories(day, food, calories);
            list.add(c);
            writeFile(file, list);
        }

        double sum = 0;
        for (Calories c : list) {
            sum += c.calories;
        }
        System.out.printf("%d日間の平均摂取カロリー数は:%.2fでした", countDays, sum / countDays);
    }

    static ArrayList<Calories> readFile(File file) throws Exception {
        ArrayList<Calories> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            String day = values[0];
            String food = values[1];
            int calories = Integer.parseInt(values[2]);
            Calories c = new Calories(day, food, calories);
            list.add(c);
        }
        br.close();
        return list;
    }

    static void writeFile(File file, ArrayList<Calories> list) throws Exception {
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        for (Calories c : list) {
            bw.write(c.toCSV());
            bw.newLine();
        }
        bw.close();
    }
}

class Calories {
    String day;
    String food;
    int calories;

    Calories(String day, String food, int calories) {
        this.day = day;
        this.food = food;
        this.calories = calories;
    }

    String showList() {
        return String.format("%s・%s(%d)", this.day, this.food, this.calories);
    }

    String toCSV() {
        return String.format("%s,%s,%d", this.day, this.food, this.calories);
    }
}