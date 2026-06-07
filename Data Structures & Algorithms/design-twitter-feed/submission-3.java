class Twitter {
    HashMap<Integer, List<Tweet>> tweetMapping;
    HashMap<Integer, Set<Integer>> followingMapping;
    long time;
    private final Comparator<Tweet> tweetComparator;

    public Twitter() {
        tweetMapping = new HashMap();
        time = 0l;
        followingMapping = new HashMap();
        tweetComparator = (tweet1, tweet2) -> {
            if (tweet1.time > tweet2.time) {
                return 1;
            } else if (tweet2.time == tweet1.time) {
                return 0;
            } else {
                return -1;
            }
        };
    }

    public void postTweet(int userId, int tweetId) { // O(1)
        // Add tweetId to the userId
        List<Tweet> list = tweetMapping.getOrDefault(userId, new ArrayList());
        list.add(new Tweet(time, tweetId));
        tweetMapping.put(userId, list);
        time++;
        // System.out.println("Tweets : " + tweetMapping);
        // System.out.println("followingMapping : " + followingMapping);
    }

    public List<Integer> getNewsFeed(int userId) { // O(nlogn)

        PriorityQueue<Tweet> minHeap = new PriorityQueue(tweetComparator);

        List<Tweet> userTweets = tweetMapping.getOrDefault(userId, new ArrayList());

        for (Tweet tweet : userTweets) {
            minHeap.add(tweet);
            if (minHeap.size() > 10) {
                minHeap.remove();
            }
        }

        Set<Integer> followers = followingMapping.getOrDefault(userId, new HashSet());
        for (Integer tweetUserId : followers) {
            if (tweetUserId == userId) {
                continue;
            }
            List<Tweet> followersTweet = tweetMapping.getOrDefault(tweetUserId, new ArrayList());
            for (Tweet tweet : followersTweet) {
                minHeap.add(tweet);
                if (minHeap.size() > 10) {
                    minHeap.remove();
                }
            }
        }
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < minHeap.size(); i++) {
            ans.add(null);
        }
        // System.out.println("Sorted tweets : " + minHeap + " | ans : " + ans);
        int pos = minHeap.size() - 1;
        while (pos >= 0) {
            ans.set(pos, minHeap.remove().tweetId);
            pos--;
        }
        time++;
        // System.out.println("ans : "+ ans);
        return ans;
    }

    public void follow(int followerId, int followeeId) { // O(1)
        // Add followerId to the followeeId
        Set<Integer> followers = followingMapping.getOrDefault(followerId, new HashSet());
        followers.add(followeeId);
        followingMapping.put(followerId, followers);
        time++;
        // System.out.println("followingMapping : " + followingMapping);
    }

    public void unfollow(int followerId, int followeeId) { // O(1)
        // remove from the list
        Set<Integer> followers = followingMapping.getOrDefault(followerId, new HashSet());
        if (followers.contains(followeeId)) {
            followers.remove(followeeId);
        }
        followingMapping.put(followerId, followers);
        time++;
        // System.out.println("followingMapping : " + followingMapping);
    }
}

class Tweet {
    long time;
    int tweetId;
    Tweet(long time, int tweetId) {
        this.time = time;
        this.tweetId = tweetId;
    }
    public String toString() {
        return "(" + time + ":" + tweetId + ")";
    }
}
