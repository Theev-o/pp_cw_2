package com.company;

import java.awt.*;
import java.util.*;

public class Main {
    public static void zad1(){
        //a
        ArrayList<String> List = new ArrayList<String>();
        String[] Names = {
                "Michael",
                "Casper",
                "Daniel",
                "Thomas",
                "James",
                "David",
                "Steven",
                "Marge",
                "Johnny",
                "Sebastian"
        };
        for(String name : Names){
            List.add(name);
        }

        //b
        System.out.println("First 3 positions in the list:");
        for(int i = 0; i < 3; i++){
            System.out.println(List.get(i));
        }
        System.out.println("\nLast 3 positions in the list:");
        for(int i = List.size()-1; i > List.size()-4; i--){
            System.out.println(List.get(i));
        }

        //c
        List.add(5, "Dudley");

        //d
        for(int i = 0; i < 3; i++){
            List.remove(0);
            List.remove(List.size()-1);
        }
        //e

        ArrayList<String> List2 = new ArrayList<String>();
        String[] Names2 = {
                "Amelie",
                "Julienne",
                "Agatha",
                "Karen",
                "Michelle",
                "Barrack"
        };
        for(String name : Names2){
            List2.add(name);
        }
        List.addAll(List2);

        //f
        Collections.sort(List);

        System.out.println("\nAscending");
        for(String name : List){
            System.out.println(name);
        }

        int i = 0, j = List.size()-1;
        String cache;
        while (i < j){
            cache = List.get(i);
            List.set(i, List.get(j));
            List.set(j, cache);
            i++;
            j--;
        }

        System.out.println("\nDescending");
        for(String name : List){
            System.out.println(name);
        }
    }

    public static void zad2(){
        //a
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();

        Integer[] ints1 = { 2, 1, 7, 15, 37, 53, 12, 8, 6, 3 };
        Integer[] ints2 = { 9, 63, 34, 82, 1, 83, 23, 52, 12, 65 };

        for (Integer num : ints1){ set1.add(num); }
        for (Integer num : ints2){ set2.add(num); }

        //b
        int intersect = 0;
        for (Integer num : set1){
            if (set2.contains(num)){
                intersect++;
            }
        }
        System.out.println("Set 2 contains " + intersect + " of the numbers from set 1.");

        //c
        System.out.println("Intersection: ");
        for(Integer num : set1){
            if (set2.contains(num)){
                System.out.print(num + " ");
            }
        }

        System.out.println("\nset 2 / set 1:");
        for(Integer num : set2){
            if (!set1.contains(num)){
                System.out.print(num + " ");
            }
        }

        System.out.println("\nSum: ");
        set1.addAll(set2);
        for(Integer num : set1){
            System.out.print(num + " ");
        }
    }

    public static void zad3(int amount, int range){
        Random rand = new Random();
        Integer randomNum;
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        System.out.print("Random numbers: ");
        for(int i = 0; i < amount; i++){
            randomNum = rand.nextInt(range)+1;
            if(numbers.containsKey(randomNum)){
                numbers.put(randomNum, numbers.get(randomNum)+1);
            } else {
                numbers.put(randomNum, 1);
            }
            System.out.print(randomNum + " ");
        }
        System.out.println("\nRandom nums: " + numbers.keySet());
        System.out.println("Appearances: " + numbers.values());

    }

    public static void main(String[] args) {
        //zad1();
        //zad2();
        //zad3(25, 10);
        /* zad4
        {
            HashSet<Osoba> people = new HashSet<Osoba>();
            String[] names = {"George", "Alice", "Mathew", "Tiffany", "Karen", "Jimothy", "Bartholomew", "Cody"};
            String[] surnames = {"Bush", "Wonderland", "Mercer", "Trump", "Karen", "Benson", "The Third", "McDik"};
            Integer[] ages = {49, 12, 28, 30, 42, 9, 80, 17};

            for (int i = 0; i < names.length; i++) {
                people.add(new Osoba(names[i], surnames[i], ages[i], i + 1));
            }

            people.removeIf(person -> person.age > 25);

            System.out.print("People who aren't boomers: ");
            for (Osoba person : people) {
                System.out.print(person.name + " " + person.surname + ", ");
            }
        }
        */

        /* zad 5
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        ArrayDeque<Osoba> queue = new ArrayDeque<Osoba>();
        while(choice != 3){
            System.out.println("What would you like to do?\n1. Call next person\n2. Register person\n3. exit");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    if(queue.isEmpty()){
                        System.out.println("The queue is empty, please add a person first.\n");
                    } else {
                        Osoba nextPerson = queue.remove();
                        System.out.println(nextPerson.name + " " + nextPerson.surname + ", please step forward.\n");
                    }
                    break;
                case 2:
                    System.out.print("\n\nNew person\nName: ");
                    String name = scan.nextLine();
                    System.out.print("Surname: ");
                    String surname = scan.nextLine();
                    System.out.print("Age: ");
                    Integer age = scan.nextInt();
                    System.out.print("ID: ");
                    Integer ID = scan.nextInt();

                    queue.add(new Osoba(name, surname, age, ID));
                    System.out.println("\nPerson successfully added to queue.\n");
                    break;
                case 3:
                    System.out.println("\nExiting...\n");
                    break;
                default:
                    System.out.println("\nPlease enter a correct number.\n");
            }
        }
        */
    }
}

//zad 4, 5
class Osoba {
    String name;
    String surname;
    Integer age;
    Integer ID;

    public Osoba(String nam, String surnam, Integer ag, Integer IDnum){
        name = nam;
        surname = surnam;
        age = ag;
        ID = IDnum;
    }
}