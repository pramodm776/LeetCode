class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;

        Stack<Integer> s = new Stack<>();
        int arr[] = new int[n];

        for(int i=n-1; i>=0;i--){
            

            while(!s.isEmpty() && heights[i]>s.peek()){
                s.pop();
                arr[i]++;
            }

            if(!s.isEmpty()){
                arr[i]++;
            }

            s.push(heights[i]);



        }

        return arr;


        
        
    }
}