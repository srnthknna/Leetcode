// https://leetcode.com/problems/employee-importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Set<Integer> org = new HashSet<>();
        int imp = 0;
        for (Employee e : employees) {
            if (org.isEmpty() && e.id == id) { 
                org.addAll(e.subordinates);
                imp += e.importance;
            } else if (org.contains(e.id)) {
                imp += e.importance;
                org.addAll(e.subordinates);
            }
        }
        for (Employee e : employees) {
            if (org.contains(e.id)) {
                imp += e.importance;
                org.addAll(e.subordinates);
            }
        }
        return imp;
    }
}