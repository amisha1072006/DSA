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
        // Build a map for quick access
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        // DFS traversal
        return dfs(map, id);
    }
    
    private int dfs(Map<Integer, Employee> map, int id) {
        Employee emp = map.get(id);
        int total = emp.importance;
        for (int subId : emp.subordinates) {
            total += dfs(map, subId);
        }
        return total;
    }
}