package moviemania.any.com.moviemania.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import moviemania.any.com.moviemania.model.Movie;
import moviemania.any.com.moviemania.model.Rate;

/**
 * Created by Юра on 25.12.2015.
 */
public class DBManager
{
    private static DBManager dbManager;
    private SQLiteDatabase sqLiteDatabase;
    private DBHelper dbHelper;
    private Context context;

    private final static String DATA_BASE_NAME = "movies_data_base";
    private final static String TABLE_MOVIES = "table_movies";
    private final static String MOVIES_COLUMN_AUTOINCREMENT = "column_autoincrement";
    private final static String MOVIES_COLUMN_ID = "column_id";
    private final static String MOVIES_COLUMN_NAME = "column_name";
    private final static String MOVIES_COLUMN_GENRES = "column_genres";
    private final static String MOVIES_COLUMN_RATE_ACTING = "column_acting";
    private final static String MOVIES_COLUMN_RATE_MONTAGE = "column_montage";
    private final static String MOVIES_COLUMN_RATE_PLOT = "column_plot";
    private final static String MOVIES_COLUMN_RATE_SOUNDTRACK = "column_soundtrack";
    private final static String MOVIES_COLUMN_RATE_SPECIALEFFECT = "column_specialeffects";
    private final static String MOVIES_COLUMN_RATE_TOUCHEFFECT = "column_toucheffect";
    private final static String MOVIES_COLUMN_AVERAGE_RATE = "column_averagerate";
    private final static String MOVIES_COLUMN_GENERAL_RATE = "column_generalrate";



    //creating instance of singleton which can be only one
    private DBManager(){ }

    public static synchronized DBManager getInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
        return dbManager;
    }


    public void init(Context context){
        this.context = context;}



    //create DB
    public void createDataBase(){
        dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();}

    private String parseAllGenresToString(ArrayList<String> list){
        String allGenres = "";
        for (String s : list){
            allGenres = s + "777";
        }
        return allGenres;
    }

    private ArrayList <String> divideAllGenresFromString(String genres){
        ArrayList<String> genresArray = new ArrayList<String>(Arrays.asList(genres.split("777")));
        return genresArray;
    }

    public void addMovieToDB(Movie movie){

        ContentValues cv = new ContentValues();

        cv.put(MOVIES_COLUMN_ID, movie.getId());
        cv.put(MOVIES_COLUMN_NAME, movie.getName());
        cv.put(MOVIES_COLUMN_GENRES, parseAllGenresToString(movie.getGenres()));
        cv.put(MOVIES_COLUMN_RATE_ACTING, movie.getRate().getActing());
        cv.put(MOVIES_COLUMN_RATE_MONTAGE, movie.getRate().getMontage());
        cv.put(MOVIES_COLUMN_RATE_PLOT, movie.getRate().getPlot());
        cv.put(MOVIES_COLUMN_RATE_SOUNDTRACK, movie.getRate().getSoundtrack());
        cv.put(MOVIES_COLUMN_RATE_SPECIALEFFECT, movie.getRate().getSpecialEffects());
        cv.put(MOVIES_COLUMN_RATE_TOUCHEFFECT, movie.getRate().getTouchEffect());
        cv.put(MOVIES_COLUMN_AVERAGE_RATE, movie.getAverageRate());
        cv.put(MOVIES_COLUMN_GENERAL_RATE, movie.getGeneralRate());


        String table = TABLE_MOVIES;

        sqLiteDatabase.insert(table, null, cv);
    }

    public List<Movie> getAllMovies(){

        String table = TABLE_MOVIES;
        List <Movie> listOfMovies = new ArrayList<Movie>();


        Cursor cursor = sqLiteDatabase.query(table, null, null, null, null, null, null);

        if(cursor != null){
            if(cursor.moveToFirst()){
                while(cursor.moveToNext()){
                    Movie movie = new Movie();
                    Rate rate = new Rate();
                    movie.setId(cursor.getString(cursor.getColumnIndex(MOVIES_COLUMN_ID)));
                    movie.setName(cursor.getString(cursor.getColumnIndex(MOVIES_COLUMN_NAME)));
                    movie.setGenres(divideAllGenresFromString(cursor.getString(cursor.getColumnIndex(MOVIES_COLUMN_GENRES))));
                    movie.setGeneralRate(cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_GENERAL_RATE)));
                    rate.setActing(cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_RATE_ACTING)));
                    rate.setMontage(cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_RATE_MONTAGE)));
                    rate.setPlot(cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_RATE_PLOT)));
                    rate.setSoundtrack(cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_RATE_SOUNDTRACK)));
                    rate.setSpecialEffects(cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_RATE_SPECIALEFFECT)));
                    rate.setTouchEffect(cursor.getInt(cursor.getColumnIndex(MOVIES_COLUMN_RATE_TOUCHEFFECT)));

                    movie.setRate(rate);
                    listOfMovies.add(movie);
                }
            }
        }

        return listOfMovies;

    }

    public void getMovieFromDBbyID(int id){
//TO DO

    }

    public void updateMovieToDB(){

    }

    public void deleteMovieFromDB(){

    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DATA_BASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table " + TABLE_MOVIES + " ("
                    + MOVIES_COLUMN_AUTOINCREMENT + " integer primary key autoincrement,"
                    + MOVIES_COLUMN_ID + " text,"
                    + MOVIES_COLUMN_NAME + " text,"
                    + MOVIES_COLUMN_GENRES + " text,"
                    + MOVIES_COLUMN_RATE_ACTING + " integer,"
                    + MOVIES_COLUMN_RATE_MONTAGE + " integer,"
                    + MOVIES_COLUMN_RATE_PLOT + " integer,"
                    + MOVIES_COLUMN_RATE_SOUNDTRACK + " integer,"
                    + MOVIES_COLUMN_RATE_SPECIALEFFECT + " integer,"
                    + MOVIES_COLUMN_RATE_TOUCHEFFECT + " integer,"
                    + MOVIES_COLUMN_AVERAGE_RATE + " real,"
                    + MOVIES_COLUMN_GENERAL_RATE + " real"
                    + ");");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

        }
    }
}
