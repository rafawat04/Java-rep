import java.util.*;
import java.io.*;

public class CalorieCounterApp {
    public static void main(String[] args) throws Exception {
        File file = new File("menu.csv");
        ArrayList<Food> allData = loadFile(file);
        ArrayList<Category> categoryList = createCategoryList(allData);

        Scanner sc = new Scanner(System.in);
        ArrayList<Food> ateMeal = new ArrayList<>();

        System.out.println("1日のカロリー計算をしよう!");

        while (true) {
            System.out.print("朝食はたべますか？(1:はい、0:いいえ)>>");
            Category selectedCategory = categoryList.get(0);
            int select = sc.nextInt();
            if (select == 0) {
                System.out.println("朝食は" + 0 + "カロリー取得しました");

            } else {
                selectedCategory.showLabel();
                selectedCategory.showMenu();
                System.out.print("番号を入力してください>>");
                String input = sc.next();

                addToOrder(input, selectedCategory, ateMeal);
                displayOrderSheet(ateMeal, true);
            }

            System.out.print("昼食はたべますか？(1:はい、0:いいえ)>>");
            selectedCategory = categoryList.get(1);
            int select2 = sc.nextInt();
            if (select2 == 0) {
                System.out.println("昼食は" + 0 + "カロリー取得しました");

            } else {
                selectedCategory.showLabel();
                selectedCategory.showMenu();
                System.out.print("番号を入力してください>>");
                String input = sc.next();

                addToOrder(input, selectedCategory, ateMeal);
                displayOrderSheet(ateMeal, true);
            }

            System.out.print("晩飯はたべますか？(1:はい、0:いいえ)>>");
            selectedCategory = categoryList.get(2);
            select2 = sc.nextInt();
            if (select2 == 0) {
                System.out.println("晩飯は" + 0 + "カロリー取得しました");

            } else {
                selectedCategory.showLabel();
                selectedCategory.showMenu();
                System.out.print("番号を入力してください>>");
                String input = sc.next();

                addToOrder(input, selectedCategory, ateMeal);
                displayOrderSheet(ateMeal, true);
            }
            return;
        }

    }

    static void addToOrder(String input, Category cat, ArrayList<Food> ateMeal) {
        String[] nums = input.split(",");
        for (String n : nums) {
            int idx = Integer.parseInt(n);
            Food foods = cat.getItem(idx);
            ateMeal.add(foods);
        }
    }

    static void displayOrderSheet(ArrayList<Food> ateMeal, boolean total) {

        for (Food foods : ateMeal) {
            System.out.println(foods.showInfo());
        }
        if (total) {
            System.out.printf("朝食は%dカロリー取得しました%n");
        }
    }

    static ArrayList<Food> loadFile(File file) throws Exception {
        ArrayList<Food> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            String category = values[0];
            String food = values[1];
            int calories = Integer.parseInt(values[2]);
            Food f = new Food(category, food, calories);
            list.add(f);
        }
        br.close();
        return list;
    }

    static ArrayList<Category> createCategoryList(ArrayList<Food> allData) {
        ArrayList<String> meals = new ArrayList<>();
        for (Food foods : allData) {
            if (!meals.contains(foods.category)) {
                meals.add(foods.category);
            }
        }
        ArrayList<Category> categoryList = new ArrayList<>();
        for (String mealName : meals) {
            Category c = new Category(mealName);
            for (Food foods : allData) {
                if (foods.category.equals(mealName)) {
                    c.addItem(foods);
                }
            }
            categoryList.add(c);
        }
        return categoryList;
    }
}

class Food {
    String category;
    String food;
    int calories;

    Food(String category, String food, int calories) {
        this.category = category;
        this.food = food;
        this.calories = calories;
    }

    String showInfo() {
        return String.format("%s(%dcal)", this.food, this.calories);

    }

    public char[] toCSV() {
        return null;
    }

    public void showList() {
    }

}

class Category {
    String meal;
    ArrayList<Food> foodList = new ArrayList<>();

    Category(String meal) {
        this.meal = meal;
    }

    void showLabel() {
        System.out.println(this.meal);
    }

    void addItem(Food foods) {
        this.foodList.add(foods);
    }

    Food getItem(int index) {
        return this.foodList.get(index);
    }

    void showMenu() {

        for (int i = 0; i < this.foodList.size(); i++) {
            System.out.printf("%d.%s%n", i, this.foodList.get(i).showInfo());
        }
    }
}