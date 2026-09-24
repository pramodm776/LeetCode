class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum =0;

        for(int i=0; i<k; i++){
            sum+= cardPoints[i];

        }
        int maxscore = sum;;

        for(int i = 0; i<k; i++){
            
            sum-= cardPoints[k-1-i];
            sum+= cardPoints[n-1-i];

            maxscore = Math.max(maxscore, sum);

        }

        return maxscore;
    }
}