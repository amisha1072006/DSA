class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, r = numbers.length - 1;
	
	while (numbers[i] + numbers[r] != target) {
		if (numbers[i] + numbers[r] < target) i++;
		else r--;
	}

	return new int[] {i+1, r+1};
    }
}