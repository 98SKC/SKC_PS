class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String inputId = id_pw[0];
        String inputPw = id_pw[1];
        
        for (String[] user : db) {
            String dbId = user[0];
            String dbPw = user[1];
            
        
            if (inputId.equals(dbId)) {
           
                if (inputPw.equals(dbPw)) {
                    return "login";
                } else {
                    return "wrong pw";
                }
            }
        }
        
     
        return "fail";
    }
}