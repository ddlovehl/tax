package com.ebuy.tax.common.constants;

/**
 * 系统常量类
* @author dd
* @date 2018年9月4日
 */
public class SysConstant {

    public static final Integer ONE = 1;

    /** 英文逗号 */
    public static final String COMMA = ",";
    
    /** 用户版本号 */
    public static final String VERSION_USER_SERVER = "v1.0";
    
    /** h5版本号 */
    public static final String VERSION_H5_SERVER = "v1.0";
    
    /** UTF-8 */
    public static final String CHARSET_UTF8 = "UTF-8";
    
    /** yyyy-MM-dd hh:mm:ss */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";


    /**用户状态(0:正常，1:禁用，9:删除) */
    public static enum USER_STATUS {
        NORMAL(0),
        DISABLED(1),
        DELETED(9);

        private int value;

        private USER_STATUS(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**是否默认(0:否；1:是) */
    public static enum IS_DEFAULT{
        NO(0),
        YES(1);
        private int value;

        private IS_DEFAULT(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**是否删除(0:正常,9:删除) */
    public static enum IS_DELETED{
        NO(0),
        YES(9);
        private int value;

        private IS_DELETED(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
