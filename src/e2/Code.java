package e2;

public class Code {

    /**
     * Determines whether a keypad is valid . To do this , it must be a rectangle and
     * the numbers must follow the alphanumeric sequence indicated . If the array
     * (or any of its subarrays ) is null it will be returned false .
     * @param keypad The keypad to be analyzed .
     * @return true if it is valid , false otherwise .
     */
    public static boolean isKeypadValid(char[][] keypad){
        boolean unoOK = false;
        boolean dosOK = false;
        boolean tresOK = false;
        boolean OK;
        if(keypad == null){
            return false;
        }
        if((keypad[0][0] == '1')) {
            unoOK = true;
        }
        for(int i = 0; i <= keypad.length-2; i++){
            if((keypad[i] == null) || (keypad[i+1] == null) ){
                return false;
            }
            if(keypad[i].length != keypad[i+1].length){
                return false;
            }else{
                dosOK = true;
            }
        }
        for(int i = 0; i <= keypad.length-1; i++){
            for(int j = 0; j <= keypad[i].length-1; j++){
                if( (i == keypad.length-1) && (j == keypad[i].length-1) ){
                    return true;
                }
                else if(j == keypad[i].length-1){
                    if ( ( (int)keypad[i+1][j] == (((int)keypad[i][j]) + 1) ) || ((int)keypad[i+1][0] == (((int)keypad[i][j]) + 1)) ){
                        tresOK = true;
                    }else{
                        tresOK = false;
                    }
                    if((int)keypad[i][j] == 48){
                        if(((int)keypad[i+1][j] == 65) || ((int)keypad[i+1][0] == 65) ){
                            tresOK = true;
                        }
                    }
                    if((((int)keypad[i][j] > 48 ) && ((int)keypad[i][j] <= 57)) && ( ((int)keypad[i+1][j] == 48) || ((int)keypad[i+1][0] == 48) )){
                        tresOK = true;
                    }
                }else if(i == keypad.length-1){
                    if ( ( (int)keypad[i][j+1] == (((int)keypad[i][j]) + 1) ) || ((int)keypad[0][j+1] == (((int)keypad[i][j]) + 1)) ){
                        tresOK = true;
                    }else{
                        tresOK = false;
                    }
                    if((int)keypad[i][j] == 48){
                        if(((int)keypad[i][j+1] == 65) || ((int)keypad[0][j+1] == 65) ){
                            tresOK = true;
                        }
                    }
                    if((((int)keypad[i][j] > 48 ) && ((int)keypad[i][j] <= 57)) && ( ((int)keypad[i][j+1] == 48) || ((int)keypad[0][j+1] == 48) ) ){
                        tresOK = true;
                    }
                }
                else{
                    if (((int)keypad[i][j] + 1 == (int)keypad[i][j+1]) || ((int)keypad[i][j] + 1 == (int)keypad[i+1][j])){
                        tresOK = true;
                    }else{
                        tresOK = false;
                    }
                    if((int)keypad[i][j] == 48){
                        if(((int)keypad[i][j+1] == 65) || ((int)keypad[i+1][j] == 65) ){
                            tresOK = true;
                        }
                    }
                    if( ((int)keypad[i][j] > 48 && (int)keypad[i][j] <= 57) && ((int)keypad[i][j+1] == 48) || ((int)keypad[i+1][j] == 48)) {
                        tresOK = true;
                    }
                }
                if(!tresOK){
                    return false;
                }
            }
        }
        if(unoOK && dosOK && tresOK){
            OK = true;
        }else{
            OK = false;
        }
        return OK;
    }


    /**
     * Checks if an array of movements is valid when obtaining a key on a keypad .
     * An array of movements is valid if it is formed by Strings that only have the
     * four capital letters U, D, L and R. If the array of Strings or any of the
     * Strings is null it will be returned false .
     * @param movements Array of Strings representing movements .
     * @return true if it is valid , false otherwise .
     */
    public static boolean areMovementsValid(String[] movements){
        if(movements == null){ return false;}
        int i = 0;
        int j = 0;
        while(i <= (movements.length-1)){
            if((movements[i] == null)){
                return false;
            }
            while(j <= (movements[i].length() - 1)){
                if((movements[i].charAt(j) != 'U') && (movements[i].charAt(j) != 'D') && (movements[i].charAt(j) != 'L') && (movements[i].charAt(j) != 'R')){
                    return false;
                }
                else j++;
            }
            j = 0;
            i++;
        }
        return true;
    }


