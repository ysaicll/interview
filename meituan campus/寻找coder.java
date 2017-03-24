/*请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，
并将其作为一个新的数组返回。结果字符串的顺序按照"Coder"出现的次数递减排列，
若两个串中"Coder"出现的次数相同，则保持他们在原数组中的位置关系。
给定一个字符串数组A和它的大小n，请返回结果数组。保证原数组大小小于等于300,其中每个串的长度小于等于200。
同时保证一定存在包含coder的字符串。
测试样例：
["i am a coder","Coder Coder","Code"],3
返回：["Coder Coder","i am a coder"] */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution {
	public String[] findCoder(String[] A, int n) {
		// write code here
		if(A.length==1)
			return A;	
		String res="";
		int numOfcoder[] = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (A[i].toLowerCase().contains("coder")) {
				String everyElement[] = A[i].split(" ");
				for (int j = 0; j < everyElement.length; j++) {
					if (everyElement[j].equalsIgnoreCase("coder"))
						count++;
				}
				numOfcoder[i] = count;
				count = 0;
			}
		}
		System.out.println(Arrays.toString(numOfcoder));
		int mark=0;
		for(int j=0;j<numOfcoder.length;j++)
		{
		   for(int i=0;i<numOfcoder.length;i++)
	    	{
			  if(numOfcoder[i]!=0&&numOfcoder[i]>numOfcoder[mark])
			    {
				  mark=i;
			    }			       
		    }
		   if(!res.contains(A[mark]))
		   {
			   res+=A[mark]+",";
	           numOfcoder[mark]=0;
	           mark=0;
		   }
		   else {
			   numOfcoder[mark]=0;
	           mark=0;
		}
		}
		String temp[]=res.split(",");		
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution a = new Solution();
		String[] strings = { "i am a coder", "Coder Coder", "Code","coder coder coder 1","coder coder coder 2"  };
		int n = 5;
		a.findCoder(strings, n);
		// System.out.println(a.searchMatrix(digit, x));

	}
}
