package testProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersArray {
    private List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    synchronized void addNumber(int number) {
        list.add(number);
    }

    synchronized int removeNumber() {
        int min = list.size() == 0 ? 0 : list.get(0);
        for (Integer i : list) {
            if (i < min)
                min = i;
        }
        if (min > 0) list.remove((Integer) min);
        return min;
    }
}
