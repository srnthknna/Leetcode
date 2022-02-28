// https://leetcode.com/problems/open-the-lock

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead_end = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        String state_one = "0000";
        queue.offer(state_one);
        visited.add(state_one);
        
        int level = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                if (dead_end.contains(curr)) {
                    i++;
                    continue;
                }
                
                if (curr.equals(target)) {
                    return level;
                }
                
                char[] curr_array = curr.toCharArray();
                for (int ind = 0; ind < curr_array.length; ind++) {
                    char temp = curr_array[ind];
                    if (temp != '9') {
                        curr_array[ind]++;
                    } else {
                        curr_array[ind] = '0';
                    }
                    String s1 = new String(curr_array);
                    
                    if (!visited.contains(s1) && !dead_end.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    
                    curr_array[ind] = temp;
                    
                    if (temp != '0') {
                        curr_array[ind]--;
                    } else {
                        curr_array[ind] = '9';
                    }
                    String s2 = new String(curr_array);
                    
                    if (!visited.contains(s2) && !dead_end.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                    
                    curr_array[ind] = temp;
                }
            }
            level++;
        }

        return -1;
    }
}