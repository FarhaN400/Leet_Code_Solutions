
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long ans1 = (long) cost1 * need1 + (long) cost2 * need2;

        long ans2 = (long) costBoth * Math.max(need1, need2);

        int comm = Math.min(need1, need2);

        long ans3 = (long) comm * costBoth
                  + (long) (need1 - comm) * cost1
                  + (long) (need2 - comm) * cost2;

        return Math.min(ans1, Math.min(ans2, ans3));
    }
}
