package com.kodilla.good.patterns.flights;

import java.util.List;

public class ListDto {

    private List<String> list;
    private List<String> list1;


    ListDto(List<String> list, List<String> list1) {
        this.list = list;
        this.list1 = list1;
    }

    public List<String> getList() {
        return list;
    }

    public List<String> getList1() {
        return list1;
    }
}
