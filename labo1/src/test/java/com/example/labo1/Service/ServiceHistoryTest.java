package com.example.labo1.Service;

import com.example.labo1.Model.History;
import com.example.labo1.Model.Person;
import com.example.labo1.Model.Series;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceHistoryTest {

    @Test
    void testAddSerieToHistory() {
        Person p = new Person();
        p.setId(1);
        p.setName("User");

        Series s = new Series();
        s.setId(5);
        s.setTitle("MyShow");

        History h = new History();
        h.setPerson(p);
        h.setSeries(s);

        assertEquals("User", h.getPerson().getName());
        assertEquals("MyShow", h.getSeries().getTitle());
    }

    @Test
    void testFindSerieByUserIdLogic() {
        Person p = new Person();
        p.setId(1);

        Series s = new Series();
        s.setTitle("Show1");

        History h = new History();
        h.setPerson(p);
        h.setSeries(s);

        List<History> histories = new ArrayList<>();
        histories.add(h);

        List<Series> seriesList = new ArrayList<>();
        for (History history : histories) {
            if (history.getPerson().getId() == 1) {
                seriesList.add(history.getSeries());
            }
        }

        assertEquals(1, seriesList.size());
        assertEquals("Show1", seriesList.get(0).getTitle());
    }

    @Test
    void testFindAllWatchedSerieLogic() {
        Series s1 = new Series();
        s1.setTitle("Show1");
        Series s2 = new Series();
        s2.setTitle("Show2");

        History h1 = new History();
        h1.setSeries(s1);
        History h2 = new History();
        h2.setSeries(s2);

        List<History> histories = new ArrayList<>();
        histories.add(h1);
        histories.add(h2);

        List<Series> allSeries = new ArrayList<>();
        for (History history : histories) {
            allSeries.add(history.getSeries());
        }

        assertEquals(2, allSeries.size());
        assertEquals("Show2", allSeries.get(1).getTitle());
    }
}
