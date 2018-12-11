
package dataStructuresAndAlgorithms.test;

import java.lang.RuntimeException;
import dataStructuresAndAlgorithms.MyArray;

public class TestArray{
	public static void main(String[] args) throws RuntimeException {
		MyArray ma = new MyArray();
		ma.add(9);
		ma.add(8);
		ma.add(7);
		ma.add(6);
		ma.add(5);
		ma.show();
		ma.deleteElement(3);
		ma.show();
		ma.insertElement(3, 6);
		ma.show();
		System.out.println("index = " + ma.lineSearch(7));
		System.out.println("index = " + ma.binarySearch(7));
		
	}
}
