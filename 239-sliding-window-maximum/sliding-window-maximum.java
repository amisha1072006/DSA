class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        class Pair { // for storing value and Index
        int val;
        int ind;

        Pair(int value, int index) {
            this.val = value;
            this.ind = index;
        }
    }
            int n = nums.length;
        int arr[] = new int[n - k + 1]; // for storing ans
        int i = 0;
        int ind = 0;
        Deque<Pair> dq = new ArrayDeque<>();

        while (i < k) { // inserting first k elements
            while (dq.size() > 0 && dq.peekLast().val < nums[i]) {
                dq.removeLast();// removing last or recent element if it is smaller than current element
            }
            dq.addLast(new Pair(nums[i], i)); //adding in deque
            i++;
        }
        arr[ind++] = dq.peekFirst().val; // taking firstly added or head element

        while (i < n) {
            while (dq.size() > 0 && dq.peekLast().val < nums[i]) {
                dq.removeLast();// removing last or recent element if it is smaller than current element
            }

            while (dq.size() > 0 && i - dq.peekFirst().ind >= k) {
                dq.removeFirst(); // removing first element or head of deque if it is outside or exceed the k size window
            }

            dq.addLast(new Pair(nums[i], i));
            arr[ind++] = dq.peekFirst().val; // storing first or head element
            i++;
        }

        return arr;

    }
}