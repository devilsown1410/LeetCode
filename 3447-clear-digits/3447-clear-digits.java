class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch>='a' && ch<='z'){
                st.push(ch);
            }else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}