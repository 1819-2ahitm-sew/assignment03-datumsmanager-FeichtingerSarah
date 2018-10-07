package at.htl.mydate;

/**
 * Informationen zu Enums: http://tutorials.jenkov.com/java/enums.html
 *               zu split: https://stackoverflow.com/a/3481842/9818338
 *   zur Ermittlung des Wochentages: https://de.wikipedia.org/wiki/Wochentagsberechnung#Programmierung
 */


public class MyDate {
    /**
     * Formatierung des Datums
     *
     * @return String, zB Samstag, 29. September 2018
     */

    private int youngD = 31;
    private int youngM = 12;
    private int youngY = Integer.MAX_VALUE;
    public int d;
    public int m;
    public int y;
    private String weekday;

    private String date = "";

    public MyDate(String dateString){
        extraktDate(dateString);
    }

    public void extraktDate(String dateString){
        String [] date = dateString.split("\\.");
        this.d = Integer.valueOf(date[0]);
        this.m = Integer.valueOf(date[1]);
        this.y = Integer.valueOf(date[2]);
    }

    public String getWeekday()
    {
        return weekday;
    }

    public String formatDate() {

        int weekday = ((d + (int)(2.6 * ((m + 9) % 12 + 1) - 0.2)
                + y % 100 + (int)(y % 100 / 4) + (int)(y / 400)
                - 2 * (int)(y / 100) - 1) % 7 + 7) % 7 + 1;

        return null;
    }

    /**
     *  Überprüfen, ob ein übergebenes Datum (other) jünger oder älter ist
     *
     * @param other
     * @return true, wenn this-Datum jünger als other-Datum ist
     *         false, wenn this-Datum jünger oder gleich other-Datum ist
     */
    public boolean isYoungerThan() {
        boolean younger = false;

        if (y < youngY)
        {
            younger = true;
        }
        else if (y == youngY && m <= youngM)
        {
            if(m < youngM)
            {
                younger = true;
            }
            else if(m == youngM && d < youngD)
            {
                younger = true;
            }
        }
        if (younger)
        {
            youngD = d;
            youngM = m;
            youngY = y;
        }

        return younger;
    }


}
