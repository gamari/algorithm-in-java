package sort;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

/**
 * 
 */
public class MergeSort {
	public List<Integer> mergeSort(List<Integer> numbers) {
		if (numbers.size() <= 1) {
			// exit point 最小要素まで分割する
			return numbers;
		}
		
		// 1. 分ける
		int middle = numbers.size() / 2;
		List<Integer> left = numbers.subList(0, middle);
		List<Integer> right = numbers.subList(middle, numbers.size());
		
		// 2. recursive => イメージで（分けるを最初に全部やるイメージ）
		left = mergeSort(left);
		right = mergeSort(right);
		
		// 3. くっつける
		List<Integer> resultList = new ArrayList<Integer>();
		int leftIndex = 0;
		int rightIndex = 0;
		
		// 3-1 左右を比較する
		while (leftIndex < left.size() && rightIndex < right.size()) {
			Integer leftValue = left.get(leftIndex);
			Integer rightValue = right.get(rightIndex);
			if (leftValue < rightValue) {
				resultList.add(leftValue);
				leftIndex++;
			} else {
				resultList.add(rightValue);
				rightIndex++;
			}
		}
		
		// 3-2 あまりを詰め込む
		while (leftIndex < left.size()) {
			resultList.add(left.get(leftIndex));
			leftIndex++;
		}
		
		while (rightIndex < right.size()) {
			resultList.add(right.get(rightIndex));
			rightIndex++;
		}
		
		return resultList;
	}
	
	
	public static void main(String[] args) {
		List<Integer> nums = Utils.createList(10);
		MergeSort sort = new MergeSort();
		
		long start = System.currentTimeMillis();
		List<Integer> sorted = sort.mergeSort(nums);
		long end = System.currentTimeMillis();
		
		System.out.println("BEFORE");
		Utils.printList(nums);
		System.out.println("AFTER");
		Utils.printList(sorted);
		System.out.println("TIMES");
		System.out.println((end-start) + "ms");
		
	}
	
	private void printList(List<?> list) {
		System.out.println("**********LIST************");
		Utils.printList(list);
		System.out.println("**********LIST************");
	}
	

}
