import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestElementinBST_230 {
	List<Integer> list = new ArrayList<Integer>();

	public int kthSmallest(TreeNode root, int k) {
		find(root);
		Collections.sort(list);
		return list.get(k - 1);
	}

	public void find(TreeNode node) {
		list.add(node.val);
		if (node.left != null)
			find(node.left);
		if (node.right != null)
			find(node.right);
	}
}
