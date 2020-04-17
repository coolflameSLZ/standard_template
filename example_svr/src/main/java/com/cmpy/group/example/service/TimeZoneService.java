package com.cmpy.group.example.service;

import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class TimeZoneService {

    public TimeZoneList listTimeZones() {
        TimeZoneList timeZoneList = TimeZoneList.builder().build();
        for (String id : TimeZone.getAvailableIDs()) {
            timeZoneList.getTimezones().add(id);
        }
        return timeZoneList;
    }
}
