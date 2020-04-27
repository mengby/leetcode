package com.stu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组nums和一个目标值 target,请你在该数组中找出和为目标值的哪两个整数,并返回
 *
 * <p>
 * eg、
 * 给定 nums = [2,7,11,15], target = 9
 * 应为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回[0,1]
 * </p>
 * Created by bingye on 2020/4/27
 */
public class TwoSum {


    /**
     * 暴力破解的方式
     * 复杂度 O(n^n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution01(int[] nums, int target) {

        long startTime = System.currentTimeMillis();
        System.out.println("start time: " + startTime);
        int[] result = new int[2];
        // 复杂度 O(n)
        for (int i = 0; i < nums.length - 1; i++) {
            // 复杂度 O(n-1)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("end time: " + endTime);
        long totalTime = endTime - startTime;
        System.out.println("总共耗时: " + totalTime);
        return result;
    }

    /**
     * 建立k-v 对应的哈希表
     * k 对应数补数(target - nums[i]) v 对应数组下标
     * 复杂度 O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution02(int[] nums, int target) {
        long startTime = System.currentTimeMillis();
        System.out.println("start time: " + startTime);
        int[] result = new int[2];


        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                result[0] = i;
                result[1] = hash.get(nums[i]);
                break;
            }
            hash.put(target - nums[i], i);
        }


        long endTime = System.currentTimeMillis();
        System.out.println("end time: " + endTime);
        long totalTime = endTime - startTime;
        System.out.println("总共耗时: " + totalTime);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 23, 11, 15, 123, 32, 5435, 6, 77, 8, 9, 0, 7};
        int target = 9;
//        int[] ints = solution01(nums, target);
        int[] ints = solution02(nums, target);
        List<Integer> collect = Arrays.stream(ints)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
