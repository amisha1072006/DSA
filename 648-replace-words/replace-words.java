class Solution {
        public class Node{
        char ch;
        HashMap<Character,Node> child = new HashMap<>();
        String isTerminal;
    }
    Node root;
    public void insert(String word){
        Node temp = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(temp.child.containsKey(ch)){
                temp = temp.child.get(ch);
            }
            else{
                Node nn = new Node();
                nn.ch = ch;
                temp.child.put(ch,nn);
                temp = nn;
            }
        }
        temp.isTerminal = word;
    }
    public String startWith(String word){
        Node temp = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!temp.child.containsKey(ch)){
                return word;
            }
            temp = temp.child.get(ch);
            if (temp.isTerminal != null) return temp.isTerminal;
        }
        
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
       Node nn = new Node();
        nn.ch = '*';
        root = nn;
        String[] str = sentence.split(" ");
        for(String s : dictionary){
            insert(s);
        }
        StringBuilder sb = new StringBuilder();
        for(String s : str){
            // String res = startWith(s) == null ? s : startWith(s);
            String res = startWith(s);
            if(!sb.isEmpty()){
                sb.append(" ");
            }
            sb.append(res);
        }
        return sb.toString();
     
    }
}