import java.util.*;
class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            int take = dp.getOrDefault(num - 1, 0) + 1;
            int increase = dp.getOrDefault(num, 0) + 1;

            dp.put(num + 1, increase);
            dp.put(num, take);

            ans = Math.max(ans,
                    Math.max(take, increase));
        }

        return ans;
    }
}
