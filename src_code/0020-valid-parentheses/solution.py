class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # Create a stack to store open brackets
        stack = []
        
        # Define a mapping of open and close brackets
        bracket_mapping = {')': '(', '}': '{', ']': '['}
        
        # Iterate through the characters in the input string
        for char in s:
            # If the character is a closing bracket
            if char in bracket_mapping:
                # Pop the top element from the stack (or use '#' if the stack is empty)
                top_element = stack.pop() if stack else '#'
                
                # If the top element does not match the corresponding open bracket
                if top_element != bracket_mapping[char]:
                    return False
            else:
                # If the character is an open bracket, push it onto the stack
                stack.append(char)
        
        # After processing the entire string, the stack should be empty if the string is valid
        return not stack
        
