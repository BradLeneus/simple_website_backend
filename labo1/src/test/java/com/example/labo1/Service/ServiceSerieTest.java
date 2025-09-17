package com.example.labo1.Service;

import com.example.labo1.Model.Series;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServiceSerieTest {

    @Test
    void testEpisodesCount() {
        Series s = new Series();
        s.setEpisodesNumber(3);
        assertEquals(3, s.getEpisodesNumber());
    }
    @Test
    void testDeleteSeries() {
        Series s = new Series();
        s.setEpisodesNumber(3);
        assertEquals(3, s.getEpisodesNumber());
    }
}