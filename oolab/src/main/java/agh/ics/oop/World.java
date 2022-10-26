package agh.ics.oop;

import java.util.Arrays;

public class World {

    static void change(String[] args, Direction[] dirs){
        for (int i=0; i<args.length; i++){
            switch (args[i]){
                case "f" -> dirs[i] = Direction.FORWARD;
                case "b" -> dirs[i] = Direction.BACKWARD;
                case "l" -> dirs[i] = Direction.LEFT;
                case "r" -> dirs[i] = Direction.RIGHT;
                default -> dirs[i] = Direction.NONE;
            }
        }
    }


     static void run(Direction[] arr){
        for (Direction dir : arr){
            switch(dir){
                case FORWARD -> System.out.println("Animal is moving forward");
                case LEFT -> System.out.println("Animal is moving left");
                case RIGHT -> System.out.println("Animal is moving right");
                case BACKWARD -> System.out.println("Animal is moving backward");
                case NONE -> System.out.print("");
            };
        }
    }


    public static void main(String[] args){
        //String[] arr = {"f", "f", "b", "s", "r", "l"};

        Direction[] arr = new Direction[args.length];

        System.out.println("System started");

        change(args, arr);
        run(arr);

        System.out.println("System stopped working");


        // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.NORTH.previous());

        System.out.println("==============");

        // LAB 3
        Animal an = new Animal();


        MoveDirection[] moves = OptionsParser.parse(args);
        for (MoveDirection move : moves){
            an.move(move);
            System.out.println(an);
        }


    }

}
