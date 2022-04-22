package com.wxp.algrithm.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @description: O(1)时间复杂度的随机Set
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 *
 * list+map （insert满足，remove满足，getRandom满足）
 * map存下标（hashcode，下标）
 * list存内容（）
 *
 * @author: wxp
 * @time: 2022/4/13 7:52
 */
public class RandomizedSet_380 {

    /**
     * 存放hashcode，元素下标
     */
    private HashMap<Integer,Integer> indexHashCodeMap ;
    /**
     * 存放元素
     */
    private List<Integer> elementList ;

    public RandomizedSet_380() {
        indexHashCodeMap = new HashMap<>();
        elementList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(indexHashCodeMap.containsKey(val)){
            return false;
        }
        elementList.add(val);
        indexHashCodeMap.put(val,elementList.size() - 1);
        return  true;
    }

    /**
     * 删除的时候。需要将元素放置于list最后位，再进行移除，避免对其他元素下标造成影响
     * @param val 删除的元素
     */
    public boolean remove(int val) {
        if(!indexHashCodeMap.containsKey(val)){
            return false;
        }

        int index = indexHashCodeMap.get(val);
        //获取最后一位元素，进行交换,再删除最后一位元素，以此来达到删除当前元素的目的
        int lastIndex = elementList.size() - 1;
        int lastVal = elementList.get(lastIndex);
        elementList.set(index,lastVal);
        indexHashCodeMap.put(lastVal,index);
        elementList.remove(lastIndex);
        //删除indexMap中的映射
        indexHashCodeMap.remove(val);

        return true;
    }

    public int getRandom() {
        int size = elementList.size();
        Random random = new Random();
        int index = random.nextInt(size);
        return elementList.get(index);
    }

    public static void main(String[] args) {
        //["RandomizedSet","insert","insert","remove","insert","remove","getRandom"]
        //[[],[0],[1],[0],[2],[1],[]]
        RandomizedSet_380 randomSet = new RandomizedSet_380();
        System.out.println(randomSet.insert(0));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.remove(1));

//        System.out.println(randomSet.remove(2));
//        System.out.println(randomSet.remove(2));
//        System.out.println(randomSet.remove(3));
//        System.out.println(randomSet.remove(5));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.getRandom());


    }
}
