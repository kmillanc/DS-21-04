package e3;
import java.time.Period;
import java.lang.IllegalArgumentException;
public class Clock {
    public enum Period{AM, PM}
    public Period periodo;
    int horas, minutos, segundos;
    public Period getPeriodo() {
        return periodo;
    }
    public void setPeriodo(Period periodo) {
        this.periodo = periodo;
    }
    /**
     * Creates a Clock instance parsing a String .
     * @param s The string representing the hour in 24h format (17:25:15) or in
     * 12h format (05:25:15 PM ).
     * @throws IllegalArgumentException if the string is not a valid hour .
     */

    public Clock(String s){
        if(s.length() == 11) {
            for (int i = 0; i < s.length(); i++) {
                s = s.replaceAll(" ", ":");
            }
        }
        String[] parts = s.split(":");
        if(s.length() < 8 || s.length() > 11) {
            throw new IllegalArgumentException("The String is not a valid hour");
        }
        else if((s.length() == 8) && (Integer.parseInt(parts[0]) < 24) && (Integer.parseInt(parts[1]) < 60) && (Integer.parseInt(parts[2]) < 60) && (Integer.parseInt(parts[0]) >= 0) && (Integer.parseInt(parts[1]) >= 0) && (Integer.parseInt(parts[2]) >= 0)){
            horas = Integer.parseInt(parts[0]);
            minutos = Integer.parseInt(parts[1]);
            segundos = Integer.parseInt(parts[2]);
        }
        else if(s.length() == 11 && (Integer.parseInt(parts[0]) < 13) && (Integer.parseInt(parts[1]) < 60) && (Integer.parseInt(parts[2]) < 60) && (Integer.parseInt(parts[0]) >= 0) && (Integer.parseInt(parts[1]) >= 0) && (Integer.parseInt(parts[2]) >= 0) && (parts[3].equals("PM")||parts[3].equals("AM"))){
            horas = Integer.parseInt(parts[0]);
            minutos = Integer.parseInt(parts[1]);
            segundos = Integer.parseInt(parts[2]);
            if(parts[3].equals("AM")){
                setPeriodo(Period.AM);
            }else{
                setPeriodo(Period.PM);
            }
        }
        else {
            throw new IllegalArgumentException("The String is not a valid hour");
        }
    }
    /**
     * Creates a clock given the values in 24h format .
     * @param hours Hours in 24h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock(int hours, int minutes, int seconds){
        if((hours < 0)||(hours > 23)||(minutes < 0)||(minutes > 59)||(seconds < 0)||(seconds > 59)) {
            throw new IllegalArgumentException("The value is not a valid hour");
        }else{
            int resultHours = hours;
            int resultMin = minutes;
            int resultSeg = seconds;
            minutos = resultMin;
            horas = resultHours;
            segundos = resultSeg;
        }
    }
    /**
     * Creates a clock given the values in 12h format . Period is a enumeration
     * located inside the Clock class with two values : AM and PM.
     * @param hours Hours in 12h format .
     * @param minutes Minutes .
     * @param seconds Seconds .
     * @param period Period used by the Clock ( represented by an enum ).
     * @throws IllegalArgumentException if the values do not represent a valid
     * hour .
     */
    public Clock(int hours, int minutes, int seconds, Period period){
        if((hours < 0)||(hours > 12)||(minutes < 0)||(minutes > 59)||(seconds < 0)||(seconds > 59) || (!period.toString().equals("AM") && !period.toString().equals("PM")) ) {
            throw new IllegalArgumentException("The value is not a valid hour");
        }else{
            int resultHours = hours;
            int resultMin = minutes;
            int resultSeg = seconds;
            minutos = resultMin;
            horas = resultHours;
            segundos = resultSeg;
            if(period.toString().equals("AM")){
                setPeriodo(Period.AM);
            }else{
                setPeriodo(Period.PM);
            }
        }
    }
    /**
     * Returns the hours of the clock in 24h format
     * @return the hours in 24h format
     */
    public int getHours24(){
        if(String.valueOf(periodo).equals("PM")){
            int resultHours = (horas + 12);
            return resultHours;
        }
        else if((String.valueOf(periodo).equals("AM"))&&(horas == 12)){
            int resultHours = 0;
            return resultHours;
        }
        else {
            return horas;
        }
    }
    /**
     * Returns the hours of the clock in 12h format
     * @return the hours in 12h format
     */
    public int getHours12(){
        if(horas < 13){
            return horas;
        }
        else {
            return horas - 12;
        }
    }
    /**
     * Returns the minutes of the clock
     * @return the minutes
     */
    public int getMinutes(){
        return minutos;
    }
    /**
     * Returns the seconds of the clock .
     * @return the seconds .
     */
    public int getSeconds(){
        return segundos;
    }
    /**
     * Returns the period of the day (AM or PM) that the clock is representing
     * @return An instance of the Clock . Period enum depending if the time is
     * before noon (AM) or after noon (PM ).
     */
    public Period getPeriod(){
        if(periodo != null){
            return periodo;
        }
        if(horas >= 12){
            periodo = Period.PM;
            return periodo;
        }else{
            periodo = Period.AM;
            return periodo;
        }
    }
    /**
     * Prints a String representation of the clock in 24h format .
     * @return An string in 24h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour24(){
        String str = "";
        horas = this.getHours24();
        String sHoras = String.valueOf(horas);
        String sMinutos = String.valueOf(minutos);
        String sSegundos = String.valueOf(segundos);
        if(sHoras.length() == 1){
            sHoras = "0".concat(sHoras);
        }
        if(sMinutos.length() == 1){
            sMinutos = "0".concat(sMinutos);
        }
        if(sSegundos.length() == 1){
            sSegundos = "0".concat(sSegundos);
        }
        str = str.concat(sHoras + ":" + sMinutos + ":" + sSegundos);
        return str;
    }
    /**
     * Prints a String representation of the clock in 12h format .
     * @return An string in 12h format
     * @see String . format function to format integers with leading zeroes
     */
    public String printHour12(){
        String str = "";
        getPeriod();
        horas = this.getHours12();
        String sHoras = String.valueOf(horas);
        String sMinutos = String.valueOf(minutos);
        String sSegundos = String.valueOf(segundos);
        if(sHoras.length() == 1){
            sHoras = "0".concat(sHoras);
        }
        if(sMinutos.length() == 1){
            sMinutos = "0".concat(sMinutos);
        }
        if(sSegundos.length() == 1){
            sSegundos = "0".concat(sSegundos);
        }
        str = str.concat(sHoras + ":" + sMinutos + ":" + sSegundos + " " + periodo);
        return str;
    }

    /**
     * Performs the equality tests of the current clock with another clock
     * passed as a parameter . Two clock are equal if they represent the same
     * instant regardless of being in 12h or 24h format .
     * @param o The clock to be compared with the current clock .
     * @return true if the clocks are equals , false otherwise .
     */

    @Override
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        else if(o == null){
            return false;
        }
        else if(this.getClass() != o.getClass()) {
            return false;
        }
        Clock clock = (Clock) o;
        if((this.getClass() == o.getClass()) && (this.getPeriod() == clock.getPeriod())){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Returns a integer that is a hash code representation of the clock using
     * the " hash 31" algorithm .
     * Clocks that are equals must have the same hash code .
     * @return the hash code
     */

    @Override
    public int hashCode(){
        int result;
        horas = getHours24();
        result = horas;
        result = 31 * result + minutos;
        result = 31 * result + segundos;
        periodo = getPeriod();
        result = 31 * result + (String.valueOf(periodo).hashCode());
        return result;
    }

}