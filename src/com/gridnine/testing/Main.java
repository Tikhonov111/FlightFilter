package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> fullFlightList = FlightBuilder.createFlights();
        FlightFilterImpl filter = new FlightFilterImpl();
        ListPrinter listPrinter = new ListPrinter();

        System.out.println("Список всех полётов без фильтрации: ");
        listPrinter.printList(fullFlightList);

        List<Flight> filterList = filter.departureBeforeTheCurrentTime(fullFlightList);
        listPrinter.printList(filterList);

        filterList = filter.arrivalBeforeDeparture(fullFlightList);
        listPrinter.printList(filterList);

        filterList = filter.timeOnTheGroundMoreThanTwoHours(fullFlightList);
        listPrinter.printList(filterList);
    }
}
