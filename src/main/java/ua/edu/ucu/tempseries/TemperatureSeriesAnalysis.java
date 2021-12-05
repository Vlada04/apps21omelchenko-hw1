package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {
    double[] temperatureSeries;

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            sum += temperatureSeries[i];}
        return Math.round(sum/temperatureSeries.length * 100.0)/100.0;
        }

    public double deviation() {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double mean = average();
        double deviation = 0;
        for (int i = 0; i < temperatureSeries.length; i++) {
            deviation += Math.pow((temperatureSeries[i] - mean), 2);
        }
        return Math.round(Math.sqrt(deviation/temperatureSeries.length)* 10.0)/10.0;
    }

    public double min() {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double min = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            double value = temperatureSeries[i];
            min = Math.min(min, value);
        }
        return min;
    }

    public double max() {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double max = temperatureSeries[0];
        for (int i = 1; i < temperatureSeries.length; i++) {
            double value = temperatureSeries[i];
            max = Math.max(max, value);
        }
        return max;
    }

    public double findTempClosestToZero() {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        int closestIndex = 0;
        double diff = Integer.MAX_VALUE;
        for (int i = 0; i < temperatureSeries.length; ++i) {
            double abs = Math.abs(temperatureSeries[i]);
            if (abs < diff) {
                closestIndex = i;
                diff = abs;
            } else if (abs == diff && temperatureSeries[i] > 0 && temperatureSeries[closestIndex] < 0) {
                closestIndex = i;
            }
        }
        return temperatureSeries[closestIndex];
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        double distance = Math.abs(temperatureSeries[0] - tempValue);
        int idx = 0;
        for (int i = 1; i < temperatureSeries.length; i++) {
            double idistance = Math.abs(temperatureSeries[i] - tempValue);
            if (idistance < distance) {
                idx = i;
                distance = idistance;
            } else if (idistance == distance && temperatureSeries[i] > 0 && temperatureSeries[idx] < 0) {
                idx = i;
            }
        }
        return temperatureSeries[idx];
    }

    public double[] findTempsLessThen(double tempValue) {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        int indx = 0;
        double[] res = new double[temperatureSeries.length];
        for(int i = 0; i < temperatureSeries.length; i++){
            if (temperatureSeries[i] < tempValue){
                res[indx] = temperatureSeries[i];
                indx++;
            }
        }
        return res;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
        int indx = 0;
        double[] res = new double[temperatureSeries.length];
        for(int i = 0; i < temperatureSeries.length; i++){
            if (temperatureSeries[i] > tempValue){
                res[indx] = temperatureSeries[i];
                indx++;
            }
        }
        return res;
    }

    public TempSummaryStatistics summaryStatistics() {
        TempSummaryStatistics summary = new TempSummaryStatistics();
        summary.avgTemp = average();
        summary.devTemp = deviation();
        summary.maxTemp = max();
        summary.minTemp = min();
        return summary;
    }

//    public int addTemps(double... temps) {
//        for
//        return 0;
//    }
}