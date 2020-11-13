package stariq.datastructures.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/design-underground-system/
public class UndergroundSystem {

    class Average {
        private double sum;
        private int count;

        void add(double sum) {
            this.sum += sum;
            count++;
        }

        double getAvg() {
            return sum/count;
        }
    }

    class Location {
        String station;
        int time;

        Location(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        String stationA;
        String stationB;

        Route(String stationA, String stationB) {
            this.stationA = stationA;
            this.stationB = stationB;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj instanceof Route) {
                Route route = (Route) obj;
                boolean containsA =
                        this.stationA.equals(route.stationA) ||
                                this.stationA.equals(route.stationB);
                boolean containsB =
                        this.stationB.equals(route.stationA) ||
                                this.stationB.equals(route.stationB);
                if(containsA && containsB) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(stationA, stationB);
        }
    }

    Map<Integer, Location> idToLocation;
    Map<Route, Average> routeToAverage;

    public UndergroundSystem() {
        idToLocation = new HashMap<>();
        routeToAverage = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idToLocation.put(id, new Location(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Location location = idToLocation.get(id);
        idToLocation.remove(id);

        Route route = new Route(location.station, stationName);
        if(!routeToAverage.containsKey(route)) {
            routeToAverage.put(route, new Average());
        }
        Average average = routeToAverage.get(route);
        average.add(t - location.time);
    }

    public double getAverageTime(String startStation, String endStation) {
        Route route = new Route(startStation, endStation);
        if(routeToAverage.containsKey(route)) {
            return routeToAverage.get(route).getAvg();
        }
        return 0.0;
    }
}
