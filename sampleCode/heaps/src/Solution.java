import java.util.*;

public class Solution {

    public List<Integer> kFrequentWords(List<String> words, int k) {
        Map<String, Integer> wordCounts = new HashMap<>();

        // Count the words: O(n)
        for(String word : words) {
            if (wordCounts.containsKey(word)) {
                int current = wordCounts.get(word);
                wordCounts.put(word, current + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        // Put counts into heap: O(n*log(k))
        Heap<Integer> heap = new Heap<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            heap.push(entry.getValue());
            if (heap.size() > k) heap.pop();
        }

        // pop every element of heap and into ans list: O(k log(k))
        List<Integer> ans = new ArrayList<>();
        while (heap.size() > 0) {
            ans.add(heap.top());
            heap.pop();
        }
        Collections.reverse(ans);
        return ans;

    }
}
