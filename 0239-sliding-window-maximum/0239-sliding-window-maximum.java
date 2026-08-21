class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> d = new ArrayDeque<>();

        int ans[]  = new int[n-k+1];

        int j = 0;

        for(int i =0; i<n; i++){
            while(!d.isEmpty()  && d.peekFirst()<=i-k){
                d.pollFirst();
            }

            while(!d.isEmpty() && nums[d.peekLast()] < nums[i]){
                d.pollLast();
            }

            d.addLast(i);


            if(i>=k-1){
                ans[j++] = nums[d.peekFirst()];
            }



        }



        return ans;

        


        
    }
}