import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> unfinished = new ArrayList<>();

        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) {
                unfinished.add(todo_list[i]);
            }
        }

        return unfinished.toArray(new String[0]);
    }
}