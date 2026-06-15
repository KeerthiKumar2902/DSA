class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map=new HashMap<>();

        for(String str:strs){
            char a[]=str.toCharArray();

            Arrays.sort(a);
            String s=new String(a);

            map.putIfAbsent(s,new ArrayList<>());
            map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }
}