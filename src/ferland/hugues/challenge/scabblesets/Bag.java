package ferland.hugues.challenge.scabblesets;

import java.util.HashMap;
import java.util.Set;

/**
 * A bag of letter of the Scrabble game.
 */
public class Bag {

    private final HashMap<Character, Integer> content = new HashMap<Character, Integer>() {
        {
            put('A', 9);
            put('B', 2);
            put('C', 2);
            put('D', 4);
            put('E', 12);
            put('F', 2);
            put('G', 3);
            put('H', 2);
            put('I', 9);
            put('J', 1);
            put('K', 1);
            put('L', 4);
            put('M', 2);
            put('N', 6);
            put('O', 8);
            put('P', 2);
            put('Q', 1);
            put('R', 6);
            put('S', 4);
            put('T', 6);
            put('U', 4);
            put('V', 2);
            put('W', 2);
            put('X', 1);
            put('Y', 2);
            put('Z', 1);
            put('_', 2);
        }
    };

    public Bag() {
    }

    public Integer count(int letter) {
        return content.get((char)letter);
    }

    public void remove(int charAsInt) {
        char c = (char)charAsInt;
        if (content.get(c) == 0) {
            throw new IllegalStateException("Invalid input. More "+c+"'s have been taken from the bag than possible.");
        }
        content.put(c, content.get(c) - 1);
    }

    public Set<Character> letters() {
        return content.keySet();
    }
}
