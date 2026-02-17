class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
               List<List<String>> solution = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String path: paths){
            String[] pathSplit = path.split(" ");

            String dir = pathSplit[0];

            for(int i = 1; i < pathSplit.length; i++){
                String file = pathSplit[i];

                int startIndex = file.indexOf('(');
                int endIndex = file.indexOf(')');

                String content = file.substring(startIndex, endIndex);

                if(map.containsKey(content)){
                    List<String> list = map.get(content);
                    list.add(dir + "/" + file.substring(0, startIndex));
                }else{
                    List<String> list = new ArrayList<>();
                    list.add(dir + "/" + file.substring(0, startIndex));
                    map.put(content, list);
                }
            }
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            List<String> list = entry.getValue();
            if(list.size() == 1)continue;
            solution.add(list);
        }

        return solution;
 
    }
}