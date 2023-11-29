package org.mahauni.dao;

import org.mahauni.model.HealthTech;
import org.mahauni.model.Rating;

import java.util.List;

public interface RatingDAO {
    void rateTech(Rating rating);

    List<Rating> getRatings(HealthTech tech);
}
