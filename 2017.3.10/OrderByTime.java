package org.test;

import java.util.*;
import java.lang.reflect.Array;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.imageio.event.IIOReadWarningListener;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.ORBPackage.InconsistentTypeCode;

public class Solution {	
	  public void OrderByTime(String[] s) {	       
		  SimpleDateFormat f=new SimpleDateFormat("hhmmss");//格式化时间		  
		  int time[]=new int[s.length];                     //存储具体时间
		  int rel_time=0;	                                //表述Integer.parseInt(f.format(Time.valueOf(text[2])))            
		  Map<Integer, String>map=new HashMap<>();          //具体时间19:00:00等与原始字符串匹配
		  Map<String, Integer>map_name=new HashMap<>();		//计算每人发言次数
		  for(int i=0;i<s.length;i++)
		  {			  
			  String text[]=s[i].split("    ");		
			  rel_time=Integer.parseInt(f.format(Time.valueOf(text[2])));
			  time[i]=rel_time;			  
			  map.put(rel_time,s[i]);
			  if(!map_name.containsKey(text[0]))             //新人发言就放到map
				  map_name.put(text[0], 1);
			  else {                                          //老人发言计数+1
				map_name.put(text[0], map_name.get(text[0])+1);
			}
		  }		
		  Arrays.sort(time);                                 //具体时间转为int，排序后有序		 
		  for(int i=0;i<s.length;i++)
		  {
			  System.out.println(map.get(time[i]));				         //以时间为键值取出map中的原始字符串即为有序
		  }
		  
		//  System.out.println(Arrays.toString(s));
		  System.out.println(map_name.toString());
	  }   
public static void main(String[] args) {
	Solution solution=new Solution();
   // String s="X";
    //String sub="loveleetcode";
	String s[]={"张三    2015-10-09    19:20:08    月培训",
			    "李四    2015-10-09    19:01:01    学校买房",
			    "王五    2015-10-09    19:30:01    暂停",
			    "张三    2015-10-09    19:01:17    十一月培训",
			    "王五    2015-10-09    19:21:01    十二月号",
			    "王五    2015-10-09    19:51:01    十44月号"};
	//int ta=10;
	solution.OrderByTime(s);
 }
}