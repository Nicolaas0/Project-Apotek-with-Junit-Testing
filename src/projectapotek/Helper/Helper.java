/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotek.Helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

/**
 *
 * @author nicol
 */
public class Helper {
    public String getValueRows (JTable table, int index){
        return table.getValueAt(table.getSelectedRow(), index).toString();
    }
    
    public String parseLikeQuery(String query)
    {
     return "%" + query +"%";   
    }
    
     public Date parseStringToDate (String _date) throws ParseException {
      return new SimpleDateFormat("dd-MM-yyyy").parse(_date);
  }
  
  public String parseDateToString(Date _date) throws ParseException {
      DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
      return dateFormat.format(_date); 

}
}
