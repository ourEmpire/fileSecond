package recursion;

public class Febonacci {
	public static void main(String[] args) {
		System.out.println(febonacci(3)); //��ӡ쳲��������еĵ�3����
	}
	
	public static int febonacci(int index) {		//����쳲��������еĵ�index����
		if(index == 1 || index == 2) {
			return 1;
		}else {
			return febonacci(index - 1) + febonacci(index - 2);
		}
	}
}
