class Solution {
       public int numSpecialEquivGroups(String[] A) {
	Set<String> group = new HashSet<String>();
	for(int i = 0; i < A.length; i++) 
		group.add(getSignature(A[i]));
	return group.size();
}

public String getSignature(String s) {
	int odd[] = new int[26];
	int even[] = new int[26];
	for(int i = 0; i < s.length(); i += 2) 
		even[s.charAt(i) - 'a']++;
	for(int i = 1; i < s.length(); i += 2)
		odd[s.charAt(i) - 'a']++;
	StringBuilder sb = new StringBuilder("");
	for(int i = 0; i < 26; i++)
		sb.append(odd[i]);
	for(int i = 0; i < 26; i++)
		sb.append(even[i]);
	return sb.toString(); 
    }
}