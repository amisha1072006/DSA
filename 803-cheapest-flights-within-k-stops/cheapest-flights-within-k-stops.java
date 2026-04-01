class Solution {
    public int findCheapestPrice(int numOfCities, int[][] flights, int source, int destination, int maxStops) {
        
        ArrayList<ArrayList<Flight>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numOfCities; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int fromCity = flight[0];
            int toCity = flight[1];
            int price = flight[2];
            adjacencyList.get(fromCity).add(new Flight(toCity, price));
        }

        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, source, 0));

        int[] costs = new int[numOfCities];
        for (int i = 0; i < numOfCities; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        costs[source] = 0;

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            int stops = current.stops;
            int city = current.city;
            int cost = current.cost;

            if (stops > maxStops) continue;

            for (Flight flight : adjacencyList.get(city)) {
                int adjacentCity = flight.toCity;
                int edgeWeight = flight.price;

                if (cost + edgeWeight < costs[adjacentCity] && stops <= maxStops) {
                    costs[adjacentCity] = cost + edgeWeight;
                    queue.add(new Tuple(stops + 1, adjacentCity, cost + edgeWeight));
                }
            }
        }

        return costs[destination] == Integer.MAX_VALUE ? -1 : costs[destination];
    }
    
    class Flight {
        int toCity;
        int price;

        Flight(int toCity, int price) {
            this.toCity = toCity;
            this.price = price;
        }
    }

    class Tuple {
        int stops;
        int city;
        int cost;

        Tuple(int stops, int city, int cost) {
            this.stops = stops;
            this.city = city;
            this.cost = cost;
        }
        
    }
}