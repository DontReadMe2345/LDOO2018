/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author zenit
 */
public class TaconMadre {
    private static TaconMadre instance = null;
    
    protected TaconMadre() {
    }
    
    public static TaconMadre getInstance () {
        if (instance==null){
            instance = new TaconMadre();
        }
        return instance;
    }

    public String taconm() {
        String mensaje = " Los mejores Tacos del Pais ";
        return mensaje;
   }
}