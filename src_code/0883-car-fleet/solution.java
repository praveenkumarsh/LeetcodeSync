class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Combine position and speed arrays into a list of tuples and sort based on position
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double lastFleetTime = -1;

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            // If the time taken by the current car is greater than the last fleet time,
            // it forms a new fleet
            if (time > lastFleetTime) {
                fleets++;
                lastFleetTime = time;
            }
        }

        return fleets;
    }

    // public static void main(String[] args) {
    //     CarFleet solution = new CarFleet();
    //     int target = 12;
    //     int[] position = {10, 8, 0, 5, 3};
    //     int[] speed = {2, 4, 1, 1, 3};

    //     int result = solution.carFleet(target, position, speed);
    //     System.out.println("Number of car fleets: " + result);
    // }
}
