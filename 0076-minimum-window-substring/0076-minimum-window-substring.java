class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];
        int[] have = new int[128];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);
            have[ch]++;

            // If this character is needed and we haven't exceeded its required count
            if (need[ch] > 0 && have[ch] <= need[ch]) {
                formed++;
            }

            // Window is valid
            while (formed == t.length()) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                have[leftChar]--;

                // Window becomes invalid
                if (need[leftChar] > 0 && have[leftChar] < need[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}