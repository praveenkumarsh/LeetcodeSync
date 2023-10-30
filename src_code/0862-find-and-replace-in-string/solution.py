class Solution(object):
    def findReplaceString(self, S, indexes, sources, targets):
        """
        :type s: str
        :type indices: List[int]
        :type sources: List[str]
        :type targets: List[str]
        :rtype: str
        """
        table = {}
        for i in range(len(indexes)):
            # If a match is found in the original string, record it
            if S.startswith(sources[i], indexes[i]):
                table[indexes[i]] = i
        sb = []
        i = 0
        while i < len(S):
            if i in table:
                # If a replacement was recorded before
                sb.append(targets[table[i]])
                i += len(sources[table[i]])
            else:
                # If no replacement happened at this index
                sb.append(S[i])
                i += 1
        return ''.join(sb)

            
