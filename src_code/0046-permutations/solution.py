class Solution:


    ans = []
    ds = []


    def recurPermute(self, nums: List[int], freq: List[int]):
        if len(self.ds) == len(nums):
            self.ans.append(self.ds.copy())
            return
        for i in range(len(nums)):
            if not freq[i]:
                self.ds.append(nums[i])
                freq[i] = 1
                self.recurPermute(nums, freq)
                freq[i] = 0
                self.ds.pop()


    def permute(self, nums: List[int]) -> List[List[int]]:
        self.ans = []
        self.ds = []
        freq = [0] * len(nums)
        self.recurPermute(nums, freq)
        return self.ans
