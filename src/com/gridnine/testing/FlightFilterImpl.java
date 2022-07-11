package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterImpl implements FlightFilter {

    public List<Flight> departureBeforeTheCurrentTime(List<Flight> flights) {
        System.out.println("Отфильтрованы полёты с вылетом до текущего момента времени:");
        LocalDateTime now = LocalDateTime.now();
        List<Flight> filteredList = new ArrayList<>(flights);
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isBefore(now)) {
                    filteredList.remove(flight);
                }
            }
        }
        return filteredList;
    }

    public List<Flight> arrivalBeforeDeparture(List<Flight> flights) {
        System.out.println("Отфильтрованы полёты, содержащие сегменты, в которых дата прилёта раньше даты вылета: ");
        List<Flight> filteredList = new ArrayList<>(flights);
        for (Flight flight : flights) {
            for (Segment segment : flight.getSegments()) {
                if (segment.getDepartureDate().isAfter(segment.getArrivalDate())) {
                    filteredList.remove(flight);
                }
            }
        }
        return filteredList;
    }

    public  List<Flight> timeOnTheGroundMoreThanTwoHours(List<Flight> flights){
       System.out.println("Отфильтрованы полёты в которых общее время, проведённое на земле превышает два часа: ");
        List<Flight> filtеredList = new ArrayList<>(flights);
        int hoursOnTheGround = 0;

        for (Flight flight : flights) {
              List<Segment> segments = flight.getSegments();
              if (segments.size() > 1) {
                  for (int i = 0; i < segments.size() -1; i++) {
                      hoursOnTheGround += Math.toIntExact(Math.abs(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours()));
                  }
              }
                if (hoursOnTheGround > 2) {
                filtеredList.remove(flight);
            }
            hoursOnTheGround = 0;
        }
         return  filtеredList;
    }
 }




