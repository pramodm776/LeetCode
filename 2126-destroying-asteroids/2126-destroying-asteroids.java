class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        long ass= mass;

        for(int i=0; i<asteroids.length; i++){

            if(ass>=asteroids[i]){
                ass+=asteroids[i];
            }
            else{
                return false;
            }
        }
        return true;
        
    }
}