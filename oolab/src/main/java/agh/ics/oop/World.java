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


        String[] s = {"f", "f", "b",   "r", "l", "l",   "f", "f", "f",   "f", "l", "f",   "f", "f", "r",   "f", "f", "f",   "f", "f", "f",   "f", "f", "f"};
        MoveDirection[] directions = (new OptionsParser()).parse(s);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(3,4), new Vector2d(8,8), new Vector2d(9,3)   };
        IEngine engine = new SimulationEngine(map, directions, positions);


        System.out.println(map);

        engine.run();

        System.out.println(map);


    }

}
