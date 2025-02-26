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

    public int dfs(int id) {

        int ans = emap.get(id).importance;

        for(Integer sub : emap.get(id).subordinates) {
            ans += dfs(sub);
        } 

        return ans;
    }
}