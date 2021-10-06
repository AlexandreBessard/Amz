package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {

    Map<Integer,Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public MaximumFrequencyStack() {
        this.freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        maxFreq = Math.max(maxFreq, f);
        group.computeIfAbsent(f, z -> new Stack<>()).push(x);
    }

    public int pop() {
        int x = group.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if(group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
    }

}
