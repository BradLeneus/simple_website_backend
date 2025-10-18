package com.example.labo1.Service;

import com.example.labo1.Model.Episode;
import com.example.labo1.Model.EpisodesRatings;
import com.example.labo1.Model.Person;
import com.example.labo1.Repositories.RepositoryEpisodesRatings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EpisodeRatingsServiceTest {

    @Mock
    private RepositoryEpisodesRatings repositoryEpisodesRatings;

    @Mock
    private EpisodeService episodeService;

    @Mock
    private PersonService personService;

    @InjectMocks
    private EpisodeRatingsService episodeRatingsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testRateEpisodes_UpdateExistingRating() {
        int personId = 1;
        int episodeId = 10;
        double ratingValue = 5.0;

        EpisodesRatings existingRating = new EpisodesRatings();
        existingRating.setPerson(new Person());
        existingRating.setEpisode(new Episode());
        existingRating.setRating(3.0);

        when(repositoryEpisodesRatings.findByPerson_IdAndEpisode_Id(personId, episodeId))
                .thenReturn(existingRating);

        boolean result = episodeRatingsService.rateEpisodes(personId, episodeId, ratingValue);

        assertTrue(result);
        assertEquals(ratingValue, existingRating.getRating());
        verify(repositoryEpisodesRatings, times(1)).save(existingRating);
    }

    @Test
    void testGetAverageRating_WithValue() {
        int episodeId = 10;
        when(repositoryEpisodesRatings.avgForEpisodes(episodeId)).thenReturn(4.2);

        double avg = episodeRatingsService.getAverageRating(episodeId);

        assertEquals(4.2, avg);
    }

    @Test
    void testGetAverageRating_NoValue() {
        int episodeId = 10;
        when(repositoryEpisodesRatings.avgForEpisodes(episodeId)).thenReturn(null);

        double avg = episodeRatingsService.getAverageRating(episodeId);

        assertEquals(0.0, avg);
    }
}
