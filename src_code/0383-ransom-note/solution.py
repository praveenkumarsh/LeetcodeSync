class Solution(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        for i in set(ransomNote):
            if ransomNote.count(i) <= magazine.count(i):
                pass
            else:
                return False
        return True
        # st1, st2 = Counter(ransomNote), Counter(magazine)
        # return st1 & st2 == st1
        # dictionary = {}

        # # Iterate through the magazine and count characters
        # for char in magazine:
        #     if char not in dictionary:
        #         dictionary[char] = 1
        #     else:
        #         dictionary[char] += 1

        # # Iterate through the ransom note and check character counts
        # for char in ransomNote:
        #     if char in dictionary and dictionary[char] > 0:
        #         dictionary[char] -= 1
        #     else:
        #         return False
        
        # return True
        
