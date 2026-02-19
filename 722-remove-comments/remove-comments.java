class Solution {
            boolean isCommentBegan=false;
    String lineBeforeComm="";
    public List<String> removeComments(String[] source) {
        List<String> res=new ArrayList();
        for(String line:source){
            line=helper(line);
            if(line!=null){
                res.add(line);
            }
        }
        return res;
    }
    
    private String helper(String line){
        if(line.length()==0){
            return null;
        }
        if(isCommentBegan){
            int index=line.indexOf("*/");
            if(index<0){
                return null;
            }
            isCommentBegan=false;
            StringBuilder sb=new StringBuilder();
            sb.append(lineBeforeComm);
            sb.append(line.substring(index+2,line.length()));
            line=sb.toString();
        }else if(!isCommentBegan){
            int index1=line.indexOf("//");
            int index2=line.indexOf("/*");
            if(index1>=0 && (index2<0 || index1<index2) ){
                line=line.substring(0,index1);
            }else{
                if(index2<0){
                    return line;
                }
                isCommentBegan=true;
                lineBeforeComm=line.substring(0,index2);
                line=line.substring(index2+2,line.length());
            }
        }
        return helper(line);
    
    }
}