import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber_136 {
	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int n : nums) {
			if (set.contains(n)) {
				set.remove(n);
			} else {
				set.add(n);
			}
		}

		Iterator<Integer> it = set.iterator();
		it.hasNext();
		return it.next();
	}
}
