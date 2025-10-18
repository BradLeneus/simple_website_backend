package com.example.labo1.Service;

import com.example.labo1.Model.Person;
import com.example.labo1.Model.Series;
import com.example.labo1.Model.SeriesRatings;
import com.example.labo1.Repositories.RepositoryRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SeriesRatingsServiceTest {

    @Mock
    private RepositoryRating repositoryRating;

    @Mock
    private SeriesService seriesService;

    @Mock
    private PersonService personService;

    @InjectMocks
    private SeriesRatingsService seriesRatingsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testRateSeries_UpdateExistingRating() {
        int personId = 1;
        int seriesId = 10;
        double ratingValue = 5.0;

        SeriesRatings existingRating = new SeriesRatings();
        existingRating.setPerson(new Person());
        existingRating.setSeries(new Series());
        existingRating.setRating(3.0);

        when(repositoryRating.findByPerson_IdAndSeries_Id(personId, seriesId)).thenReturn(existingRating);

        boolean result = seriesRatingsService.rateSeries(personId, seriesId, ratingValue);

        assertTrue(result);
        assertEquals(ratingValue, existingRating.getRating());
        verify(repositoryRating, times(1)).save(existingRating);
    }

    @Test
    void testGetAverageRating_WithValue() {
        int seriesId = 10;
        when(repositoryRating.avgForSeries(seriesId)).thenReturn(4.2);

        double avg = seriesRatingsService.getAverageRating(seriesId);

        assertEquals(4.2, avg);
    }

    @Test
    void testGetAverageRating_NoValue() {
        int seriesId = 10;
        when(repositoryRating.avgForSeries(seriesId)).thenReturn(null);

        double avg = seriesRatingsService.getAverageRating(seriesId);

        assertEquals(0.0, avg);
    }
}
