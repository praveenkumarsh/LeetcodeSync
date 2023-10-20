class Solution {
	public int totalFruit(int[] fruits) {
		int maxFruits = 0;
		int lastFruit = -1;
		int secondLastFruit = -1;
		int lastFruitCount = 0;
		int currentMax = 0;

		for (int fruit : fruits) {
			if (fruit == lastFruit || fruit == secondLastFruit) {
				currentMax++; // If the current fruit is the same as the last or second last fruit, increment
								// the current maximum.
			} else {
				currentMax = lastFruitCount + 1; // If the current fruit is different, reset the current maximum.
			}

			if (fruit == lastFruit) {
				lastFruitCount++; // If it's the same as the last fruit, increment the count of the last fruit.
			} else {
				lastFruitCount = 1; // If it's a new fruit, reset the count and update the last and second last
									// fruits.
				secondLastFruit = lastFruit;
				lastFruit = fruit;
			}

			maxFruits = Math.max(maxFruits, currentMax); // Update the maximum number of fruits seen so far.
		}

		return maxFruits;
	}
}
