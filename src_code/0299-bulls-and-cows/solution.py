class Solution(object):
    def getHint(self, secret, guess):
        """
        :type secret: str
        :type guess: str
        :rtype: str
        """
        s, g = Counter(secret), Counter(guess)  # Count the occurrences of each digit in secret and guess
        a = sum(i == j for i, j in zip(secret, guess))  # Count the bulls
        
        # print(s)
        # print(g)
        # print(a)
        # print(s & g)
        # print(sum((s & g).values()))

        # Calculate the cows by finding the intersection of digit counts in secret and guess, subtracting the bulls.
        return '%sA%sB' % (a, sum((s & g).values()) - a)
            
