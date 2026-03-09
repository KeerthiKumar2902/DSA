import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        // A nice string must have at least an uppercase and lowercase letter
        if (s.length() < 2) {
            return "";
        }

        // Add all characters to a set for O(1) lookups
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        // Look for the first "bad" character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Check if BOTH uppercase and lowercase versions exist in the set
            if (charSet.contains(Character.toUpperCase(c)) && 
                charSet.contains(Character.toLowerCase(c))) {
                continue; // This character is fine, keep going
            }

            // We found a character missing its pair. 
            // The longest nice substring must be to its left or right.
            String leftSubstring = longestNiceSubstring(s.substring(0, i));
            String rightSubstring = longestNiceSubstring(s.substring(i + 1));

            // Return the longer of the two valid nice substrings
            if (leftSubstring.length() >= rightSubstring.length()) {
                return leftSubstring;
            } else {
                return rightSubstring;
            }
        }

        // If we made it through the whole loop, the entire string is nice!
        return s;
    }
}