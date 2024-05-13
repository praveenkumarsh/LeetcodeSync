class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        path = []

        def partitionHelper(index: int):
            if index == len(s):
                # print("path : ", path)
                # print("res : ", res)
                res.append(path[:])
                return
            for i in range(index, len(s)):
                # print("====Current POI : ", s[index:i + 1])
                if isPalindrome(s, index, i):
                    # print("Path before Append : ", path)
                    path.append(s[index:i + 1])
                    # print("Path after Append : ", path)
                    partitionHelper(i + 1)
                    # print("Path before Pop : ", path)
                    path.pop()
                    # print("Path after Pop : ", path)

        def isPalindrome(s: str, start: int, end: int) -> bool:
            while start <= end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
            return True

        partitionHelper(0)
        return res
        
