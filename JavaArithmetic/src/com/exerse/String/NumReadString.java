package com.exerse.String;

import java.util.Arrays;  
import java.util.HashMap;  
import java.util.Map;  
  
/** 
 * @author liuyan 
 * @version ����ʱ�䣺2015-5-13
 */  
  
public class NumReadString {  
  
    /** 
     * ����0��1,2.��9�����Ķ����� 
     */  
    private static Map<Integer, String> numberStringMap = new HashMap<Integer, String>();  
  
    /** 
     * 10���ƵĶ��� 
     */  
    private static Map<Integer, String> base10StringMap = new HashMap<Integer, String>();  
  
    static {  
        numberStringMap.put(0, "��");  
        numberStringMap.put(1, "Ҽ");  
        numberStringMap.put(2, "��");  
        numberStringMap.put(3, "��");  
        numberStringMap.put(4, "��");  
        numberStringMap.put(5, "��");  
        numberStringMap.put(6, "½");  
        numberStringMap.put(7, "��");  
        numberStringMap.put(8, "��");  
        numberStringMap.put(9, "��");  
  
        base10StringMap.put(1, "");  
        base10StringMap.put(2, "ʮ");  
        base10StringMap.put(3, "��");  
        base10StringMap.put(4, "ǧ");  
        base10StringMap.put(5, "��");  
  
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
  
        System.out.println("ԭ����Ϊ:"+a+"�л���Ķ���Ϊ��"+result);  
    }  
  
    private static char[] revertCharArray(char[] ichar) {  
        char icharNew[] = new char[ichar.length];  
        /** 
         * ���õ������鵹��,������ԭ������Ϊ����ʱ���ǰ������� λ��ǰ��ĸ� 
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
                 * ��ǰ������0.���������һλ��ֱ�Ӳ��� 
                 */  
                if (i == 0) {  
                    continue;  
                }  
  
                /** 
                 * ��ǰ������0����һ�����ֲ���0����һ��0��ȥ�� 
                 */  
                if (num[i - 1] != '0') {  
                    sb.append(numberStringMap.get(Integer.valueOf(num[i] + "")));  
                } else {  
                    continue;  
                }  
  
            } else {  
                /** 
                 * �����ǰλ������0���Ǿ������Ķ������ֺ�λ 
                 */  
                sb.append(numberStringMap.get(Integer.valueOf(num[i] + "")));  
                sb.append(base10StringMap.get(i + 1));  
            }  
        }  
  
        if (time == 0) {  
        } else if (time == 1) {  
            sb.append("��");  
        } else if (time == 2) {  
            sb.append("��");  
        }  
        return sb.toString();  
    }  
}  