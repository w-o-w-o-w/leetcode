import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow_515 {

	public static void main(String ar[]) {
		TreeNode root = new TreeNode(1);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(3);
		TreeNode t6 = new TreeNode(9);
		root.left = t2;
		root.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		System.out.println(largestValues(root));

	}

	public static List<Integer> largestValues(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> qodd = new LinkedList<TreeNode>();
		qodd.add(root);
		Queue<TreeNode> qeven = new LinkedList<TreeNode>();

		List<Integer> nums = new ArrayList<Integer>();
		while (!qodd.isEmpty() || !qeven.isEmpty()) {

			while (!qodd.isEmpty()) {
				TreeNode p = qodd.poll();
				nums.add(p.val);
				if (p.left != null)
					qeven.add(p.left);
				if (p.right != null)
					qeven.add(p.right);
			}
			if (nums.size() > 0) {
				Collections.sort(nums);
				result.add(nums.get(nums.size() - 1));
				nums.clear();
			}

			while (!qeven.isEmpty()) {
				TreeNode p = qeven.poll();
				nums.add(p.val);
				if (p.left != null)
					qodd.add(p.left);
				if (p.right != null)
					qodd.add(p.right);
			}
			if (nums.size() > 0) {
				Collections.sort(nums);
				result.add(nums.get(nums.size() - 1));
				nums.clear();
			}
		}
		return result;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
