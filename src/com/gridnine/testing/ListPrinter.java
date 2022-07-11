package com.gridnine.testing;

import java.util.List;

public class ListPrinter {
    public void printList(List<Flight> list) {
        list.forEach(System.out::println);
        System.out.println("======================================================================================");
        System.out.println();
    }
}
