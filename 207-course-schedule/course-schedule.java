class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[]=new int[numCourses];

        ArrayList<ArrayList<Integer>> prereq=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            prereq.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int pre=prerequisites[i][1];
            int course=prerequisites[i][0];
            prereq.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }


        int index=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            index++;

            for(int course: prereq.get(curr)){
                indegree[course]--;
                if(indegree[course]==0){
                    queue.add(course);
                }
            }
        }

        return index==numCourses;
    }
}