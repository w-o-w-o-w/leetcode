import java.util.Arrays;

public class MaximumBinaryTree_654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root=execute(nums);
		return root;
    }
    
    TreeNode execute(int arr[]){
		if(arr.length==0){
			return null;
		}
		
		//max value
		int[] copy=Arrays.copyOf(arr, arr.length);
		Arrays.sort(copy);
		int max=copy[copy.length-1];
		System.out.println(max);
		int maxOffset=-1;
		for(int i=0;i<copy.length;++i){
			if(max==arr[i]){
				maxOffset=i;
			}
		}
		//tree
		TreeNode root=new TreeNode(max);
		int[] left=Arrays.copyOfRange(arr, 0, maxOffset);
		TreeNode leftNode=execute(left);
		if(leftNode!=null){
			root.left=leftNode;
		}

		int[] right=Arrays.copyOfRange(arr, maxOffset+1, arr.length);
		TreeNode rightNode=execute(right);
		if(rightNode!=null){
			root.right=rightNode;
		}
		
		return root;
	}
}
