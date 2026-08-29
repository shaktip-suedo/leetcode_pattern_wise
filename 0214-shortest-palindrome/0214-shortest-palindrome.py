class Solution:
    def shortestPalindrome(self, s: str) -> str:
        if not s:
            return ""
            
        combined = s + "#" + s[::-1]
        table = [0] * len(combined) 
        lookup_index = 0


        for i in range(1, len(combined)):
            while lookup_index > 0 and combined[i] != combined[lookup_index]:
                lookup_index = table[lookup_index - 1]
                
            if combined[i] == combined[lookup_index]:
                lookup_index += 1
                
            table[i] = lookup_index


        longest_palindromic_prefix_len = table[-1]
        remaining_suffix = s[longest_palindromic_prefix_len:]
        return remaining_suffix[::-1] + s