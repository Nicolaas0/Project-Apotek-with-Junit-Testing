/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotek.Query;

/**
 *
 * @author nicol
 */
public class MainQuery {
    public String create = "INSERT INTO produkobat (Name,Type,Stock,Price,Expired_Date)"
            +"VALUES (?,?,?,?,?)"; //admin
    public String submit = "INSERT INTO orderdetails (Name,Address,Id_obat,Product_Name,Total_Quantity,Total_Price)"
            +"VALUES (?,?,?,?,?,?)";  //user
    
    public String get = "SELECT * FROM produkobat ORDER BY Id_obat DESC";
    public String showById = "SELECT * FROM produkobat WHERE Id_obat = ?";
    public String showByName = "SELECT * FROM produkobat WHERE Name LIKE ?";
    public String update = "UPDATE produkobat SET Name = ? , Type = ? , Stock = ? , Price = ? "
            +", Expired_Date = ? WHERE Id_obat = ?";
    public String delete = "DELETE FROM produkobat WHERE Id_obat = ?";
    public String getorder = "SELECT * FROM orderdetails";
    public String login = "SELECT * FROM users WHERE username = ? AND password = ?";
    public String deleteorderdetails = "DELETE FROM orderdetails WHERE Id = ?";
}
