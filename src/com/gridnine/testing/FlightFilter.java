package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
    public List<Flight> departureBeforeTheCurrentTime(List<Flight> flights);
    public List<Flight> arrivalBeforeDeparture(List<Flight> flights);
    public  List<Flight> timeOnTheGroundMoreThanTwoHours(List<Flight> flights);
}
