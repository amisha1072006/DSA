class Twitter {
private static class Tweet{
    int tweetId;
    int timePosted;
    public Tweet(int tId, int time){
        tweetId = tId;
        timePosted = time;
    }
}

static int timeStamp;
int feedMaxNum;
Map<Integer, Set<Integer>> followees;
Map<Integer, List<Tweet>> tweets;

    public Twitter() {
            timeStamp = 0;
    feedMaxNum = 10;
    followees = new HashMap<>();
    tweets = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)) {
        tweets.put(userId, new LinkedList<Tweet>());
        follow(userId, userId);  //follow itself
    }
    tweets.get(userId).add(0, new Tweet(tweetId, timeStamp++)); //add new tweet on the first place

    }
    
    public List<Integer> getNewsFeed(int userId) {
      //min heap that the earliest tweet is on the top
    PriorityQueue<Tweet> feedHeap = new PriorityQueue<>(new Comparator<Tweet>(){
        public int compare(Tweet t1, Tweet t2){
            return t1.timePosted - t2.timePosted;
        }
    });
      Set<Integer> myFollowees = followees.get(userId);
    if(myFollowees != null){
        for(int followeeId : myFollowees){
            List<Tweet> followeeTweets = tweets.get(followeeId);
            if(followeeTweets == null) continue;
            for(Tweet t : followeeTweets){
                if(feedHeap.size() < feedMaxNum) feedHeap.add(t);
                else{
                    if(t.timePosted <= feedHeap.peek().timePosted) break;
                    else{
                        feedHeap.add(t);
                        feedHeap.poll(); //remove the oldest tweet
                    }
                }
            }
        }
    
    }
        List<Integer> myFeed = new LinkedList<>();
    while(!feedHeap.isEmpty()){
        myFeed.add(0, feedHeap.poll().tweetId);
    }
    return myFeed;
    }
    public void follow(int followerId, int followeeId) {
    if(!followees.containsKey(followerId)) followees.put(followerId, new HashSet<Integer>());
    followees.get(followerId).add(followeeId);
}
    
    public void unfollow(int followerId, int followeeId) {
            if(!followees.containsKey(followerId) || followerId == followeeId) return; //cannot unfollow itself
    followees.get(followerId).remove(followeeId);

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */