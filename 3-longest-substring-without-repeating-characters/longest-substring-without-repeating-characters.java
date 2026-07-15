class Solution {
    public int lengthOfLongestSubstring(String s) {
      HashSet<Character> set = new HashSet<>();

    int maxLen = 0;
    int l = 0;
      for(int r = 0; r < s.length();r++){
        char ch = s.charAt(r);
        while(set.contains(ch)){
            set.remove(s.charAt(l));
            l++;
        }
        set.add(ch);

        maxLen = Math.max(maxLen, r - l +1);
      }
      return maxLen;
    }
    }

