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
    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (Employee e : employees) emap.put(e.id, e);
        return dfs(id);
    }
    
    private int dfs(int  id) {
        Employee e = emap.get(id);
        emap.remove(e);
        int imp = e.importance;
        for (int sid: e.subordinates) {
            imp += dfs(sid);
        }
        return imp;
    }
}