    /**
     * Given a keypad and an array of movements , it returns a String with the code
     * resulting from applying the movements on the keypad .
     * @param keypad alphanumeric keypad .
     * @param movements Array with the different movements to be made for each
    number of the key .
     * @return Resulting code .
     * @throws IllegalArgumentException if the keypad of the movements are invalid .
     */
    public static String obtainCode(char[][] keypad, String[] movements){
        int x=0, y=0;
        char posAct;
        String codigo = "";
        if(areMovementsValid(movements) && isKeypadValid(keypad)){
            for(int i = 0; i <= movements.length - 1; i++){
                for(int j = 0; j <= movements[i].length() - 1; j++){
                    if(keypad.length == 1 && keypad[0].length == 1 ){   //Vector unidad
                        y = 0;
                        x = 0;
                    }else{
                        if(keypad.length == 1){                         //vector fila
                            if(y == 0){
                                if(movements[i].charAt(j) == 'R'){
                                    y = y+1;
                                }
                            }else if(y == keypad[0].length-1){
                                if(movements[i].charAt(j) == 'L'){
                                    y = y-1;
                                }
                            }
                            else{
                                if(movements[i].charAt(j) == 'L'){
                                    y = y-1;
                                }else if(movements[i].charAt(j) == 'R'){
                                    y = y+1;
                                }
                            }
                        }else if(keypad[0].length == 1){                      //vector columna
                            if(x == 0 && y == 0){
                                if(movements[i].charAt(j) == 'D'){
                                    x = x+1;
                                }
                            }else if(x == keypad.length-1 && y == 0){
                                if(movements[i].charAt(j) == 'U'){
                                    x = x-1;
                                }
                            }
                            else{
                                if(movements[i].charAt(j) == 'U'){
                                    x = x-1;
                                }else if(movements[i].charAt(j) == 'D'){
                                    x = x+1;
                                }
                            }
                        }else{                                                  //Matrix
                            if(x == 0 && y == 0){                       //esquina superior izquierda
                                if(movements[i].charAt(j) == 'D'){
                                    x = x+1;
                                }else if(movements[i].charAt(j) == 'R'){
                                    y = y+1;
                                }
                            }else if(x == 0 && y == keypad[0].length-1 ){   //esquina superior derecha
                                if(movements[i].charAt(j) == 'D'){
                                    x = x+1;
                                }else if(movements[i].charAt(j) == 'L'){
                                    y = y-1;
                                }
                            }else if(x == keypad.length-1 && y == 0 ){        //esquina inferior izquierda
                                if(movements[i].charAt(j) == 'U'){
                                    x = x-1;
                                }else if(movements[i].charAt(j) == 'R'){
                                    y = y+1;
                                }
                            }else if(x == keypad.length-1 && y == keypad[keypad.length-1].length-1 ){   //esquina inferior derecha
                                if(movements[i].charAt(j) == 'U'){
                                    x = x-1;
                                }else if(movements[i].charAt(j) == 'L'){
                                    y = y-1;
                                }
                            }else{
                                if(x == 0){                                         //Borde superior
                                    if(movements[i].charAt(j) == 'D'){
                                        x = x+1;
                                    }else if(movements[i].charAt(j) == 'L'){
                                        y = y-1;
                                    }else if(movements[i].charAt(j) == 'R'){
                                        y = y+1;
                                    }
                                } else if(x == keypad.length-1){                    //Borde inferior
                                    if(movements[i].charAt(j) == 'R'){
                                        y = y+1;
                                    }else if(movements[i].charAt(j) == 'U'){
                                        x = x-1;
                                    }else if(movements[i].charAt(j) == 'L'){
                                        y = y-1;
                                    }
                                }else if(y == 0){                                   //Borde izquierdo
                                    if(movements[i].charAt(j) == 'R'){
                                        y = y+1;
                                    }else if(movements[i].charAt(j) == 'U'){
                                        x = x-1;
                                    }else if(movements[i].charAt(j) == 'D'){
                                        x = x+1;
                                    }
                                }else if(y == keypad[0].length-1){              //Borde derecho
                                    if(movements[i].charAt(j) == 'D'){
                                        x = x+1;
                                    }else if(movements[i].charAt(j) == 'L'){
                                        y = y-1;
                                    }else if(movements[i].charAt(j) == 'U'){
                                        x = x-1;
                                    }
                                }else{
                                    if(movements[i].charAt(j) == 'D'){
                                        x = x+1;
                                    }else if(movements[i].charAt(j) == 'L'){
                                        y = y-1;
                                    }else if(movements[i].charAt(j) == 'U'){
                                        x = x-1;
                                    } else if(movements[i].charAt(j) == 'R'){
                                        y = y+1;
                                    }
                                }
                            }
                        }
                    }
                }
                posAct = keypad[x][y];
                codigo = codigo.concat(String.valueOf(posAct));
            }
        }
        else{
            throw new IllegalArgumentException();
        }
        return codigo;
    }
}