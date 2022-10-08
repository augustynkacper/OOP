package agh.ics.oop;

import java.sql.SQLOutput;

public class World {

    /*
    static void run(String[] arr){
        System.out.println("Animal moving forward");

        if (arr.length == 0) return;

        for(int i=0; i<arr.length-1; i++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[arr.length-1]+"\n");
    }
    */


    static void run(String[] moves){
        for (int i=0; i<moves.length; i++){
            switch (moves[i]) {
                case "f":
                    System.out.println("Animal is moving forwards");
                    break;
                case "b":
                    System.out.println("Animal is moving backwards");
                    break;
                case "l":
                    System.out.println("Animal is turning left");
                    break;
                case "r":
                    System.out.println("Animal is turning right");
                    break;
                default:
                    continue;
            }
        }
    }

    /*
    static void run(Direction[] arr){
        for (Direction dir : arr){
            switch(dir){
                case FORWARD -> System.out.println("Animal is moving forward");
                case LEFT -> System.out.println("Animal is moving left");
                case RIGHT -> System.out.println("Animal is moving right");
                case BACKWARD -> System.out.println("Animal is moving backward");
            };
        }
    }
    */

    public static void main(String[] args){
        //String[] arr = {"f", "f", "b", "s", "r", "l"};

        //Direction[] arr = {Direction.LEFT, Direction.RIGHT, Direction.FORWARD, Direction.BACKWARD};

        System.out.println("System started");

        //run(arr);
        run(args);

        System.out.println("System stopped working");
    }

}
