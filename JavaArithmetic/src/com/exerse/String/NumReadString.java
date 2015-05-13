package com.exerse.String;

import java.util.Arrays;  
import java.util.HashMap;  
import java.util.Map;  
  
/** 
 * @author liuyan 
 * @version 创建时间：2015-5-13
 */  
  
public class NumReadString {  
  
    /** 
     * 处理0，1,2.。9的中文读法的 
     */  
    private static Map<Integer, String> numberStringMap = new HashMap<Integer, String>();  
  
    /** 
     * 10进制的读法 
     */  
    private static Map<Integer, String> base10StringMap = new HashMap<Integer, String>();  
  
    static {  
        numberStringMap.put(0, "零");  
        numberStringMap.put(1, "壹");  
        numberStringMap.put(2, "贰");  
        numberStringMap.put(3, "叁");  
        numberStringMap.put(4, "肆");  
        numberStringMap.put(5, "伍");  
        numberStringMap.put(6, "陆");  
        numberStringMap.put(7, "柒");  
        numberStringMap.put(8, "捌");  
        numberStringMap.put(9, "玖");  
  
        base10StringMap.put(1, "");  
        base10StringMap.put(2, "十");  
        base10StringMap.put(3, "百");  
        base10StringMap.put(4, "千");  
        base10StringMap.put(5, "万");  
  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
  
        int a[] = { 100030 };  
        for (int i = 0; i < a.length; i++) {  
            readChinese(a[i]);  
        }  
  
    }  
  
    private static void readChinese(int a) {  
        String intString = a + "";  
        char ichar[] = intString.toCharArray();  
  
        char icharrevert[] = revertCharArray(ichar);  
  
        int i = 0;  
        String result = "";  
        while (i < icharrevert.length) {  
            char[] icharsplit = Arrays.copyOfRange(icharrevert, i, i + 4 < icharrevert.length ? i + 4  
                    : icharrevert.length);  
            result = processSplitedNumber(icharsplit, (i + 1) / 4) + result;  
            i = i + 4;  
        }  
  
        System.out.println("原数字为:"+a+"切换后的读法为："+result);  
    }  
  
    private static char[] revertCharArray(char[] ichar) {  
        char icharNew[] = new char[ichar.length];  
        /** 
         * 将得到的数组倒排,这样做原因是因为读的时候从前往后读， 位数前面的高 
         */  
        for (int i = ichar.length - 1, j = 0; i >= 0 && j < ichar.length; i--, j++) {  
            icharNew[j] = ichar[i];  
        }  
  
        return icharNew;  
    }  
  
    private static String processSplitedNumber(char[] num, int time) {  
        StringBuffer sb = new StringBuffer();  
  
        for (int i = num.length - 1; i >= 0; i--) {  
  
            //sb.append(num[i]);  
            if (num[i] == '0') {  
  
                /** 
                 * 当前数字是0.并且是最后一位，直接不读 
                 */  
                if (i == 0) {  
                    continue;  
                }  
  
                /** 
                 * 当前数字是0，下一个数字不是0，补一个0上去读 
                 */  
                if (num[i - 1] != '0') {  
                    sb.append(numberStringMap.get(Integer.valueOf(num[i] + "")));  
                } else {  
                    continue;  
                }  
  
            } else {  
                /** 
                 * 如果当前位数不是0，那就正常的读出数字和位 
                 */  
                sb.append(numberStringMap.get(Integer.valueOf(num[i] + "")));  
                sb.append(base10StringMap.get(i + 1));  
            }  
        }  
  
        if (time == 0) {  
        } else if (time == 1) {  
            sb.append("万");  
        } else if (time == 2) {  
            sb.append("亿");  
        }  
        return sb.toString();  
    }  
}  