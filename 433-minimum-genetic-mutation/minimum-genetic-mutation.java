class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> valid = new HashSet<>();
        Collections.addAll(valid, bank);

        Queue<GenePair> queue = new LinkedList<>();
        queue.add(new GenePair(startGene, 0));
        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        while (!queue.isEmpty()) {
            GenePair poll = queue.poll();
            String gene = poll.gene;
            int steps = poll.steps;

            if (gene.equals(endGene)) return steps;
            StringBuilder sb = new StringBuilder(gene);

            for (int i = 0; i < 8; i++) {
                char c = sb.charAt(i);
                sb.setCharAt(i, 'A');
                addIfValid(sb.toString(), steps, visited, queue, valid);
                sb.setCharAt(i, 'C');
                addIfValid(sb.toString(), steps, visited, queue, valid);
                sb.setCharAt(i, 'G');
                addIfValid(sb.toString(), steps, visited, queue, valid);
                sb.setCharAt(i, 'T');
                addIfValid(sb.toString(), steps, visited, queue, valid);
                sb.setCharAt(i, c);
            }
        }
        return -1;
    }

    private static void addIfValid(String string, int steps, Set<String> visited, Queue<GenePair> queue, Set<String> valid) {
        if (valid.contains(string) && !visited.contains(string)) {
            queue.add(new GenePair(string, steps+1));
            visited.add(string);
        }
    }

    static class GenePair {
        private String gene;
        private int steps;

        public GenePair(String gene, int steps) {
            this.gene = gene;
            this.steps = steps;
        }

    }
}