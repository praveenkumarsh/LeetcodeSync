class Solution {

    static class Worker {
        int quality;
        double wageRatio;
        
        // Constructor to initialize Worker objects.
        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wageRatio = (double) wage / quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        
        // Create Worker objects and store quality-to-wage ratio in each object.
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        
        // Sort workers by their wage-to-quality ratio in ascending order.
        Arrays.sort(workers, (a, b) -> Double.compare(a.wageRatio, b.wageRatio));
        
        double minCost = Double.MAX_VALUE;
        int qualitySum = 0;
        // Use a max-heap to keep track of the highest quality workers.
        PriorityQueue<Integer> maxQualityHeap = new PriorityQueue<>(k, (a, b) -> b - a);
        
        // Iterate through the sorted workers array.
        for (Worker worker : workers) {
            qualitySum += worker.quality;
            maxQualityHeap.offer(worker.quality);
            
            if (maxQualityHeap.size() > k) {
                qualitySum -= maxQualityHeap.poll();
            }
            
            if (maxQualityHeap.size() == k) {
                // Calculate the cost for the current set of workers.
                minCost = Math.min(minCost, qualitySum * worker.wageRatio);
            }
        }
        return minCost;
    }
}
