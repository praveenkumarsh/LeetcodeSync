class Solution {
	public int splitArray(int[] nums, int m) {
		long left = 0;
		long right = 0;

		for (int num : nums) {
			left = Math.max(left, num);
			right += num;
		}

		while (left < right) {
			long mid = left + (right - left) / 2;
			int count = split(nums, mid);

			if (count > m) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return (int) left;
	}

	private int split(int[] nums, long maxSum) {
		int count = 1;
		long sum = 0;

		for (int num : nums) {
			if (sum + num > maxSum) {
				count++;
				sum = num;
			} else {
				sum += num;
			}
		}

		return count;
	}
}
