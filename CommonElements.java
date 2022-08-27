// Given two integer arrays, A and B of size N and M, respectively.
// Your task is to find all the common elements in both the array.

// NOTE:
// Each element in the result should appear as many times as it appears in both arrays.
// The result can be in any order.
// 1 <= N, M <= 10^5
// 1 <= A[i] <= 10^9

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = getFrequencyMap(A);
        for(int x : B) {
            if(frequencyMap.containsKey(x)) {
                result.add(x);
                decreaseFrequencyByOne(frequencyMap, x);
            }
        }
        return result;
    }

    private Map<Integer, Integer> getFrequencyMap (ArrayList<Integer> A) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int x : A) {
            frequencyMap.putIfAbsent(x, 0);
            frequencyMap.put(x, frequencyMap.get(x) + 1);
        }
        return frequencyMap;
    }

    private void decreaseFrequencyByOne(Map<Integer, Integer> map, int key) {
        map.put(key, map.get(key) - 1);
        if(map.get(key) == 0) {
            map.remove(key);
        }
    }
}
