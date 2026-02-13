class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
               final Queue<Integer> queue = new LinkedList<>();
        final boolean[] explored = new boolean[friends.length];

        queue.offer(id);

        explored[id] = true;

        while(!queue.isEmpty() && level > 0) {
            final int size = queue.size();

            for(int i = 0; i < size; ++i) {
                int idx = queue.poll();

                for(final int friend : friends[idx]) {
                    if(!explored[friend])
                        queue.offer(friend);

                    explored[friend] = true;
                }
            }

            level--;
        }

        final Map<String, Integer> count = new HashMap<>();

        while(!queue.isEmpty()) {
            final int idx = queue.poll();

            for(final String video : watchedVideos.get(idx))
                count.put(video, count.getOrDefault(video, 0) + 1);
        }

        final List<String> watched = new ArrayList<>();

        for(final String video : count.keySet())
            watched.add(video);

        Collections.sort(watched, (a, b) -> count.get(a) == count.get(b) ? a.compareTo(b) : count.get(a) - count.get(b));

        return watched;
 
    }
}