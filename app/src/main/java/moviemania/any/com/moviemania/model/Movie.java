package moviemania.any.com.moviemania.model;

import java.util.List;

/**
 * Created by ASTER-NOTUS on 09.12.2015.
 */
public class Movie
{
    private String name;
    private List<Integer> genres;
    private Rate rate;
    private float averageRate;
    private float generalRate;

    public float getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(float averageRate) {
        this.averageRate = averageRate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGenres() {
        return genres;
    }

    public void setGenres(List<Integer> genres) {
        this.genres = genres;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public float getGeneralRate() {
        return generalRate;
    }

    public void setGeneralRate(float generalRate) {
        this.generalRate = generalRate;
    }
}
