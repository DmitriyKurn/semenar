package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box();
        System.out.println(appleBox.getWeight()); // 0

        appleBox.add(new Apple(2)); // Должно компилироваться
        appleBox.add(new Apple(4)); // Должно компилироваться
        System.out.println(appleBox.getWeight()); // 6
        //appleBox.add(new Orange(4)); // Не должно компилироваться!!!
        appleBox.add(new GoldenApple(4)); // Должно компилироваться
        System.out.println(appleBox.getWeight()); // 10

        List<Apple> a = new ArrayList<>();
        List<GoldenApple> g = new ArrayList<>();

        Box<Orange> orangeBox = new Box();
        //orangeBox.add(new Apple(2)); // Не должно компилироваться!!!
        orangeBox.add(new Orange(8)); // Должно компилироваться
        System.out.println(orangeBox.getWeight()); // 8

        //orangeBox.move(appleBox); // Не должно компилироваться!!!
        //appleBox.move(orangeBox); // Не должно компилироваться!!!

        Box<GoldenApple> goldenAppleBox = new Box();
        goldenAppleBox.add(new GoldenApple(20)); // Должно компилироваться
        //goldenAppleBox.add(new Apple(20)); // Не должно компилироваться!!!

        appleBox.move(goldenAppleBox); // Не должно компилироваться!!!
        //goldenAppleBox.move(appleBox); // Должно компилироваться

        System.out.println(goldenAppleBox.getWeight()); // 0
        System.out.println(appleBox.getWeight()); // 30

        for (Apple apple : appleBox) { // Должно компилироваться

        }

        for (GoldenApple goldenApple : goldenAppleBox) { // Должно компилироваться

        }

        // for (Orange orange : orangeBox) { // Должно компилироваться

        // }

    }

    static class Box<T extends Fruit> implements Iterable<T> {

        private List<T> allFruits = new ArrayList<>();

        public void add(T fruit) { // FIXME Должен быть дженерик!
            // FIXME Реализовать добавления фрукта
            allFruits.add(fruit);
            //throw new UnsupportedOperationException();
        }

        public int getWeight() {
            // FIXME Реализовать подсчет суммарного веса
            int weight = 0;
            for (T fruit : allFruits) {
                weight += fruit.getWeight();
            }
            return weight;
            //throw new UnsupportedOperationException();
        }

        public void move(Box<? extends T> another) { // FIXME Должен быть дженерик!
            // FIXME Реализовать пересыпание
            this.allFruits.addAll(another.allFruits);
            another.allFruits.clear();
            //throw new UnsupportedOperationException();
        }

        @Override
        public Iterator<T> iterator() {
            return allFruits.iterator();
        }
    }

    static class Fruit {

        private int weight;

        public Fruit(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class Apple extends Fruit {
        public Apple(int weight) {
            super(weight);
        }
    }

    static class GoldenApple extends Apple {
        public GoldenApple(int weight) {
            super(weight);
        }
    }

    static class Orange extends Fruit {
        public Orange(int weight) {
            super(weight);
        }
    }

}

    

