class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(int i=0;i<nums1.length;i++){
            int a=nums1[i]+nums2[0];
            minHeap.add(new int[]{ a,i,0 });
        }

        List<List<Integer>> result=new ArrayList<>();

        while(k>0 && !minHeap.isEmpty()){
            int temp[]= minHeap.poll();
            int i=temp[1];
            int j=temp[2];
            result.add(new ArrayList<>(List.of(nums1[i],nums2[j])));

            if((j+1)<nums2.length){
                int sum=nums1[i]+nums2[j+1];

                minHeap.add(new int[]{sum,i,j+1});
            }

            k--;
        }

        return result;
    }
}