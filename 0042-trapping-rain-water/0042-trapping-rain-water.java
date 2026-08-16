class Solution {
    public int trap(int[] height) {


        Stack<Integer> s = new Stack<>();
        int water = 0;

        for(int i=0; i<height.length; i++){
            while(!s.isEmpty()  && height[i]>height[s.peek()]){

                int bottom = s.pop();
                if(s.isEmpty()){
                    break;
                }


                int left = s.peek();

                int width = i-left-1;

                int top = Math.min(height[i],height[left]) - height[bottom];

                water +=  width*top;
            }

            s.push(i);
        }

        return water;
        
    }
}