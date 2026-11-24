
class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];
                gcd = GCD(gcd, nums[j]);
                lcm = LCM(lcm, nums[j]);

                if (product == gcd * lcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

                if (product > 25200) {
                    break;
                }
            }
        }

        return maxLen;
    }

    public long GCD(long a, long b) {
        if (b == 0) return a;

        return GCD(b, a % b);
    }

    public long LCM(long a, long b) {
        return (a / GCD(a, b)) * b;
    }
}
