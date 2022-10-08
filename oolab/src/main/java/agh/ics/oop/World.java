package agh.ics.oop;

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
    }

}
