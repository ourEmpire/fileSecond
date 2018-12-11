package recursion;

public class Hanoi {			//汉诺塔问题
	public static void main(String[] args) {
		hanoi(3,'A','B','C');
	}
	/*
	 * n表示有多少个盘子
	 * from表示开始的柱子
	 * in表示要借助的柱子
	 * to表示要移到的柱子
	 * 
	 */
	public static void hanoi(int n,char from,char in,char to) {			
		if(n == 1) {			//当只有一个盘子时
			System.out.println("把第"+n+"个盘子从"+from+"移到"+to);
		}else {					//无论n为多少都看成两部分，上面的看成一个整体+最底层
			
			hanoi(n-1,from,to,in);		//把上部分的盘子移动到要借助的柱子
			System.out.println("把第"+n+"个盘子从"+from+"移到"+to);		
			hanoi(n-1,in,from,to);		//把上部分的盘子从借助的柱子移动到要移到的柱子
		}
	}
}
