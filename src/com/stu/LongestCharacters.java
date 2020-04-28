package com.stu;


import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * **********
 * <p>
 * eg、
 * 输入: "abcabcbb"
 * 输出: 3
 * 原因: 因为无重复字符的最长子串是 "abc", 所以其长度为 3.
 * <p>
 * 输入: "bbbbbb"
 * 输出: 1
 * <p>
 * 输入: "pwwkeew"
 * 输出: 3
 * 原因: 从第一个重复的字符算起
 * </p>
 * Created by bingye on 2020/4/27
 */
public class LongestCharacters {


    /**
     * 暴力遍历
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int res = 0;
        int max = 0;

        for (int i = 0; i < chars.length; i++) {
            for (int j = res; j < i; j++) {
                if (chars[i] == chars[j]) {
                    res = j + 1;
                    break;
                }
            }
            if (i - res + 1 > max) max = i - res + 1;
        }
        return max;
    }


    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();

        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        int n = s.length();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                System.out.println("add " + s.charAt(j) + " j: " + j + " i: " + i);
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                System.out.println("remove " + s.charAt(i) + " j: " + j + " i: " + i);
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        String abc = "pwwkkkew";
        int i = lengthOfLongestSubstring2(abc);
        System.out.println(i);

    }
}
