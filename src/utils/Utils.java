package utils;
import java.util.List;

public class Utils {

	public static void printList(List<?> list) {
		list.stream().forEach(item -> {
			System.out.println(item);
		});
	}
}
