import java.math.BigInteger;
class Solution {
        private final int MOD = (int) (1e9 + 7);
    private final List<Integer> PRIMES = List.of(2, 3, 5, 7, 11, 13);

    public int squareFreeSubsets(int[] nums) {
              int[] primeFactors = new int[31];

        for (int i = 2; i <= 30; i++) {
            if (i % 4 == 0 || i % 9 == 0 || i % 25 == 0) {
                continue;
            }

            for (int j = 0; j < PRIMES.size(); j++) {
                if (i % PRIMES.get(j) == 0) {
                    primeFactors[i] += 1 << j;
                }
            }
        }

        int[] freqs = new int[31];
        for (int num : nums) {
            if (num % 4 == 0 || num % 9 == 0 || num % 25 == 0) {
                continue;
            }
            freqs[num]++;
        }

        int mask = 0;
        int[][] cache = new int[31][1<<6];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }

        long oneSubsets = BigInteger.TWO.modPow(BigInteger.valueOf(freqs[1]), BigInteger.valueOf(MOD)).longValue();
        int otherSubsets = (int) (squareFreeSubsets(freqs, primeFactors, 2, mask, cache) % MOD);

        return (int) (otherSubsets * oneSubsets % MOD + oneSubsets - 1) % MOD;
    }

    private long squareFreeSubsets(int[] freqs, int[] primeFactors, int num, int mask, int[][] cache) {
        if (num == 30) {
            if ((primeFactors[num] & mask) != 0) {
                return 0;
            }
            return freqs[num];
        }

        if (cache[num][mask] != -1) {
            return cache[num][mask];
        }

        long countWithout = squareFreeSubsets(freqs, primeFactors, num + 1, mask, cache) % MOD;

        if (freqs[num] == 0 || (primeFactors[num] & mask) != 0) {
            cache[num][mask] = (int) countWithout;
            return countWithout;
        }

        long countWith = freqs[num] + freqs[num] * squareFreeSubsets(freqs, primeFactors, num + 1, primeFactors[num] | mask, cache) % MOD;
        countWith %= MOD;

        cache[num][mask] = (int) ((countWithout + countWith) % MOD);
        return (countWithout + countWith) % MOD;
      
    }
}