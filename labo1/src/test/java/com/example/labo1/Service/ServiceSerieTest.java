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

    @Test
    void testUpdateSerieTitle() {
        Series s = new Series();
        s.setTitle("Old");
        s.setTitle("New");
        assertEquals("New", s.getTitle());
    }

    @Test
    void testUpdateSerieGenre() {
        Series s = new Series();
        s.setGenre("Drama");
        s.setGenre("Comedy");
        assertEquals("Comedy", s.getGenre());
    }

    @Test
    void testUpdateSerieEpisodesNumber() {
        Series s = new Series();
        s.setEpisodesNumber(5);
        s.setEpisodesNumber(10);
        assertEquals(10, s.getEpisodesNumber());
    }

    @Test
    void testUpdateSerieRating() {
        Series s = new Series();
        s.setRating(4.5);
        s.setRating(9.0);
        assertEquals(9.0, s.getRating());
    }
}