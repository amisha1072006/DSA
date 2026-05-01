class Solution {
      public class Node{
        int val;
        int rank;
        Node parent;
    }
    HashMap<Integer,Node> map = new HashMap<>();
    int cnt;
    public void createSet(int v){
        Node nn = new Node();
        nn.val = v;
        nn.rank = 0;
        nn.parent = nn;
        map.put(v,nn);
    }
    public int find(int v){
        Node nn = map.get(v);
        return find(nn).val;
    }
    public Node find(Node nn){
        if(nn.parent == nn){
            return nn;
        }
        Node rn = find(nn.parent);
        nn.parent = rn;
        return rn;
    }
    public boolean union(int v1, int v2){
        Node nn1 = map.get(v1);
        Node nn2 = map.get(v2);
        Node rn1 = find(nn1);
        Node rn2 = find(nn2);
        if(rn1 != nn1){
            return false;
        }
        if(rn1 == rn2){
            return false;
        }
        rn1.parent = rn2;
        cnt--;
        return true;
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        for(int i = 0; i<n; i++){
            createSet(i);
        }
        cnt = n;
        for(int i = 0; i<n; i++){
            int l = leftChild[i];
            int r = rightChild[i];
            if(l != -1 && union(l,i) == false){
                return false;
            }
            if(r != -1 && union(r,i) == false){
                return false;
            }
        }
        return cnt == 1;  
    }
}