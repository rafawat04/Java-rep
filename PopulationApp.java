import java.io.*;
import java.util.*;

public class PopulationApp {
    public static void main(String[] args) throws Exception {
        ArrayList<Population> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream("PopulationFile.csv");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) { // readline() is a Method thats read a line by line
            String[] values = line.split(",");
            String country = values[0];
            String state = values[1];
            String populationJp = values[2];
            int population = Integer.parseInt(values[3]);
            Population p = new Population(country, state, populationJp, population);
            list.add(p);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("操作を入力(1.人口ランキングを見る,2.首都を調べる,3.終了)>>");
        int select = sc.nextInt();
        switch (select) {
            case 1:

                int count = 1;
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i).population < list.get(j).population) {
                            Population temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                        }
                    }
                    System.out.print(count++ + "位");
                    list.get(i).displayInfoCountryPopulation();

                }
                break;

            case 2:
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(i).population < list.get(j).population) {
                            Population temp = list.get(i);
                            list.set(i, list.get(j));
                            list.set(j, temp);
                        }
                    }
                    list.get(i).displayInfoCountryAndState();

                }
                break;

            case 3:
                System.out.println("アプリケーションを終了します。");
                return;
        }
    }

}

class Population {
    String country;
    String state;
    String populationJp;
    int population;

    Population(String country, String state, String populationJp, int population) {
        this.country = country;
        this.state = state;
        this.populationJp = populationJp;
        this.population = population;

    }

    void displayInfoCountryPopulation() {

        System.out.println(this.country + " " + this.populationJp);

        // Using a String Method
        // public String showPopulation(){
        // return this.country+ " " + this.populationJp
        // }
    }

    void displayInfoCountryAndState() {
        System.out.println(this.country + " " + this.state);
    }

}