/*�����һ����Ч�㷨���ٸ������ַ��������У��ҵ�����"Coder"���ַ���(�����ִ�Сд)��
��������Ϊһ���µ����鷵�ء�����ַ�����˳����"Coder"���ֵĴ����ݼ����У�
����������"Coder"���ֵĴ�����ͬ���򱣳�������ԭ�����е�λ�ù�ϵ��
����һ���ַ�������A�����Ĵ�Сn���뷵�ؽ�����顣��֤ԭ�����СС�ڵ���300,����ÿ�����ĳ���С�ڵ���200��
ͬʱ��֤һ�����ڰ���coder���ַ�����
����������
["i am a coder","Coder Coder","Code"],3
���أ�["Coder Coder","i am a coder"] */
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
