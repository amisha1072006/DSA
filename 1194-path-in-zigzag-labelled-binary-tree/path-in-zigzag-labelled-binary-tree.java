class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        if(label == 1){
            res.add(1);
            return res;
        }
        int level =(int)(Math.log(label)/Math.log(2));
        
        int node = 1, position = 0;
        int levelStart = level%2 == 1? (int)Math.pow(2, level+1)-1: (int)Math.pow(2, level);
        int levelEnd = level%2 != 1? (int)Math.pow(2, level+1)-1: (int)Math.pow(2, level);
        int levelMultant = level%2 == 1? -1 : 1;

        res.add(node);

        for(int i=1; i<level; i++){

            int multant = i%2 == 1? -1 : 1;
            int start = i%2 == 1? (int)Math.pow(2, i+1)-1: (int)Math.pow(2, i);

            int leftPosition = 2*position;
            int left = start +  multant*leftPosition;
            int rightPosition = 2*position + 1;
            int right = start + multant*rightPosition;

            int half = (Math.abs(levelStart - levelEnd) + 1)/2;
            int min = Math.min(levelStart, levelStart + levelMultant*half - levelMultant);
            int max = Math.max(levelStart, levelStart + levelMultant*half - levelMultant);
            if( min <= label && max >= label ){
                    // System.out.println("left");
                res.add(left);
                node = left;
                position = leftPosition;
                levelEnd = levelStart + levelMultant*half - levelMultant;
            }else{
                // System.out.println("right");
                res.add(right);
                node = right;
                position = rightPosition;
                levelStart = levelStart + levelMultant*half;
            }
        }
        res.add(label);
        return res;
    
    }
}