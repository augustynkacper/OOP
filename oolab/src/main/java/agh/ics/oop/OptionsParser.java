package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {

    public static MoveDirection[] parse(String[] args){
        List<MoveDirection> dirs = new ArrayList<>();

        for (String option: args){
            switch (option) {
                case "f", "forward" -> dirs.add(MoveDirection.FORWARD);
                case "b", "backward" -> dirs.add(MoveDirection.BACKWARD);
                case "r", "right" -> dirs.add(MoveDirection.RIGHT);
                case "l", "left" -> dirs.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(option + " is not legal move specification");
            }
        }

        MoveDirection[] res = new MoveDirection[dirs.size()];
        dirs.toArray(res);
        return res;
     }
}
