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
		  SimpleDateFormat f=new SimpleDateFormat("hhmmss");//��ʽ��ʱ��		  
		  int time[]=new int[s.length];                     //�洢����ʱ��
		  int rel_time=0;	                                //����Integer.parseInt(f.format(Time.valueOf(text[2])))            
		  Map<Integer, String>map=new HashMap<>();          //����ʱ��19:00:00����ԭʼ�ַ���ƥ��
		  Map<String, Integer>map_name=new HashMap<>();		//����ÿ�˷��Դ���
		  for(int i=0;i<s.length;i++)
		  {			  
			  String text[]=s[i].split("    ");		
			  rel_time=Integer.parseInt(f.format(Time.valueOf(text[2])));
			  time[i]=rel_time;			  
			  map.put(rel_time,s[i]);
			  if(!map_name.containsKey(text[0]))             //���˷��Ծͷŵ�map
				  map_name.put(text[0], 1);
			  else {                                          //���˷��Լ���+1
				map_name.put(text[0], map_name.get(text[0])+1);
			}
		  }		
		  Arrays.sort(time);                                 //����ʱ��תΪint�����������		 
		  for(int i=0;i<s.length;i++)
		  {
			  System.out.println(map.get(time[i]));				         //��ʱ��Ϊ��ֵȡ��map�е�ԭʼ�ַ�����Ϊ����
		  }
		  
		//  System.out.println(Arrays.toString(s));
		  System.out.println(map_name.toString());
	  }   
public static void main(String[] args) {
	Solution solution=new Solution();
   // String s="X";
    //String sub="loveleetcode";
	String s[]={"����    2015-10-09    19:20:08    ����ѵ",
			    "����    2015-10-09    19:01:01    ѧУ��",
			    "����    2015-10-09    19:30:01    ��ͣ",
			    "����    2015-10-09    19:01:17    ʮһ����ѵ",
			    "����    2015-10-09    19:21:01    ʮ���º�",
			    "����    2015-10-09    19:51:01    ʮ44�º�"};
	//int ta=10;
	solution.OrderByTime(s);
 }
}