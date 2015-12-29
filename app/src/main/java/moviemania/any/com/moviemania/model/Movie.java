package moviemania.any.com.moviemania.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ASTER-NOTUS on 09.12.2015.
 */
public class Movie
{
    private String id;
    private String name;
    private ArrayList<String> genres;
    private Rate rate;
    private float averageRate;
    private float generalRate;

    public Movie() {
        genres = new ArrayList<String>();
        id = UUID.randomUUID().toString() + this.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    //This method should be called after filling all rates.
    public float calculateAverageRate(Rate rate){
        if(rate != null){
        averageRate = (float)(rate.getSumOfAllRates()/6); }
        return averageRate;
    }

    public void addGenresToMovie(String nameOfGenre){
        genres.add(nameOfGenre);
    }




    //Instead of creating a lot of constants we made enum which contains all of them.
    public enum Genres {

        COMEDY("Comedy"), THRILLER("Thriller"), DRAMA("Drama"), HORROR("Horror"), ACTION("Action"),
        DISASTER("Disaster"), FANTASY("Fantasy"), DETECTIVE("Detective"), CRIME("CRIME"), ADVENTURE("Adventure"),
        SPORTS("Sports"), DOCUMENTAL("Documental"), ROMANCE("Romance"), SCIFI("Sci-fi"), MYSTERY("Mystery"),
        CARTOON("Cartoon");

        Genres(String nameOfGenre){
            this.nameOfGenre = nameOfGenre;
        }

        String nameOfGenre;
    }


}
