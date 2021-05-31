package Lab7.Flyweight;

import java.util.HashMap;


class PlayerFactory {
    /* HashMap stores the reference to the object
       of Terrorist(TS) or CounterTerrorist(CT).  */
    private static HashMap<String, Player> hm =
            new HashMap<String, Player>();

    // Method to get a player
    public static Player getPlayer(String type) {
        Player p = null;


        if (hm.containsKey(type))
            p = hm.get(type);
        else {

            switch (type) {
                case "Terrorist":
                    System.out.println("Terrorist Created");
                    p = new Terrorist();
                    break;
                case "CounterTerrorist":
                    System.out.println("Counter Terrorist Created");
                    p = new CounterTerrorist();
                    break;
                default:
                    System.out.println("Unreachable code!");
            }

            hm.put(type, p);
        }
        return p;
    }
}