package com.ebuy.tax.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hdq
 * @date 2018/9/10 18:54
 * @desc 分页util
 */
@Slf4j
public class PageUtils {

	/**
	 * @return java.lang.String
	 * @param list,pageNo,pageSize
	 * @author hdq
	 * @Description String类型的list 分页取数据
	 * @date 2018/9/10 18:56
	 */
	public static List<String> subListForPage(List<String> list, Integer pageNo, Integer pageSize) {
		int start = (pageNo - 1) * pageSize;
		int end = pageNo * pageSize;
		//防止下标越界
		if(end>list.size()){
			end = list.size();
		}
		log.info("start:{},,end:{}", start, end);
		List<String> resultList = list.subList(start, end);
		return resultList;
	}

//	public static void main(String [] args){
//		List<String> list = new LinkedList<String>();
//		for(int i=0;i<3;i++){
//			list.add(i+"");
//		}
//		log.info("原list:{}",list);
//		List<String> list2 = subListForPage(list,1,10);
//
//		log.info("list:{}",list2);
//	}
}
