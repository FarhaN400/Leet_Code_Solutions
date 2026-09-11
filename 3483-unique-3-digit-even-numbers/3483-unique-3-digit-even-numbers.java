class Solution {

    public int totalNumbers(int[] digits) {

        Arrays.sort(digits);

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {

            // First digit cannot be 0
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < digits.length; j++) {

                for (int k = 0; k < digits.length; k++) {

                    // Same index cannot be used twice
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    // Last digit must be even
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    set.add(num);
                }
            }
        }

        return set.size();
    }
}