
public class VegetableApp {
    public static void main(String[] args) {

        String[][] data = VegetableData.data; // class and var name
        Vegetable[] veges = new Vegetable[data.length]; // Vegetable class の Array

        for (int i = 0; i < veges.length; i++) { // this for is printing

            // String[] row = data[i];
            // String name = row[0];
            // int price = Integer.parseInt(row[1]);
            // String productionArea = row[2];
            // veges[i] = new Vegetable(name, price, productionArea); this one is the long
            // and 丁寧 way

            veges[i] = new Vegetable(data[i][0], Integer.parseInt(data[i][1]), data[i][2]);
            veges[i].displayInfo();

        }
        System.out.println("値段昇順に並び替え");

        for (int i = 0; i < veges.length; i++) {
            for (int j = i + 1; j < veges.length; j++) { // j = i(0)+1 first loop
                if (veges[i].price > veges[j].price) {
                    Vegetable temp = veges[i];
                    veges[i] = veges[j];
                    veges[j] = temp;
                }
            }
            veges[i].displayInfo();
            System.out.println();

        }

    }
}

class Vegetable {
    String name;
    int price;
    String productionArea;

    Vegetable(String name) {
        this.name = name;
    }

    Vegetable(String name, int price) {
        this(name);
        this.price = price;
    }

    Vegetable(String name, int price, String productionArea) {
        this(name, price);
        this.productionArea = productionArea;
    }

    // Method
    void displayInfo() {
        System.out.printf("名称:%s%n価格:%d%n産地:%s%n", this.name, this.price, this.productionArea);
    }
}
