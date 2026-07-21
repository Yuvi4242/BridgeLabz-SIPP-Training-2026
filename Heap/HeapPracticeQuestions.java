import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HeapPracticeQuestions {

    // Heap utility operations for a min-heap stored in an int array.
    public static void siftUp(int[] arr, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (arr[parent] <= arr[index]) break;
            swap(arr, parent, index);
            index = parent;
        }
    }

    public static void siftDown(int[] arr, int index, int size) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && arr[left] < arr[smallest]) smallest = left;
            if (right < size && arr[right] < arr[smallest]) smallest = right;
            if (smallest == index) break;

            swap(arr, index, smallest);
            index = smallest;
        }
    }

    public static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }
        for (int end = n - 1; end > 0; end--) {
            swap(arr, 0, end);
            siftDown(arr, 0, end);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Scenario 1 & 4: Top-K largest / kth largest
    public static List<Integer> topKLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int value : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(value);
            } else if (value > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(value);
            }
        }
        return new ArrayList<>(minHeap);
    }

    public static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int value : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(value);
            } else if (value > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(value);
            }
        }
        return minHeap.peek();
    }

    // Scenario 6: Merge k sorted lists
    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> lists.get(a[0]).get(a[1])));
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<Integer> merged = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int listIndex = top[0];
            int elemIndex = top[1];
            merged.add(lists.get(listIndex).get(elemIndex));
            if (elemIndex + 1 < lists.get(listIndex).size()) {
                minHeap.offer(new int[]{listIndex, elemIndex + 1});
            }
        }
        return merged;
    }

    // LeetCode 1046: Last Stone Weight
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int diff = Math.abs(first - second);
            if (diff > 0) maxHeap.offer(diff);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    // LeetCode 703: Kth Largest Element in a Stream
    static class KthLargest {
        private final PriorityQueue<Integer> minHeap;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < k) {
                minHeap.offer(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }

    // LeetCode 215: Kth Largest Element in an Array
    public static int findKthLargest(int[] nums, int k) {
        return kthLargest(nums, k);
    }

    // LeetCode 973: K Closest Points to Origin
    public static List<List<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA);
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            result.add(List.of(point[0], point[1]));
        }
        result.sort((a, b) -> {
            int distA = a.get(0) * a.get(0) + a.get(1) * a.get(1);
            int distB = b.get(0) * b.get(0) + b.get(1) * b.get(1);
            return Integer.compare(distA, distB);
        });
        return result;
    }

    // LeetCode 347: Top K Frequent Elements
    public static int[] topKFrequent(int[] nums, int k) {
        java.util.Map<Integer, Integer> freq = new java.util.HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (java.util.Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }

    // LeetCode 912: Sort an Array using heap sort
    public static int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    // LeetCode 378: Kth Smallest Element in a Sorted Matrix
    public static int kthSmallestInMatrix(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for (int i = 0; i < Math.min(matrix.length, k); i++) {
            minHeap.offer(new int[]{i, 0});
        }

        int count = 0;
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            count++;
            if (count == k) return matrix[top[0]][top[1]];
            if (top[1] + 1 < matrix[0].length) {
                minHeap.offer(new int[]{top[0], top[1] + 1});
            }
        }
        throw new IllegalArgumentException("k out of range");
    }

    // LeetCode 621: Task Scheduler
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int value : freq) {
            if (value > 0) maxHeap.offer(value);
        }

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll() - 1);
                }
            }
            for (int value : temp) {
                if (value > 0) maxHeap.offer(value);
            }
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
    }

    // LeetCode 23: Merge k Sorted Lists
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) minHeap.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!minHeap.isEmpty()) {
            ListNode current = minHeap.poll();
            tail.next = current;
            tail = tail.next;
            if (current.next != null) minHeap.offer(current.next);
        }
        return dummy.next;
    }

    // LeetCode 295: Find Median from Data Stream
    static class MedianFinder {
        private final PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        private final PriorityQueue<Integer> upper = new PriorityQueue<>();

        public void addNum(int num) {
            if (lower.isEmpty() || num <= lower.peek()) {
                lower.offer(num);
            } else {
                upper.offer(num);
            }
            if (lower.size() > upper.size() + 1) {
                upper.offer(lower.poll());
            } else if (upper.size() > lower.size()) {
                lower.offer(upper.poll());
            }
        }

        public double findMedian() {
            if (lower.size() == upper.size()) {
                return (lower.peek() + upper.peek()) / 2.0;
            }
            return lower.peek();
        }
    }

    public static void main(String[] args) {
        int[] values = {4, 10, 3, 5, 1};
        buildMinHeap(values);
        System.out.println("Heapified: " + java.util.Arrays.toString(values));

        int[] sorted = {5, 2, 9, 1, 7};
        heapSort(sorted);
        System.out.println("Sorted: " + java.util.Arrays.toString(sorted));

        System.out.println("Top 3 largest: " + topKLargest(new int[]{4, 5, 8, 2}, 3));
        System.out.println("Kth largest: " + kthLargest(new int[]{4, 5, 8, 2}, 2));
    }
}
