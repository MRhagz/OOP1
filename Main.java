package PvZ_LAB;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Plant> plants = new ArrayList<>();
        Plant p;
        String op;
        String mode;
        boolean state = false;

        System.out.print("Game Mode: ");
        mode = sc.nextLine();
        if (mode.equals("Day") || mode.equals("Roof") || mode.equals("Pool")) {
            state = true;
        }
        do {
            System.out.println("Add a plant: ");
            op = sc.nextLine();
            switch(op) {
                case "Sun-shroom":
                    p = new Mushroom.SunShroom("Sun-shroom", 25, state);
                    plants.add(p);
                    break;
                case "Puff-shroom":
                    p = new Mushroom.PuffShroom("Puff-shroom", 0, state);
                    plants.add(p);
                    break;
                case "Doom-shroom":
                    p = new Mushroom.DoomShroom("Doom-shroom", 120, state);
                    plants.add(p);
                    break;
                case "DONE":
                    break;
                default:
                    System.out.println("UNKNOWN PLANT");
                    break;
            }
        } while (!op.equals("DONE"));

        do {
            System.out.println("Do something: ");
            op = sc.nextLine();
            switch(op) {
                case "Attack":
                    for (Plant p1 : plants) {
                        if (p1 instanceof Attacker) {
                            ((Attacker) p1).attack();
                        }
                    }
                    break;
                default:
                    break;
            }
        } while (!op.equals("DONE"));
    }


}
