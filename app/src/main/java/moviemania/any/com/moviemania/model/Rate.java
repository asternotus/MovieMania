package moviemania.any.com.moviemania.model;

/**
 * Created by Юра on 09.12.2015.
 */
public class Rate
{
    private int plot;
    private int acting;
    private int specialEffects;
    private int touchEffect;
    private int montage;
    private int soundtrack;
    private int sumOfAllRates;


    public int getPlot() {
        return plot;
    }

    public void setPlot(int plot) {
        this.plot = plot;
    }

    public int getActing() {
        return acting;
    }

    public void setActing(int acting) {
        this.acting = acting;
    }

    public int getSpecialEffects() {
        return specialEffects;
    }

    public void setSpecialEffects(int specialEffects) {
        this.specialEffects = specialEffects;
    }

    public int getTouchEffect() {
        return touchEffect;
    }

    public void setTouchEffect(int touchEffect) {
        this.touchEffect = touchEffect;
    }

    public int getMontage() {
        return montage;
    }

    public void setMontage(int montage) {
        this.montage = montage;
    }

    public int getSoundtrack() {
        return soundtrack;
    }

    public void setSoundtrack(int soundtrack) {
        this.soundtrack = soundtrack;
    }

    public int getSumOfAllRates(){
        sumOfAllRates = acting + plot + specialEffects + touchEffect + montage + soundtrack;
        return sumOfAllRates;
    }

}
