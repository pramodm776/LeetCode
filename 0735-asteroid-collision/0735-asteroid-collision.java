class Solution {
    public int[] asteroidCollision(int[] asteroids) {


        Stack<Integer> s = new Stack<>();

        for(int astroid : asteroids){
            boolean dis = false;

            while(!s.isEmpty() && s.peek()>0 && astroid<0){

                if(s.peek()< -astroid){
                    s.pop();
                    continue;
                }
                else if(s.peek() == -astroid){
                    s.pop();
                }

                dis = true;
                break;
            
            }

            if(!dis){
                s.push(astroid);
            }
        }

        int arr[] = new int[s.size()];

        for(int i=0; i<s.size(); i++){
            arr[i] = s.get(i);
        }

        return arr;
        
    }
}