package com.wxp.dfs;

import java.util.*;

/**
 * 690. 员工的重要性
 * Created by 10521 on 2018/10/27.
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public class GetImportance {
    int ans = 0;

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<Integer, Employee>();
        for(Employee em : employees){
            map.put(em.id,em);
        }
        dfs(map,id);

        return ans;
    }

    private int dfs(Map<Integer, Employee> map, int id) {
        Employee em = map.get(id);
        if(em != null){
            List<Integer> list = em.subordinates;
            ans += em.importance;
            for(Integer in : list){
                 dfs(map,in);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<Employee>();

        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();

        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = Arrays.asList(2, 3);

        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = Arrays.asList();

        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = Arrays.asList();

        list.add(e1);
        list.add(e2);
        list.add(e3);

        int ans =  new GetImportance().getImportance(list,1);
        System.out.println("最后的结果为："+ans);
    }
}
