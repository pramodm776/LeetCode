class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder s = new StringBuilder();

        for(char ch : num.toCharArray()){

            while(k>0 && s.length()>0 && s.charAt(s.length()-1)>ch){
                s.deleteCharAt(s.length()-1);
                k--;
            }

            s.append(ch);

        }

        while(k>0){
            s.deleteCharAt(s.length()-1);
            k--;
        }

        int i=0;
        while(i<s.length() && s.charAt(i) == '0'){
            i++;
        }
        

        String ans = s.substring(i);

        if(ans.length()>0){
            return ans;
        }

        return "0";
        
    }
}