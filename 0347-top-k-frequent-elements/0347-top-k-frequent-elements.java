class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num:nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Pair<Integer, Integer>> sorted_freq_pairs = new ArrayList<>();
        for(var entry : freq.entrySet()) {
            Pair<Integer, Integer> freq_pair = new Pair<>(entry.getKey(), entry.getValue());
            sorted_freq_pairs.add(freq_pair);
        }

        Collections.sort(sorted_freq_pairs, (fp1, fp2) -> {
            return fp2.getValue() - fp1.getValue();
        });

        int[] results = new int[k];
        for(int i = 0; i < k; i++) {
            results[i] = sorted_freq_pairs.get(i).getKey();
        }

        return results;
    }
}