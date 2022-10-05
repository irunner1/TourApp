package com.example.kr.adapter;

import static org.junit.jupiter.api.Assertions.*;

import com.example.kr.R;
import com.example.kr.model.NextTripsData;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

class NextTripAdapterTest {
    @Test
    void checkAdd() {
        List<NextTripsData> NextTripDataList = new ArrayList<>();
        Assertions.assertEquals("asd", NextTripAdapter.addItem(NextTripDataList,"asd", "zxc", 123));
    }

    @Test
    void checkDelete() {
        List<NextTripsData> NextTripDataList = new ArrayList<>();
        NextTripDataList.add(new NextTripsData("Абхазия","15-20 июля", R.drawable.tour1));
        assertFalse(NextTripAdapter.removeItem(NextTripDataList, "Абхазия", "15-20 июля", R.drawable.tour1));
    }

    @Test
    void checkLen() {
        List<NextTripsData> NextTripDataList = new ArrayList<>();
        NextTripDataList.add(new NextTripsData("Абхазия","15-20 июля", R.drawable.tour1));
        Assertions.assertEquals(1, NextTripAdapter.getNextTripLen(NextTripDataList));
    }
}