package urlshortener.urlshortener.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class IDConverter {

    public static final IDConverter INSTANCE = new IDConverter();

    private IDConverter() {
        initializeCharToIndexTable();
        initializeIndexToCharTable();
    }

    private static HashMap<Character, Integer> charToIndexTable;
    private static List<Character> indexToCharTable;

    private void initializeCharToIndexTable() {
        charToIndexTable = new HashMap<>();
        // 0->a, 1->b, ..., 25->z, ..., 52->0, 61->9
        for (int i = 0; i < 26; ++i) {
            char c = 'a';
            c += i;
            charToIndexTable.put(c, i);
        }
        for (int i = 26; i < 52; ++i) {
            char c = 'A';
            c += (i-26);
            charToIndexTable.put(c, i);
        }
        for (int i = 52; i < 62; ++i) {
            char c = '0';
            c += (i - 52);
            charToIndexTable.put(c, i);
        }
    }

    private void initializeIndexToCharTable() {
        // 0->a, 1->b, ..., 25->z, ..., 52->0, 61->9
        indexToCharTable = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            char c = 'a';
            c += i;
            indexToCharTable.add(c);
        }
        for (int i = 26; i < 52; ++i) {
            char c = 'A';
            c += (i-26);
            indexToCharTable.add(c);
        }
        for (int i = 52; i < 62; ++i) {
            char c = '0';
            c += (i - 52);
            indexToCharTable.add(c);
        }
    }

    public String generateShortened(Integer id){
        List<Integer> digits = new ArrayList<Integer>();
        while (id > 0) {
            Integer reminder = id % 62;
            digits.add(reminder);
            id = id / 62;
        }
        Collections.reverse(digits);
        String result = "";
        for(int i=0; i<digits.size(); i++){
            result += indexToCharTable.get(digits.get(i));
        }
        return result;
    }

}
