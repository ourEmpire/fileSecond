package recursion;

public class Febonacci {
	public static void main(String[] args) {
		System.out.println(febonacci(3)); //打印斐波那契数列的第3个数
	}
	
	public static int febonacci(int index) {		//查找斐波那契数列的第index个数
		if(index == 1 || index == 2) {
			return 1;
		}else {
			return febonacci(index - 1) + febonacci(index - 2);
		}
	}
}
