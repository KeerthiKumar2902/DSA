class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> current= new ArrayList<>();
        helper(result,current,0,s);
        return result;
    }

    public static void helper(List<List<String>> result, List<String> current,int ind,String s){
        
        if(ind==s.length()){
            result.add(new ArrayList<String>(current));
            return;
        }

        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                current.add(s.substring(ind,i+1));
                helper(result,current,i+1,s);
                current.remove(current.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }

        return true;
    }
}