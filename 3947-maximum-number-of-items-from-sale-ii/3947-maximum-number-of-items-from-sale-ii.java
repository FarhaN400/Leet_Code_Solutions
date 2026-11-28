class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];
        int[] gain = new int[n + 1];

        int minPrice = Integer.MAX_VALUE;

        // Step 1: Frequency and minimum price
        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Step 2: Count free items using multiples
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) continue;

            for (int j = i; j <= n; j += i) {
                gain[i] += freq[j];
            }

            gain[i]--;
        }

        // Step 3: Sort according to price
        Arrays.sort(items, (a, b) ->
            Integer.compare(a[1], b[1]));

        int ans = 0;

        // Step 4: Purchase special copies
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if (price > 2L * minPrice) break;

            int copies = Math.min(
                gain[factor], budget / price
            );

            ans += 2 * copies;
            budget -= copies * price;
        }

        // Step 5: Purchase normal copies
        ans += budget / minPrice;

        return ans;
    }
}