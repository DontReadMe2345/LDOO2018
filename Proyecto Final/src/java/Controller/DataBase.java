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
public class DataBase {
    private final String url = "jdbc:derby://localhost:1527/SuperBase1";
    
    public Pedir Pedir(){
        return new Pedir();
    }
    
    public Add Add(){
        return new Add();
    }
    
    public Refresh Refresh(){
 
        return new Refresh();
    }
        
    public String getUrl() {
    return url;
    }
}
