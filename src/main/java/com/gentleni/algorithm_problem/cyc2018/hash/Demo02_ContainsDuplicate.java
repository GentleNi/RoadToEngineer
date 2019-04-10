package com.gentleni.algorithm_problem.cyc2018.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by GentleNi
 * Date 2019/3/27.
 */
public class Demo02_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}
