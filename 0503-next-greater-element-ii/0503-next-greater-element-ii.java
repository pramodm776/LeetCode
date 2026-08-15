class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int arr[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            s.push(nums[i]);
        }

        for(int i=nums.length-1; i>=0; i--){
            while(!s.isEmpty() && nums[i]>=s.peek()){
                s.pop();
            }

            if(s.isEmpty()){

               arr[i] = -1;

            }
            else{
               arr[i] = s.peek();
            }

            s.push(nums[i]);
        }

        return arr;
        
    }
}