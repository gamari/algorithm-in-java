package utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {

	public static void printList(List<?> list) {
		list.stream().forEach(item -> {
			System.out.println(item);
		});
	}
	
	public static List<Integer> createList(int length) {
		int count = 0;
		Random random = new Random();
		List<Integer> list = new ArrayList<>();
		while (count < length) {
			list.add(random.nextInt());
			count++;
		}
		return list;
	}
	
	public static void printListResult(List<?> before, List<?> after, long ms) {
		System.out.println("----BEFORE----");
		Utils.printList(before);
		System.out.println("----AFTER-----");
		Utils.printList(after);
		System.out.println("----TIMES----");
		System.out.println(ms+ "ms");
	}
	
	public static List<Integer> copyList(List<Integer> list) {
		return list.stream().collect(Collectors.toList());
	}
}
