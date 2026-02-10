class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq=new PriorityQueue<>();

        for(int i=0;i<points.length;i++){
            int distSq=points[i][0]*points[i][0] + points[i][1]*points[i][1];

            pq.add(new Point(points[i][0],points[i][1],distSq,i));
        }

        int result[][]=new int[k][2];

        for(int i=0;i<k;i++){
            Point p=pq.remove();
            result[i][0]=p.x;
            result[i][1]=p.y;
        }

        return result;

    }

    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int index;

        public Point(int x,int y,int distSq,int index){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.index=index;
        }

        @Override
        public int compareTo(Point p1){
            return this.distSq-p1.distSq;
        }

    }
}