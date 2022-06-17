package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Utils;

/**
 * 
 */
public class MergeSort {

	
	public List<Integer> mergeSort(List<Integer> numbers) {
		if (numbers.size() <= 1) {
			return numbers;
		}
		
		// 分ける
		int middle = numbers.size() / 2;
		List<Integer> left = numbers.subList(0, middle);
		List<Integer> right = numbers.subList(middle, numbers.size());
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		// くっつける
		List<Integer> resultList = new ArrayList<Integer>();
		int leftIndex = 0;
		int rightIndex = 0;
		
		// 左右を比較する
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
			System.out.println(leftValue);
			System.out.println(rightValue);
			printList(resultList);
		}
		
		// あまりを詰め込む
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
		List<Integer> nums = Arrays.asList(5,4,1,8,7,3,2,9);
		MergeSort sort = new MergeSort();
		List<Integer> sorted = sort.mergeSort(nums);
		
		System.out.println("BEFORE");
		Utils.printList(nums);
		System.out.println("AFTER");
		Utils.printList(sorted);
	}
	
	private void printList(List<?> list) {
		System.out.println("**********LIST************");
		Utils.printList(list);
		System.out.println("**********LIST************");
	}
	

}
