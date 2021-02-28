class Solution {
    public int numSquares(int n) {
        if (isPerfectSquare(n))
            return 1;

        /////// checking for possibility of 4 ---> 4^a(8b+7)///////
        while (n % 4 == 0) {
            n = n / 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        ///////////////////////////////////////////////////////////
        
        ////// possibility of 2 ---> where 2 numbers can be perfect squares///////
        for (int i = 1; i * i <= n; i++) {
            int otherHalf = n - (i * i);

            if (isPerfectSquare(otherHalf))
                return 2;
        }
        /////////////////////////////////////////////////////////////////////////
        
        return 3;
        // Since, our solution lies between 1-4, for anything else return 3
    }
    
    private boolean isPerfectSquare(int n) {
        double sq = Math.sqrt(n);
        return Math.ceil(sq) == Math.floor(sq);
    }
}
