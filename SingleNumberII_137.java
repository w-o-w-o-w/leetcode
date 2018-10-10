import java.util.HashMap;
import java.util.Map;

public class SingleNumberII_137 {
	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				return key;
			}
		}
		return 0;
	}
}
