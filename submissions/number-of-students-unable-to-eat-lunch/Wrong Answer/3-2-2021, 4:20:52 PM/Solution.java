// https://leetcode.com/problems/number-of-students-unable-to-eat-lunch

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQ = new LinkedList<>();
        Stack<Integer> sandwichS = new Stack<>();
        int ans = 0;
        for (int student : students) {
            studentQ.offer(student);
        }
        
        for (int sandwich : sandwiches) {
            sandwichS.push(sandwich);
        }
        
        while (!studentQ.isEmpty() && !sandwichS.isEmpty()) {
            if (studentQ.peek() == sandwichS.peek()) {
                studentQ.poll();
                sandwichS.pop();
            } else {
                int size = studentQ.size(), i = 0;
                while (studentQ.peek() != sandwichS.peek() && i != size) {
                    studentQ.offer(studentQ.poll());
                    i++;
                }
                if (i == size) 
                    return ans;
            }
        }
        return 0;
    }
}