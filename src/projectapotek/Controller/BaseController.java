/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotek.Controller;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import projectapotek.Connection.SQLCon;
/**
 *
 * @author nicol
 */
public class BaseController {
    SQLCon koneksi = new SQLCon();
  public boolean preparedStatement (Map<Integer, Object>map,String sql){
        try {
            Connection con = (Connection) koneksi.open();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            for(Map.Entry<Integer,Object>entry:map.entrySet()){
                ps.setString(entry.getKey(),entry.getValue().toString());
            }
            
            int rows = ps.executeUpdate();
            con.close();
            return rows !=0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        
    }
  
  public ResultSet get(String sql){
      try {
           Connection con = (Connection) koneksi.open();
           Statement state =  (Statement) con.createStatement();
           ResultSet rs = state.executeQuery(sql);
           
           CachedRowSetImpl crs = new CachedRowSetImpl();
           crs.populate(rs);
           
           con.close();
           return crs;
      } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
      }
  }
  
  public ResultSet getorder(String sql){
      try {
           Connection con = (Connection) koneksi.open();
           Statement state =  (Statement) con.createStatement();
           ResultSet rs = state.executeQuery(sql);
           
           CachedRowSetImpl crs = new CachedRowSetImpl();
           crs.populate(rs);
           
           con.close();
           return crs;
      } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
      }
  }
  public ResultSet getWithParameter(Map<Integer,Object> map, String sql){
      try {
          Connection con = (Connection) koneksi.open();
          
          PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
          
          for(Map.Entry<Integer,Object>entry : map.entrySet()){
              ps.setString(entry.getKey(), entry.getValue().toString());
          }
          
          ResultSet rs = ps.executeQuery();
          
          CachedRowSetImpl crs = new CachedRowSetImpl();
          crs.populate(rs);
          
          con.close();
          
          return crs;
      } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
      }
  }
 
  }
  

  

