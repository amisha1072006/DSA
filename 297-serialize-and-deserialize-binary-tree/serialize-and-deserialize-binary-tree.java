/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
       // serialize
    public String serialize(TreeNode r) {
        StringBuilder s = new StringBuilder();
        f(r, s);
        return s.toString();
    }

    void f(TreeNode n, StringBuilder s) {
        if (n == null) {
            s.append("n,");
            return;
        }
        s.append(n.val).append(",");
        f(n.left, s);
        f(n.right, s);
    }

    // deserialize
    public TreeNode deserialize(String d) {
        String[] a = d.split(",");
        int[] i = new int[1];
        return g(a, i);
    }

    TreeNode g(String[] a, int[] i) {
        if (a[i[0]].equals("n")) {
            i[0]++;
            return null;
        }

        TreeNode t = new TreeNode(Integer.parseInt(a[i[0]++]));
        t.left = g(a, i);
        t.right = g(a, i);

        return t;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));