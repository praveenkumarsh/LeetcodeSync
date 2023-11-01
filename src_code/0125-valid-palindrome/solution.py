class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s1 = ''
        for c in s.lower():
            if c.isalnum():
                s1 += c

        return True if s1==s1[::-1] else False
        
