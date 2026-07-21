import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BSTPracticeQuestions {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Scenario 1: Search
    public static boolean search(TreeNode root, int target) {
        TreeNode current = root;
        while (current != null) {
            if (target == current.val) return true;
            current = (target < current.val) ? current.left : current.right;
        }
        return false;
    }

    // Scenario 2: Insert
    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.val) {
            root.left = insert(root.left, value);
        } else if (value > root.val) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    // Scenario 3: Delete
    public static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }
        return root;
    }

    // Scenario 4: Validate BST
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // Scenario 5: Kth smallest
    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            count++;
            if (count == k) return current.val;
            current = current.right;
        }
        throw new IllegalArgumentException("k out of range");
    }

    // Scenario 6: Lowest common ancestor
    public static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        TreeNode current = root;
        while (current != null) {
            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    // LeetCode 700: Search in a BST
    public static TreeNode searchBST(TreeNode root, int val) {
        return searchNode(root, val);
    }

    private static TreeNode searchNode(TreeNode node, int val) {
        if (node == null || node.val == val) return node;
        return val < node.val ? searchNode(node.left, val) : searchNode(node.right, val);
    }

    // LeetCode 701: Insert into a BST
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    // LeetCode 450: Delete Node in a BST
    public static TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    // LeetCode 98: Validate Binary Search Tree
    public static boolean isValidBSTLeetCode(TreeNode root) {
        return isValidBST(root);
    }

    // LeetCode 230: Kth Smallest Element in a BST
    public static int kthSmallestLeetCode(TreeNode root, int k) {
        return kthSmallest(root, k);
    }

    // LeetCode 235: Lowest Common Ancestor of a BST
    public static TreeNode lowestCommonAncestorLeetCode(TreeNode root, int p, int q) {
        return lowestCommonAncestor(root, p, q);
    }

    // LeetCode 108: Convert Sorted Array to BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }

    // LeetCode 530: Minimum Absolute Difference in BST
    public static int getMinimumDifference(TreeNode root) {
        int[] minDiff = {Integer.MAX_VALUE};
        TreeNode prev = null;
        inorderMinDiff(root, prev, minDiff);
        return minDiff[0];
    }

    private static void inorderMinDiff(TreeNode node, TreeNode prev, int[] minDiff) {
        if (node == null) return;
        inorderMinDiff(node.left, prev, minDiff);
        if (prev != null) {
            minDiff[0] = Math.min(minDiff[0], node.val - prev.val);
        }
        prev = node;
        inorderMinDiff(node.right, prev, minDiff);
    }

    // LeetCode 938: Range Sum of BST
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        if (root.val > high) return rangeSumBST(root.left, low, high);
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    // LeetCode 653: Two Sum IV - Input is a BST
    public static boolean findTarget(TreeNode root, int k) {
        Set<Integer> seen = new HashSet<>();
        return dfsFindTarget(root, k, seen);
    }

    private static boolean dfsFindTarget(TreeNode node, int k, Set<Integer> seen) {
        if (node == null) return false;
        if (seen.contains(k - node.val)) return true;
        seen.add(node.val);
        return dfsFindTarget(node.left, k, seen) || dfsFindTarget(node.right, k, seen);
    }

    public static void main(String[] args) {
        TreeNode root = insert(null, 50);
        insert(root, 30);
        insert(root, 70);
        insert(root, 20);
        insert(root, 40);
        insert(root, 60);
        insert(root, 80);

        System.out.println("Search 40 -> " + search(root, 40));
        System.out.println("Kth smallest (3rd) -> " + kthSmallest(root, 3));
        System.out.println("LCA(20, 40) -> " + lowestCommonAncestor(root, 20, 40).val);
        System.out.println("Valid BST -> " + isValidBST(root));
    }
}
