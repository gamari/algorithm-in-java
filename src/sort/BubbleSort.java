package sort;

import java.util.List;

import utils.Utils;

public class BubbleSort {

	public List<Integer> bubbleSort(List<Integer> list) {
		int length = list.size();
		
		// limit -> リストの末尾を表すIndex
		// iはlimitを含まない（2要素を調べるため）
		for (int limit = length - 1; limit > 1; limit--) {
			for (int i = 0; i < limit; i++) {
				Integer left = list.get(i);
				Integer right = list.get(i+1);
				if (left > right) {
					// SWAP
					list.set(i, right);
					list.set(i+1, left);
				}
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		BubbleSort sort = new BubbleSort();
		List<Integer> nums = Utils.createList(100);
		List<Integer> before = Utils.copyList(nums);
		
		long start = System.currentTimeMillis();
		List<Integer> sorted = sort.bubbleSort(nums);
		long end = System.currentTimeMillis();
		
		
		Utils.printListResult(before, sorted, end-start);
	}
}
