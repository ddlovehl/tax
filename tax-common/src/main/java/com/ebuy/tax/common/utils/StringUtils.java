package com.ebuy.tax.common.utils;


import com.ebuy.tax.common.constants.SysConstant;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Project new_project
 * @Package com.jsonmedia.shop.core.util
 * @Author Tom
 * @Date 2018/7/23 21:37
 * @Description
 */
public final class StringUtils {
    public static final String EMPTY = "";

    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private static final Pattern KVP_PATTERN = Pattern
            .compile("([_.a-zA-Z0-9][-_.a-zA-Z0-9]*)[=](.*)");

    private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");

    public static boolean isBlank(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * is empty string.
     *
     * @param str source string.
     * @return is empty.
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * is not empty string.
     *
     * @param str source string.
     * @return is not empty.
     */
    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    /**
     * @param s1
     * @param s2
     * @return equals
     */
    public static boolean isEquals(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        return s1.equals(s2);
    }


    /**
     * @param oldS db字段旧值
     * @param newS db字段新值
     * @return
     * @throws
     * @Title: isChanged
     * @Description: 判断db字段值有没有改变，如果都是empty，认为没有改变
     */
    public static boolean isChanged(String oldS, String newS) {
        if (isEmpty(oldS) && isEmpty(newS)) {
            return false;
        }
        if (isEmpty(oldS) || isEmpty(newS)) {
            return true;
        }
        return !oldS.equals(newS);
    }

    /**
     * is integer string.
     *
     * @param str
     * @return is integer
     */
    public static boolean isInteger(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return INT_PATTERN.matcher(str).matches();
    }

    public static int parseInteger(String str) {
        if (!isInteger(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    /**
     * Returns true if s is a legal Java identifier.
     *
     * <a href="http://www.exampledepot.com/egs/java.lang/IsJavaId.html">more
     * info.</a>
     */
    public static boolean isJavaIdentifier(String s) {
        if (s.length() == 0 || !Character.isJavaIdentifierStart(s.charAt(0))) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            if (!Character.isJavaIdentifierPart(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param values
     * @param value
     * @return contains
     */
    public static boolean isContains(String[] values, String value) {
        if (value != null && value.length() > 0 && values != null
                && values.length > 0) {
            for (String v : values) {
                if (value.equals(v)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param e
     * @return string
     */
    public static String toString(Throwable e) {
        UnsafeStringWriter w = new UnsafeStringWriter();
        PrintWriter p = new PrintWriter(w);
        p.print(e.getClass().getName());
        if (e.getMessage() != null) {
            p.print(": " + e.getMessage());
        }
        p.println();
        try {
            e.printStackTrace(p);
            return w.toString();
        } finally {
            p.close();
        }
    }

    /**
     * @param msg
     * @param e
     * @return string
     */
    public static String toString(String msg, Throwable e) {
        UnsafeStringWriter w = new UnsafeStringWriter();
        w.write(msg + "\n");
        PrintWriter p = new PrintWriter(w);
        try {
            e.printStackTrace(p);
            return w.toString();
        } finally {
            p.close();
        }
    }

    /**
     * translat.
     *
     * @param src  source string.
     * @param from src char table.
     * @param to   target char table.
     * @return String.
     */
    public static String translat(String src, String from, String to) {
        if (isEmpty(src)) {
            return src;
        }
        StringBuilder sb = null;
        int ix;
        char c;
        for (int i = 0, len = src.length(); i < len; i++) {
            c = src.charAt(i);
            ix = from.indexOf(c);
            if (ix == -1) {
                if (sb != null) {
                    sb.append(c);
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder(len);
                    sb.append(src, 0, i);
                }
                if (ix < to.length()) {
                    sb.append(to.charAt(ix));
                }
            }
        }
        return sb == null ? src : sb.toString();
    }

    /**
     * split.
     *
     * @param ch char.
     * @return string array.
     */
    public static String[] split(String str, char ch) {
        List<String> list = splitList(str, ch);
        return list == null ? EMPTY_STRING_ARRAY : (String[]) list
                .toArray(EMPTY_STRING_ARRAY);
    }

    /**
     * wensheng.du
     *
     * @param str
     * @param ch
     * @return
     */
    public static List<String> splitList(String str, char ch) {

        if (StringUtils.isBlank(str)) {
            return new ArrayList<String>();
        }

        if (!str.contains(ch + "")) {
            List<String> res = new ArrayList<String>();
            res.add(str);
            return res;
        }

        List<String> list = null;
        char c;
        int ix = 0, len = str.length();
        for (int i = 0; i < len; i++) {
            c = str.charAt(i);
            if (c == ch) {
                if (list == null) {
                    list = new ArrayList<String>();
                }
                list.add(str.substring(ix, i));
                ix = i + 1;
            }
        }
        if (ix > 0) {
            list.add(str.substring(ix));
        }
        return list == null ? new ArrayList<String>(0) : list;
    }

    /**
     * join string.
     *
     * @param array String array.
     * @return String.
     */
    public static String join(String[] array) {
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * join string like javascript.
     *
     * @param array String array.
     * @param split split
     * @return String.
     */
    public static String join(String[] array, char split) {
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(split);
            }
            sb.append(array[i]);
        }
        return sb.toString();
    }

    /**
     * parse key-value pair.
     *
     * @param str           string.
     * @param itemSeparator item separator.
     * @return key-value map;
     */
    private static Map<String, String> parseKeyValuePair(String str,
                                                         String itemSeparator) {
        String[] tmp = str.split(itemSeparator);
        Map<String, String> map = new HashMap<String, String>(tmp.length);
        for (int i = 0; i < tmp.length; i++) {
            Matcher matcher = KVP_PATTERN.matcher(tmp[i]);
            if (matcher.matches() == false)
                continue;
            map.put(matcher.group(1), matcher.group(2));
        }
        return map;
    }

    public static String getQueryStringValue(String qs, String key) {
        Map<String, String> map = StringUtils.parseQueryString(qs);
        return map.get(key);
    }

    /**
     * parse query string to Parameters.
     *
     * @param qs query string.
     * @return Parameters instance.
     */
    public static Map<String, String> parseQueryString(String qs) {
        if (qs == null || qs.length() == 0)
            return new HashMap<String, String>();
        return parseKeyValuePair(qs.replaceAll("\\?", "\\&"), "\\&");
    }


    public static String toQueryString(Map<String, String> ps) {
        StringBuilder buf = new StringBuilder();
        if (ps != null && ps.size() > 0) {
            for (Map.Entry<String, String> entry : new TreeMap<String, String>(
                    ps).entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && key.length() > 0 && value != null
                        && value.length() > 0) {
                    if (buf.length() > 0) {
                        buf.append("&");
                    }
                    buf.append(key);
                    buf.append("=");
                    buf.append(value);
                }
            }
        }
        return buf.toString();
    }

    public static String camelToSplitName(String camelName, String split) {
        if (camelName == null || camelName.length() == 0) {
            return camelName;
        }
        StringBuilder buf = null;
        for (int i = 0; i < camelName.length(); i++) {
            char ch = camelName.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                if (buf == null) {
                    buf = new StringBuilder();
                    if (i > 0) {
                        buf.append(camelName.substring(0, i));
                    }
                }
                if (i > 0) {
                    buf.append(split);
                }
                buf.append(Character.toLowerCase(ch));
            } else if (buf != null) {
                buf.append(ch);
            }
        }
        return buf == null ? camelName : buf.toString();
    }

    public static boolean equals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equals(str2);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }

        return str1.equalsIgnoreCase(str2);
    }

    private StringUtils() {
    }

    private static String getZeroLen(int len) {
        String str = "";
        for (int i = 0; i < len; i++) {
            str = str + "0";
        }
        return str;
    }

    public static String comdify(String value) {
        DecimalFormat df = null;
        if (value.indexOf(".") > 0) {
            int i = value.length() - value.indexOf(".") - 1;
            switch (i) {
                case 0:
                    df = new DecimalFormat("###,##0");
                    break;
                case 1:
                    df = new DecimalFormat("###,##0.0");
                    break;
                case 2:
                    df = new DecimalFormat("###,##0.00");
                    break;
                case 3:
                    df = new DecimalFormat("###,##0.000");
                    break;
                case 4:
                    df = new DecimalFormat("###,##0.0000");
                    break;
                default:
                    df = new DecimalFormat("###,##0.00000");
                    break;
            }
        } else {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0D;
        try {
            number = Double.parseDouble(value);
        } catch (Exception e) {
            number = 0.0D;
        }
        return df.format(number);
    }


    public static String trimSufffix(String toTrim, String trimStr) {
        while (toTrim.endsWith(trimStr)) {
            toTrim = toTrim.substring(0, toTrim.length() - trimStr.length());
        }
        return toTrim;
    }

    public static String trimPrefix(String toTrim, String trimStr) {
        while (toTrim.startsWith(trimStr)) {
            toTrim = toTrim.substring(trimStr.length());
        }
        return toTrim;
    }

    public static String trim(String toTrim, String trimStr) {
        return trimSufffix(trimPrefix(toTrim, trimStr), trimStr);
    }

    public static String trim(String str) {
        return str != null ? str.trim() : null;
    }

    public static String replaceAll(String toReplace, String replace,
                                    String replaceBy) {
        replaceBy = replaceBy.replaceAll("\\$", "\\\\\\$");
        return toReplace.replaceAll(replace, replaceBy);
    }

    public static String substringBefore(String sourceStr, char beforeStr) {
        String[] strs = split(sourceStr, beforeStr);
        if (strs != null && strs.length > 0) {
            return strs[0];
        }
        return null;
    }

    /**
     * @param successIds 成功的id集合
     * @param failIds    失败的id集合
     * @return
     * @throws
     * @Title: createResponseMsg2
     * @Description: 批量操作列表数据时，返回前端的提示信息(例如：删除，冻结，解冻商品信息)
     */
    public static String createResponseMsg2(List<String> successIds, List<String> failIds) {
        StringBuffer msgSb = new StringBuffer();
        if (!successIds.isEmpty()) {
            for (int i = 0; i < successIds.size(); i++) {
                if (i == 0) {
                    msgSb.append(successIds.get(i));
                } else {
                    msgSb.append(",");
                    msgSb.append(successIds.get(i));
                }
            }
            msgSb.append("操作成功！");
        } else {
            msgSb.append("0个操作成功！");
        }
        if (!failIds.isEmpty()) {
            for (int j = 0; j < failIds.size(); j++) {
                if (j == 0) {
                    msgSb.append(failIds.get(j));
                } else {
                    msgSb.append(",");
                    msgSb.append(failIds.get(j));
                }
            }
            msgSb.append("操作失败！");
        } else {
            msgSb.append("0个操作失败！");
        }
        return msgSb.toString();
    }


    /**
     * @param str
     * @return
     * @throws
     * @Title: stringToInt
     * @Description: 将string转成int，主要用于系统中amount数量的加减
     */
    public static int strToInt(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int rs = 0;
        try {
            rs = Integer.parseInt(str);
        } catch (Exception e) {
            rs = 0;
        }
        return rs;
    }

    public static String Html2Text(String inputString) {
        if (isEmpty(inputString)) {
            return "";
        }
        String htmlStr = inputString; //含html标签的字符串
        String textStr = "";
        Pattern p_script;
        Matcher m_script;
        Pattern p_style;
        Matcher m_style;
        Pattern p_html;
        Matcher m_html;

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> }
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> }
            String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

            p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
            m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll(""); //过滤script标签

            p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
            m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll(""); //过滤style标签

            p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
            m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll(""); //过滤html标签

            htmlStr = htmlStr.replaceAll("&nbsp;", "");
            textStr = htmlStr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return textStr;//返回文本字符串
    }

    /**
     * @param num
     * @return
     * @throws
     * @Title: getMinus
     * @Description: 获取负数
     */
    public static String getMinus(String num) {
        if (isEmpty(num)) {
            return "0";
        }
        int numInt = 0;
        try {
            numInt = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            numInt = 0;
        }
        return String.valueOf(numInt * (-1));
    }

    public static String capitalize(String str) {
        return org.apache.commons.lang3.StringUtils.capitalize(str);
    }

    public static String uncapitalize(String str) {
        return org.apache.commons.lang3.StringUtils.uncapitalize(str);
    }

    /**
     * 功能描述: 2个string数字相减，返回string数字
     *
     * @param:
     * @return:
     * @author: Tom
     * @date: 2018/7/24 上午2:00
     */
    public static String amountSubtraction(String amount1, String amount2) {
        int amount1Int = strToInt(amount1);
        int amount2Int = strToInt(amount2);
        int rs = amount1Int - amount2Int;
        return String.valueOf(rs);
    }

    /**
     * 功能描述: 2个string数字相加，返回string数字
     *
     * @param:
     * @return:
     * @author: Tom
     * @date: 2018/7/24 上午2:00
     */
    public static String amountPlus(String amount1, String amount2) {
        int amount1Int = strToInt(amount1);
        int amount2Int = strToInt(amount2);
        int rs = amount1Int + amount2Int;
        return String.valueOf(rs);
    }

    /**
     * 功能描述: amount 比较
     *
     * @param:
     * @return:
     * @author: Tom
     * @date: 2018/7/24 上午2:00
     */
    public static int amountCompare(String amount1, String amount2) {
        int amount1Int = strToInt(amount1);
        int amount2Int = strToInt(amount2);
        if (amount1Int > amount2Int) {
            return 1;
        }
        if (amount1Int < amount2Int) {
            return -1;
        }
        return 0;
    }

    /**
     * 从ids中获取idList
     *
     * @param ids
     * @return
     */
    public static List<BigInteger> getIdList(String ids) {
        List<BigInteger> idList = new ArrayList<BigInteger>();
        if (ids == null || ids.isEmpty()) {
            return idList;
        }
        String[] idArray = ids.split(SysConstant.COMMA);
        for (String id : idArray) {
            idList.add(new BigInteger(id));
        }
        return idList;
    }

    /**
     * 解析以','分割的字符串，返回String List
     *
     * @param items
     * @return
     */
    public static List<String> getItemList(String items) {
        List<String> rsList = new ArrayList<String>();
        if (items == null || items.isEmpty()) {
            return rsList;
        }
        String[] itemArray = items.split(SysConstant.COMMA);
        for (String item : itemArray) {
            rsList.add(item);
        }
        return rsList;
    }

    /**
     * 解析以','分割的字符串，返回BigInteger List
     *
     * @param items
     * @return
     */
    public static List<BigInteger> getBigIntegerItemList(String items) {
        List<BigInteger> rsList = new ArrayList<BigInteger>();
        if (items == null || items.isEmpty()) {
            return rsList;
        }
        String[] itemArray = items.split(SysConstant.COMMA);
        for (String item : itemArray) {
            rsList.add(new BigInteger(item));
        }
        return rsList;
    }

    /**
     * 如果为null 或者 ""认为相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isEqualIgnoreBlank(String str1, String str2) {
        if (isEmpty(str1) && isEmpty(str2)) {
            return true;
        }
        if (!isEmpty(str1) && isEmpty(str2)) {
            return false;
        }
        if (isEmpty(str1) && isEmpty(str2)) {
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 功能描述: 将String id数组转成BigInteger List
     *
     * @param:
     * @return:
     * @author: Tom
     * @date: 2018/7/24 上午2:01
     */
    public static List<BigInteger> convertStrIds(String[] ids) {
        List<BigInteger> idList = new ArrayList<BigInteger>();
        if (ids == null || ids.length == 0) {
            return idList;
        }
        for (String id : ids) {
            idList.add(new BigInteger(id));
        }
        return idList;
    }

    public static List<BigInteger> convertStrIds(List<String> ids){
        List<BigInteger> result = new LinkedList<BigInteger>();
        for(String id:ids){
            result.add(new BigInteger(id));
        }
        return result;
    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0))) {
            return s;
        }else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }


    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0))) {
            return s;
        }else {
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
