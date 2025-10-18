package com.example.labo1.Service;

import com.example.labo1.Model.Series;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecommendationSerieServiceTest {

    @Mock
    private HistoryService historyService;

    @Mock
    private SeriesService seriesService;

    @InjectMocks
    private RecommendationSerieService recommendationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMostViewGender() {
        Series s1 = new Series();
        s1.setGenre("Action");
        Series s2 = new Series();
        s2.setGenre("Drama");
        Series s3 = new Series();
        s3.setGenre("Action");

        when(historyService.findAllWatchedSerie()).thenReturn(Arrays.asList(s1, s2, s3));

        List<String> topGenres = recommendationService.getMostViewGender();
        assertEquals(2, topGenres.size());
        assertEquals("Action", topGenres.get(0));
    }

    @Test
    void testRecommendNonWatchedSerie() {
        int userId = 1;
        Series s1 = new Series(); s1.setGenre("Action"); s1.setTitle("A1");
        Series s2 = new Series(); s2.setGenre("Action"); s2.setTitle("A2");
        Series s3 = new Series(); s3.setGenre("Drama"); s3.setTitle("D1");
        Series s4 = new Series(); s4.setGenre("Comedy"); s4.setTitle("C1");

        when(historyService.findSerieByUserId(userId)).thenReturn(Collections.singletonList(s1));
        when(seriesService.getAllByGenre("Action")).thenReturn(Arrays.asList(s1, s2));
        when(seriesService.getAllByGenre("Drama")).thenReturn(Collections.singletonList(s3));
        when(seriesService.getAllByGenre("Comedy")).thenReturn(Collections.singletonList(s4));

        // Mock des genres les plus vus
        RecommendationSerieService spyService = Mockito.spy(recommendationService);
        doReturn(Arrays.asList("Action","Drama","Comedy")).when(spyService).getMostViewGenderByTheUser(userId);

        List<Series> recommended = spyService.recommendNonWatchedSerie(userId, false);

        assertTrue(recommended.contains(s2));
        assertTrue(recommended.contains(s3));
        assertTrue(recommended.contains(s4));
        assertFalse(recommended.contains(s1)); // déjà regardée
    }

    @Test
    void testTendance() {
        Series s1 = new Series(); s1.setGenre("Action");
        Series s2 = new Series(); s2.setGenre("Drama");
        Series s3 = new Series(); s3.setGenre("Comedy");

        when(historyService.findAllWatchedSerie()).thenReturn(Arrays.asList(s1, s2, s3));
        when(seriesService.getAllByGenre("Action")).thenReturn(Collections.singletonList(s1));
        when(seriesService.getAllByGenre("Drama")).thenReturn(Collections.singletonList(s2));
        when(seriesService.getAllByGenre("Comedy")).thenReturn(Collections.singletonList(s3));

        List<Series> trend = recommendationService.tendance();
        assertEquals(3, trend.size());
        assertTrue(trend.containsAll(Arrays.asList(s1, s2, s3)));
    }
}
