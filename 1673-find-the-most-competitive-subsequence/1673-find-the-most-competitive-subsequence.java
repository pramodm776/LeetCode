class Solution {
    public int[] mostCompetitive(int[] nums, int k) {

        Stack<Integer> s = new Stack<>();

        for(int i =0;i<nums.length;i++){
            while(!s.isEmpty() && s.peek()>nums[i] && s.size() + (nums.length - i - 1) >= k){
                s.pop();
            }
            s.push(nums[i]);
        }


        while(s.size()>k){
            s.pop();
        }

        int ans[] = new int[k];

        for(int i=k-1; i>=0; i--){
            ans[i] = s.pop();
        }



        return ans;

        
    }
}