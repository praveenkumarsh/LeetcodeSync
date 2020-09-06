class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0){
            res.add("");
        }else{
            for(int i=0;i<n;i++){
                List<String> leftsection = generateParenthesis(i);
                List<String> rightsection = generateParenthesis(n-1-i);
                for(String left : leftsection){
                    for(String right : rightsection){
                        res.add("("+left+")"+right);
                    }
                }
            }
        }
        return res;
    }
}
