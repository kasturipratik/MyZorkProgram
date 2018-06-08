package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        HashMap<Integer, ArrayList<Integer>> mapToRooms = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> toRoom = new ArrayList<Integer>();
        ArrayList<Integer> toRoom2 = new ArrayList<Integer>();

        toRoom.add(2);
        mapToRooms.put(1, toRoom);

        toRoom2.add(1);
        toRoom2.add(3);
        toRoom2.add(4);
        mapToRooms.put(2, toRoom2);


        String input = null;

        Scanner scan = new Scanner(System.in);

        do{
            System.out.print("Enter 1 to go to the house: ");
            input= scan.next();

            if (input.equals("1")) {
                roomOne(mapToRooms, Integer.parseInt(input));
            }

            else if (input.equals("Q")) {
                System.out.print("YOu exited");
                break;
            }

        } while (!input.equals("1"));


    }

    private static void roomOne(HashMap<Integer, ArrayList<Integer>> mapsToRoom,
                                int from) {

        String input3 = null;

        Scanner sc= new Scanner(System.in);

        if(mapsToRoom.containsKey(from)) {
            ArrayList<Integer> roomValues = mapsToRoom.get(from);

            System.out.print("You are in foyer & you see dead scorpion\n");
            System.out.print("{You can (1)exit to the north or press Q to quit}\n");
            input3=sc.nextLine();

            if (input3.equals("1")) {
                roomTwo(mapsToRoom);

            } else if (input3.equals("Q")){
                System.out.print("You exited from the system");
            } else {
                System.out.print("There are no doors from 1 to " + input3);
            }

        }
    }


    private static void roomTwo(HashMap<Integer, ArrayList<Integer>> mapsToRoom) {
        String input3 = null;
        Scanner sc= new Scanner(System.in);

        ArrayList<Integer> roomValues = mapsToRoom.get(2);

        System.out.print("You are in front room now & you see piano\n");
        System.out.print("{You can (1)exit to the south or (2) to west or"
                + " (3) to  east or press Q to quit}\n");
        input3=sc.nextLine();

        if (!input3.equals("Q")) {
            int to = getElement(roomValues, input3);

            if (to == 1) {
                roomOne(mapsToRoom, to);
            } else if (to == 3) {
                roomThree(mapsToRoom, to);
            }
            else {

                System.out.print("Invalid Input");
            }
        } else {
            System.out.print("You exited from the system");
        }

    }


    private static void roomThree(HashMap<Integer, ArrayList<Integer>> mapsToRoom, int to) {
        // TODO Auto-generated method stub

    }

    private static int getElement(ArrayList<Integer> map, String index) {
        int value = Integer.parseInt(index);
        value= value - 1;

        return map.get(value);



    }
}