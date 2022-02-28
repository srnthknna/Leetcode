// https://leetcode.com/problems/design-underground-system

class UndergroundSystem {
    
    Map<String, Pair<Double, Double>> journey;
    Map<Integer, Pair<String, Integer>> checkIn;

    public UndergroundSystem() {
        journey = new HashMap<>();
        checkIn = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = checkIn.get(id);
        String start = checkInData.getKey();
        Integer checkInTime = checkInData.getValue();
        
        String routeKey = stationsKey(start, stationName);
        
        Pair<Double, Double> routeStats = journey.getOrDefault(routeKey, new Pair<>(0.0, 0.0));
        Double totalTripTime = routeStats.getKey();
        Double totalTrips = routeStats.getValue();
        
        double tripTime = t - checkInTime;
        
        journey.put(routeKey, new Pair<>(totalTripTime + tripTime, totalTrips + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = stationsKey(startStation, endStation);
        Double totalTime = journey.get(routeKey).getKey();
        Double trips = journey.get(routeKey).getValue();
        return totalTime / trips;
    }
    
    private String stationsKey(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */