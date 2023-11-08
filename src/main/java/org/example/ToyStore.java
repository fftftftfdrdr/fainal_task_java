package org.example;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
public class ToyStore {
    public static void main(String[] args) {
        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getWeight() - t1.getWeight());


        Toy toy1 = new Toy("1", "конструктор 1", 20);
        Toy toy2 = new Toy("2", "робот 1", 20);
        Toy toy3 = new Toy("3", "кукла 1", 60);


        toyQueue.add(toy1);
        toyQueue.add(toy2);
        toyQueue.add(toy3);


        System.out.println("Список всех игрушек:");
        for (Toy toy : toyQueue) {
            System.out.println("ID: " + toy.getId() + ", Название: " + toy.getName() + ", Вес: " + toy.getWeight());
        }

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("drop.txt"));
            for (int i = 0; i < 10; i++) {
                String result = getRandomToy(toyQueue);
                writer.write(result + "\n");
            }
            writer.close();
            System.out.println("Результаты успешно записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getRandomToy(PriorityQueue<Toy> toyQueue) {
        double random = Math.random() * 100;
        if (random < 20) {
            Toy constructor = null;
            for (Toy toy : toyQueue) {
                if (toy.getName().equals("конструктор 1")) {
                    constructor = toy;
                    break;
                }
            }
            if (constructor != null) {
                System.out.println("Выпал конструктор!");
                return "ID:" + constructor.getId() + " " + constructor.getName();
            }
        } else if (random < 40) {
            Toy robot = null;
            for (Toy toy : toyQueue) {
                if (toy.getName().equals("робот 1")) {
                    robot = toy;
                    break;
                }
            }
            if (robot != null) {
                System.out.println("Выпал робот!");
                return "ID:" + robot.getId() + " " + robot.getName();
            }
        } else {
            Toy doll = null;
            for (Toy toy : toyQueue) {
                if (toy.getName().equals("кукла 1")) {
                    doll = toy;
                    break;
                }
            }
            if (doll != null) {
                System.out.println("Выпала кукла!");
                return "ID:" + doll.getId() + " " + doll.getName();
            }
        }
        return "No Toy Found";
    }
}
