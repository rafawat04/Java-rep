import java.io.*;

import java.util.*;

public class CampApp {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("datacamp.csv");
        InputStreamReader isr = new InputStreamReader(fis, "UTF8");
        BufferedReader br = new BufferedReader(isr);

        Map<String, Integer> whoPaid = new HashMap<>();
        Map<String, Integer> boughtItems = new HashMap<>();

        int total = 0;
        System.out.println("csvデータ");
        System.out.println("------------------");
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] data = line.split(",");
            String name = data[0];
            String item = data[1];
            int price = Integer.parseInt(data[2]);
            total += price;
            if (whoPaid.containsKey(name)) {
                whoPaid.put(name, whoPaid.get(name) + price);// whoPaid.get(name)
                                                             // これは元々出てた金額名前（山田、４６００）をGetしているので、+priceで金額を更新している
            } else {
                whoPaid.put(name, price);
            }
            if (boughtItems.containsKey(item)) {
                boughtItems.put(item, boughtItems.get(item) + price);
            } else {
                boughtItems.put(item, price);
            }

        }
        System.out.println("\nキャンプ会計");
        System.out.println("------------------");
        for (String item : boughtItems.keySet()) {
            System.out.println(item + ":" + boughtItems.get(item));
        }
        int perYen = total / whoPaid.size();
        System.out.println("\n個人別会計(１人あたり:" + perYen + "円)");
        System.out.println("------------------");
        for (String name : whoPaid.keySet()) {
            System.out.printf("%s:%d(%s%d)%n", name, whoPaid.get(name), whoPaid.get(name) < perYen ? "-" : "+",
                    Math.abs(whoPaid.get(name) - perYen));
        }
    }
}
