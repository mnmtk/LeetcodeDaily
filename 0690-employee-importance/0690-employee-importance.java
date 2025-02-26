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

        emap = new HashMap();
        for(Employee e : employees) {
            emap.put(e.id, e);
        }

        return dfs(id);
    }

    public int dfs(int eid) {
        
        Employee emp = emap.get(eid);
        int ans = emp.importance;

        for(Integer subId : emp.subordinates) {
            ans+= dfs(subId);
        }

        return ans;
    }
}