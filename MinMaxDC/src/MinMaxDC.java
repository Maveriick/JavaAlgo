import java.util.Arrays;
/**
 * 
 * @author ashutosh
 * Divide and Conquer Algorithm for Min/Max Finding
 * Reduces the number of comparisons compared to the linear algorithm
 */

public class MinMaxDC {
	
	public static int MinDC(int data[]){
		if (data.length == 1){
			return data[0];
		}else if(data.length == 2){
			if(data[0] < data[1]){
				return data[0];
			}else{
				return data[1];
			}
		}else{
			int mid = (int) Math.floor((data.length) / 2);
			int[] dataLeft = Arrays.copyOfRange(data,0,mid);
			int[] dataRight = Arrays.copyOfRange(data,mid,data.length);
			int minLeft = MinDC(dataLeft);
			int minRight = MinDC(dataRight);
			if(minLeft < minRight){
				return minLeft;
			}else{
				return minRight;
			}
		}
	}
	
	
	public static void main(String args[]){
		int data[] = {-4,-9,44,23,10,5,-99,4,5,33,58,62,39};
		int min = MinDC(data);
		System.out.print(min);
		
		
	}
}
