package e4;
import com.sun.jdi.Value;
import java.util.Date;
public class TrafficJunction {
    enum color {GREEN, AMBER_OFF, RED, AMBER_ON};
    public static class semaforo{
        public String nombre;
        public color estado;
        public int clk;
        public semaforo(String nombre, color estado){
            this.nombre = nombre;
            this.estado = estado;
        }
        public String getNombre() {
            return nombre;
        }
        public void setEstado(color estado) {
            this.estado = estado;
        }
        public color getEstado() {
            return estado;
        }
        public void setClk(int clk) {
            this.clk = clk;
        }
        public int getClk() {
            return clk;
        }
    }
    public semaforo s1;
    public semaforo s2;
    public semaforo s3;
    public semaforo s4;

    /**
     * Creates a trafic junction with four traffic lights named north , south ,
     * east and west . The north traffic light has just started its green cycle .
     */
    public TrafficJunction(){
        semaforo n = new semaforo("NORTH", color.GREEN);
        this.s1 = n;
        semaforo s = new semaforo("SOUTH", color.RED);
        this.s2 = s;
        semaforo e = new semaforo("EAST", color.RED);
        this.s3 = e;
        semaforo w = new semaforo("WEST", color.RED);
        this.s4 = w;
    }
    /**
     * Indicates that a second of time has passed , so the traffic light with
     * the green or amber light should add 1 to its counter . If the counter
     * passes its maximum value the color of the traffic light must change .
     * If it changes to red then the following traffic light changes to green .
     * The order is: north , south , east , west and then again north .
     */
    public void timesGoesBy(){
        if(this.s1.getEstado() == color.GREEN || this.s1.getEstado() == color.AMBER_OFF ){
            this.s1.setClk(s1.getClk() +1);
            if(this.s1.getClk() == 16){
                this.s1.setEstado(color.AMBER_OFF);
            }else if(this.s1.getClk() == 22){
                this.s1.setEstado(color.RED);
                this.s1.setClk(0);
                this.s2.setEstado(color.GREEN);
            }
        }else if(this.s2.getEstado() == color.GREEN || this.s2.getEstado() == color.AMBER_OFF){
            this.s2.setClk(s2.getClk() +1);
            if(this.s2.getClk() == 16){
                this.s2.setEstado(color.AMBER_OFF);
            }else if(this.s2.getClk() == 22){
                this.s2.setEstado(color.RED);
                this.s2.setClk(0);
                this.s3.setEstado(color.GREEN);
            }
        }else if(this.s3.getEstado() == color.GREEN || this.s3.getEstado() == color.AMBER_OFF){
            this.s3.setClk(s3.getClk() +1);
            if(this.s3.getClk() == 16){
                this.s3.setEstado(color.AMBER_OFF);
            }else if(this.s3.getClk() == 22){
                this.s3.setEstado(color.RED);
                this.s3.setClk(0);
                this.s4.setEstado(color.GREEN);
            }
        }else if(this.s4.getEstado() == color.GREEN || this.s4.getEstado() == color.AMBER_OFF){
            this.s4.setClk(s4.getClk() +1);
            if(this.s4.getClk() == 16){
                this.s4.setEstado(color.AMBER_OFF);
            }else if(this.s4.getClk() == 22){
                this.s4.setEstado(color.RED);
                this.s4.setClk(0);
                this.s1.setEstado(color.GREEN);
            }
        }
    }

    /**
     * If active is true all the traffic lights of the junction must change to
     * blinking amber ( meaning a non - controlled junction ).
     * If active is false it resets the traffic lights cycle and started again
     * with north at green and the rest at red.
     * @param active true or false
     */
    public void amberJunction(boolean active){
        if(active){
            this.s1.setEstado(color.AMBER_ON);
            this.s2.setEstado(color.AMBER_ON);
            this.s3.setEstado(color.AMBER_ON);
            this.s4.setEstado(color.AMBER_ON);
        }else{
            this.s1.setClk(0);
            this.s2.setClk(0);
            this.s3.setClk(0);
            this.s4.setClk(0);
            this.s1.setEstado(color.GREEN);
            this.s2.setEstado(color.RED);
            this.s3.setEstado(color.RED);
            this.s4.setEstado(color.RED);
        }
    }
    @Override
    public String toString(){
        color Est1 = this.s1.getEstado();
        int Clk1 = this.s1.getClk();
        color Est2 = this.s2.getEstado();
        int Clk2 = this.s2.getClk();
        color Est3 = this.s3.getEstado();
        int Clk3 = this.s3.getClk();
        color Est4 = this.s4.getEstado();
        int Clk4 = this.s4.getClk();
        // String.valueOf( Est1);
        // String.valueOf( Est2);
        // String.valueOf( Est3);
        // String.valueOf( Est4);
        String str = new String("[NORTH: ");
        //System.out.println("[NORTH : " + Est1);
        if(this.s1.getEstado() == color.GREEN){
            str = str.concat(Est1 + " " + Clk1 + "]");
        }else if(this.s1.getEstado() == color.AMBER_OFF){
            str = str.concat("AMBER OFF " + (Clk1 - 16) + "]" );
        }else if(this.s1.getEstado() == color.AMBER_ON){
            str = str.concat("AMBER ON]");
        }else{
            str = str.concat(Est1 + "]");
        }
        str = str.concat("[SOUTH: ");
        //System.out.println("[SOUTH : " + Est2);
        if(this.s2.getEstado() == color.GREEN){
            str = str.concat(Est2 + " " + Clk2 + "]");
        }else if(this.s2.getEstado() == color.AMBER_OFF){
            str = str.concat( "AMBER OFF " + (Clk2 - 16) + "]" );
        }else if(this.s2.getEstado() == color.AMBER_ON){
            str = str.concat("AMBER ON]");
        }else{
            str = str.concat(Est2 + "]");
        }
        str = str.concat("[EAST: ");
        //System.out.println("[EAST : " + Est3);
        if(this.s3.getEstado() == color.GREEN){
            str = str.concat(Est3 + " " + Clk3 + "]");
        }else if(this.s3.getEstado() == color.AMBER_OFF){
            str = str.concat("AMBER OFF " + (Clk3 - 16) + "]" );
        }else if(this.s3.getEstado() == color.AMBER_ON){
            str = str.concat("AMBER ON]");
        }else{
            str = str.concat(Est3 + "]");
        }

        str = str.concat("[WEST: ");
        //System.out.println("[WEST : " + Est4);
        if(this.s4.getEstado() == color.GREEN){
            str = str.concat( Est4 +" " + Clk4 + "]");
        }else if(this.s4.getEstado() == color.AMBER_OFF){
            str = str.concat( "AMBER OFF " + (Clk4 - 16) + "]" );
        }else if(this.s4.getEstado() == color.AMBER_ON){
            str = str.concat("AMBER ON]");
        }else{
            str = str.concat(Est4 +"]");
        }
        return str;
    }
}