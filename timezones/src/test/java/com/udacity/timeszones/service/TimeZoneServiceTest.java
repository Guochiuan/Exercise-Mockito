package com.udacity.timeszones.service;


import com.udacity.timezones.client.WorldTimeApiClient;
import com.udacity.timezones.client.WorldTimeApiHttpClient;
import com.udacity.timezones.service.TimeZoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TimeZoneServiceTest {

    private TimeZoneService timeZoneService;

    @Mock
    private WorldTimeApiClient worldTimeApiClient;

    @BeforeEach
    void init() {
        timeZoneService = new TimeZoneService(worldTimeApiClient);

    }
    @Test
    void getAvailableTimezoneText_timeApiReturnsStringList_returnsCountriesAsString() {
        List<String> validTimeZones = List.of("Amsterdam", "Andorra", "Astrakhan", "Athens");

        when(worldTimeApiClient.getValidTimeZones(anyString())).thenReturn(validTimeZones);
        String expectedReturn = "Amsterdam, Andorra, Astrakhan, Athens";

        String timeZoneText = timeZoneService.getAvailableTimezoneText("Europe");

        assertTrue(timeZoneText.contains(expectedReturn));
    }
}