class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
                HashMap<String,HashMap<String,Double>> map = new HashMap<>();
        //iterating the equations array to store the values in the hashmap
        for(int i = 0 ; i < values.length ; i++){
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            double result = values[i];
            //checking if the numerator is present in the hashmap before inserting
            if(!map.containsKey(numerator)){
                map.put(numerator,new HashMap<String,Double>());
            }
            //checking if the numerator is present in the hashmap before inserting
            if(!map.containsKey(denominator)){
                map.put(denominator,new HashMap<String,Double>());
            }
            map.get(numerator).put(denominator,result);
            map.get(denominator).put(numerator,1/result);
        }
        //now the hashmap is created
        //creating a resultant array 
        double[] res = new double[queries.size()];
        //iterating over queries
        for(int i = 0 ; i < queries.size() ; i++){
            String numer = queries.get(i).get(0);
            String denom = queries.get(i).get(1);
            if(!map.containsKey(numer) || !map.containsKey(denom)){
                res[i] = -1;
            }
            else if(numer.equals(denom)){
                res[i] = 1;
            }else{
                //creating hashset for visited array to call dfs
                HashSet<String> set = new HashSet<>();
                res[i] = dfs(numer,denom,map,1,set);
            }
        }
        return res;
    }
    public double dfs(String src,String target,HashMap<String,HashMap<String,Double>> map,double product,HashSet<String> visited){
        double res = -1;
        visited.add(src);
        //iterating into the hashMap
        if(map.get(src).containsKey(target)){
            res = product * map.get(src).get(target);
        }else{
            for(String neighbour : map.get(src).keySet()){
                if(!visited.contains(neighbour)){
                    res = dfs(neighbour,target,map,product*map.get(src).get(neighbour),visited);
                    if(res != -1){
                        break;
                    }
                }
            }
        }
        visited.remove(src);
        return res;
    
    }
}