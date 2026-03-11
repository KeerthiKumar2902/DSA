class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];

        for(char task:tasks){
            freq[task-'A']++;
        }


        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int fre:freq){
            if(fre !=0){
                maxHeap.add(fre);
            }
        }

        Queue<int[]> waitingRoom=new LinkedList<>();
        int time=0;

        while(!maxHeap.isEmpty() || !waitingRoom.isEmpty()){
            time++;

            if(!maxHeap.isEmpty()){
                int currFreq=maxHeap.poll();
                currFreq--;

                if(currFreq>0){
                    waitingRoom.add(new int[]{currFreq, time+n});
                }
            }

            if(!waitingRoom.isEmpty() && waitingRoom.peek()[1]==time){
                int taskReturn[] = waitingRoom.poll();
                maxHeap.add(taskReturn[0]);
            }
        }

        return time;


    }
}