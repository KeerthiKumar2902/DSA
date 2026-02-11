class Solution {

    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();

        // Edge case: Empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }

        int index=0;
        backTracking(digits,index,new StringBuilder(),result);
        return result;
    }

    public static void backTracking(String digits,int index,StringBuilder curr,List<String> result){
        if(curr.length()==digits.length()){
            result.add(curr.toString());
            return;
        }

        char digitChar=digits.charAt(index);
        String letters=KEYPAD[digitChar-'0'];

        for(char c: letters.toCharArray()){
            curr.append(c);

            backTracking(digits,index+1,curr,result);

            curr.deleteCharAt(curr.length()-1);
        }

    }
}