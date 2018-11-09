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
public class Add extends DataBase {
    
    private String query = "INSERT INTO ROOT.UNTITLED (ID, NOMBRE, APELLIDOPAT, APELLIDOMAT, CUMPLE, CORREO, CONTRASEÑA)";
    
    public String getInsertar() {
        return query;
}
    
}
