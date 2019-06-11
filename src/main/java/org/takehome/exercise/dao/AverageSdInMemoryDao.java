package org.takehome.exercise.dao;

public class AverageSdInMemoryDao {


    private long numberCount = 0L;
    private double mM = 0.0;
    private double mS = 0.0;
    private double sum;

    public void update(Double value) {
        ++numberCount;
        sum += value;
        double nextM = mM + (value - mM) / numberCount;
        mS += (value - mM) * (value - nextM);
        mM = nextM;
    }


    public double getAverage() {
        return sum/numberCount;
    }

    public double getSd() {
        return Math.sqrt(variance());
    }

    public double variance() {
        return numberCount > 1 ? mS/numberCount : 0.0;
    }
}
