package com.wxp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 10521 on 2018/9/2.
 */
public class PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result=new ArrayList<List<Integer>>();//List接口变量用的ArrayList类对象实例化
        List<Integer> temp=new ArrayList<Integer>();

        if(root==null)return result;
        DFS(result,temp,root,sum);
        return result;
    }

    void DFS(List<List<Integer>> result,List<Integer> temp,TreeNode root,int sum)
    {
        if(root==null)return;
        if(root.left==null&&root.right==null)
        {
            temp.add(root.val);
            if(sumOfPath(temp)==sum)
                result.add(new ArrayList(temp));//一定要注意
            temp.remove(temp.size()-1);
            return;
        }
        else
        {
            temp.add(root.val);
            DFS(result,temp,root.left,sum);
            DFS(result,temp,root.right,sum);
            temp.remove(temp.size()-1);
        }
    }

    int sumOfPath(List<Integer> temp)
    {
        int sum=0;
        for(int i=0;i<temp.size();i++)
        {
            sum+=temp.get(i);
        }
        return sum;
    }

}
