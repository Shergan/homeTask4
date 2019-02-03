package com.divashchenko;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Task 1. Binary search
        Random random = new Random();
        int[] arr = new int[100000];
        int number = random.nextInt(100000);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }

        Arrays.sort(arr);

        System.out.println("Is number " + number + " in array?");
        System.out.println(binarySearch(arr, number));


        System.out.println();
        System.out.println("===============================================");
        System.out.println();


        //Task 2. Robots
        String command1 = "UUDLDR";
        String command2 = "UD";
        String command3 = "LL";
        String command4 = "UDLRB"; //wrong command

        System.out.println("command1: " + isRobotAtHome(command1));
        System.out.println("command2: " + isRobotAtHome(command2));
        System.out.println("command3: " + isRobotAtHome(command3));
        System.out.println("command4: " + isRobotAtHome(command4));
    }

    private static boolean binarySearch(int[] arr, int number) {
        int left = 0;
        int right = arr.length - 1;
        int medium;

        while (right >= left) {
            medium = (right + left) / 2;
            if (arr[medium] == number) {
                return true;
            } else if (arr[medium] > number) {
                right = medium - 1;
            } else if (arr[medium] < number) {
                left = medium + 1;
            }
        }

        return false;
    }

    private static boolean isRobotAtHome(String command) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                y++;
            } else if (command.charAt(i) == 'D') {
                y--;
            } else if (command.charAt(i) == 'L') {
                x--;
            } else if (command.charAt(i) == 'R') {
                x++;
            } else {
                try {
                    throw new Exception("Wrong command!");
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

        return x == 0 && y == 0;
    }
}
