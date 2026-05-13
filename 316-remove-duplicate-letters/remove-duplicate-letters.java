class Solution {
 public static String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];

        // Store last occurrence
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Skip if already in stack
            if (visited[ch - 'a']) {
                continue;
            }

            // Maintain lexicographical order
            while (!stack.isEmpty() &&
                   stack.peek() > ch &&
                   lastIndex[stack.peek() - 'a'] > i) {

                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);

            visited[ch - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }

}