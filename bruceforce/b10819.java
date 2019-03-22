package baekjoon.bruceforce;

import java.util.Scanner;
import java.util.Arrays;

public class b10819 {
	
	public static int abs (int a)
	{
		if(a>=0)
			return a;
		else
			return -a;
	}
	
	public static boolean next(int[] arr)
	{
		int len = arr.length;
		int front = -1;
		int back=-1;
		for(int i = len-1; i>0 ;i--)
		{
			if(arr[i]>arr[i-1])
			{
				front = i-1;	
				break;
			}
		}
		if (front == -1)
		return false;
		
		
		for(int i = len-1; i>front ;i--)
		{
			if(arr[front]<arr[i])
			{
				back = i;
				break;
			}
		}

		
		
		int temp = arr[front];
		arr[front] = arr[back];
		arr[back]= temp;
		int first = front+1;
		int last = len-1;
		
		while(first<=last)
		{
			temp = arr[first];
			arr[first] = arr[last];
			arr[last]= temp;
			first++;
			last--;
		}
		return true;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [] arr = new int [num];
		for(int i=0; i<num ;i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0; i<num-1 ;i++)
		{
		   	sum = sum + abs(arr[i]-arr[i+1]);
		}
		int max = sum;
		while(next(arr))
		{
			sum =0;
			for(int i=0; i<num-1 ;i++)
			{
			   	sum = sum + abs(arr[i]-arr[i+1]);
			}
			if(sum>max)
				max = sum;
		}
		
		System.out.printf("%d\n", max);
		sc.close();
	}
}

