class Solution {
    public String largestNumber(int[] nums) {
        TreeMap<String, ArrayList<Integer>> map = new TreeMap<String, ArrayList<Integer>>(Collections.reverseOrder());
map.put("0", new ArrayList<Integer>());
		map.put("1", new ArrayList<Integer>());
		map.put("2", new ArrayList<Integer>());
		map.put("3", new ArrayList<Integer>());
		map.put("4", new ArrayList<Integer>());
		map.put("5", new ArrayList<Integer>());
		map.put("6", new ArrayList<Integer>());
		map.put("7", new ArrayList<Integer>());
		map.put("8", new ArrayList<Integer>());
		map.put("9", new ArrayList<Integer>());

		for (int i = 0; i <= nums.length - 1; i++) {
			String a1 = String.valueOf(String.valueOf(nums[i]).charAt(0));
			// System.out.print(a1);
			if (map.containsKey(a1)) {
				ArrayList<Integer> list2 = map.get(a1);
				list2.add(nums[i]);
				map.put(a1, list2);

			}
		}
		String ans = "";
		for (Map.Entry<String, ArrayList<Integer>> e : map.entrySet()) {
			// System.out.println(e.getKey()+" "+e.getValue());
			if (e.getValue().size() == 1) {
				List<Integer> list = e.getValue();
				ans += list.get(0);
			} else {
				List<Integer> list = e.getValue();
				Collections.sort(list, (a, b) -> {
				    String ab = String.valueOf(a) + String.valueOf(b);
				    String ba = String.valueOf(b) + String.valueOf(a);
				    return ba.compareTo(ab);
				});
				
				for (int i = 0; i <= list.size() - 1; i++) {
					
					ans += String.valueOf(list.get(i));
				} 
		
			}

		}
ans = ans.replaceAll("^0+", "");
		if(ans.length() == 0)
		{
			ans="0";
		}
return ans;
    }
}