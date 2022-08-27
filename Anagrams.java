// Given an array A of N strings,
// return all groups of strings that are anagrams.
// Represent a group by a list of integers representing the index(1-based)
// in the original list. Look at the sample case for clarification.
// NOTE: Anagram is a word, phrase, or name formed by
// rearranging the letters, such as 'spar', formed from 'rasp'.

// 1 <= N <= 10^4
// 1 <= |A[i]| <= 10^4
// Each string consists only of lowercase characters.
// The sum of the length of all the strings doesn't exceed 10^7

import java.util.*;

public class Anagrams {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> anagramIndexMap = getAnagramIndicesMap(A);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(String x : A) {
            String key = sortStringCharacters(x);
            if(anagramIndexMap.containsKey(key)) {
                ArrayList<Integer> value = anagramIndexMap.get(key);
                result.add(value);
                anagramIndexMap.remove(key);
            }
        }
        return result;
    }

    private String sortStringCharacters(String input) {
        char[] array = input.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    private Map<String, ArrayList<Integer>> getAnagramIndicesMap(List<String> A) {
        Map<String, ArrayList<Integer>> visitedStrings = new HashMap<>();

        for(int i = 0; i < A.size(); i++) {
            String word = A.get(i);
            String key = sortStringCharacters(word);

            ArrayList<Integer> keyPositions =
                    visitedStrings.containsKey(key) ? visitedStrings.get(key) : new ArrayList<>();

            keyPositions.add(i + 1);
            visitedStrings.put(key, keyPositions);
        }

        return visitedStrings;
    }


}
