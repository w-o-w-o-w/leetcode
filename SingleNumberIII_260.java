import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SingleNumberIII_260 {
	public int[] singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int n : nums) {
			if (set.contains(n)) {
				set.remove(n);
			} else {
				set.add(n);
			}
		}

		int[] result = new int[2];
		Iterator<Integer> it = set.iterator();
		result[0] = it.next();
		result[1] = it.next();
		return result;
	}
}
