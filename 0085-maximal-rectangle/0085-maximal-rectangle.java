class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int h[] = new int[col];

        int max = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]=='1'){
                    h[j]++;

                }
                else{
                    h[j] =0;
                }
            }
        

            Stack<Integer> s = new Stack<>();

            int nsr[] = new int[col];
            int nsl[] = new int[col];

            for(int x=col-1; x>=0; x--){
                while(!s.isEmpty() && h[s.peek()]>=h[x]){
                    s.pop();
                }
                if(s.isEmpty()){
                    nsr[x] = col;
                }
                else{
                    nsr[x] = s.peek();
                }

                s.push(x);
            }

            s.clear();


            for(int c=0; c<col; c++){
                while(!s.isEmpty() && h[s.peek()]>=h[c]){
                    s.pop();
                }
                if(s.isEmpty()){
                    nsl[c] = -1;
                }
                else{
                    nsl[c] = s.peek();
                }

                s.push(c);
            }



            for(int v=0; v<h.length; v++){
                int width = nsr[v] - nsl[v] -1;
                
                int area = h[v]*width;

                max = Math.max(area,max);
            }


        }
        return max;


        
    }
}