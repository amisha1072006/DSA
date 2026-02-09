class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        final TreeMap<Integer, Map<String, Integer>> tables = new TreeMap<>();
        final TreeSet<String> meals = new TreeSet<>();

        for(final List<String> order : orders) {
            final int tableNum = Integer.valueOf(order.get(1));

            tables.putIfAbsent(tableNum, new HashMap<>());

            final Map<String, Integer> table = tables.get(tableNum);

            table.put(order.get(2), table.getOrDefault(order.get(2), 0) + 1);

            meals.add(order.get(2));
        }

        final List<List<String>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        result.get(0).add("Table");
        result.get(0).addAll(meals);

        for(final int tableNum : tables.keySet()) {
            final List<String> tableOrders = new ArrayList<>();
            tableOrders.add(String.valueOf(tableNum));

            final Map<String, Integer> table = tables.get(tableNum);

            for(int i = 1; i < result.get(0).size(); ++i) {
                final String meal = result.get(0).get(i);

                tableOrders.add(table.containsKey(meal) ? String.valueOf(table.get(meal)) : "0");
            }

            result.add(tableOrders);
        }

        return result;
    
    }
}