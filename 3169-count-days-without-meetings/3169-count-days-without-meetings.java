class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(o ->o[0]));

        int d = 0;

        int start = meetings[0][0];
        int end = meetings[0][1];

        for(int i=1; i<meetings.length; i++){
            if(meetings[i][0]<=end+1){
                end = Math.max(end, meetings[i][1]);
            }
            else{
                d+= end - start +1;

                start = meetings[i][0];
                end = meetings[i][1];
            }

           
        }

        d+= end - start +1;

        return days -d;
        
    }
}