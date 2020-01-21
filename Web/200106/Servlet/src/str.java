class Solution {
    public int solution(String s) {
        int answer = 0;
        int count =1;
        String result="";
        //1개씩
        for(int i=0; i<s.length()-1;i++){
            
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }else if(count!=1){
                result += count;
                result += s.charAt(i);
            }else{
                result += s.charAt(i);
            }
        }
   
        answer = result.length();
        System.out.println(result);
        return answer;
               
    }
    
    public static void main(String[] args) {
        this.solution("aabcd");
    }
    
}