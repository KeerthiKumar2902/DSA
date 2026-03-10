class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));

        for(int num:map.keySet()){
            minHeap.add(num);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int a=minHeap.size();
        int result[]=new int[a];
        for(int i=0;i<a;i++){
            result[i]=minHeap.poll();
        }

        return result;
    }
}