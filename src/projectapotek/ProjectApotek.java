/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotek;

import projectapotek.Connection.SQLCon;
import projectapotek.Frame.Adminframe;
import projectapotek.Frame.Loginframe;
import projectapotek.Frame.Mainframe;
import projectapotek.Frame.Welcomeframe;

/**
 *
 * @author nicol
 */
public class ProjectApotek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SQLCon con = new SQLCon();
        System.out.println(con.open());
        
        Welcomeframe frame = new Welcomeframe();
        frame.show();
    }
    
}
