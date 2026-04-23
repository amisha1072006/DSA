class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int n = position.length;
		int[] dist = new int[n];
		double[] timeAr = new double[n];
		HashMap<Integer, Double> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			dist[i] = target - position[i]; //calculate distance left for each car
			timeAr[i] = (double) dist[i] / (double) speed[i]; //calculate original time needed for each car
			map.put(dist[i], timeAr[i]); //map distance left with original time needed
		}
		
		Arrays.sort(dist); //the cars with larger distance left & smaller time needed will chase up the car before
		List<Double> rTimeL = new ArrayList<Double>(); //store time used for each fleet in ascending order
		for (int i = 0; i < n; i++) {
			Double time = map.get(dist[i]);
			int m = rTimeL.size();
			if (m == 0 || time > rTimeL.get(m - 1)) { 
				rTimeL.add(time); //new fleet is created
			}
		}
		return rTimeL.size(); 
    }
}