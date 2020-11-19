/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import projectapotek.Connection.SQLCon;
import projectapotek.Controller.BaseController;
import projectapotek.Controller.MainController;
import projectapotek.Helper.Helper;
import projectapotek.Model.MainModel;

/**
 *
 * @author Nicolaas'
 */
public class ApotekTesting {

    SQLCon db = new SQLCon();
    Connection con;

    public ApotekTesting() {
    }

    @Before
    public void setUp() {
        db = new SQLCon();
        con = (Connection) db.open();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void connectionTest() {
        Connection exp = (Connection) db.open();
        assertEquals(exp != null, true);
        System.out.println("Connection Success");
    }

    @Test
    public void loginAdminTest() throws SQLException {
        MainModel model = new MainModel();
        BaseController bc = new BaseController();
        MainController mc = new MainController();
        //SET VALUE UNTUK USERNAME DAN PASS
        String username = "admin";
        String password = "admin";

        model.setUsername(username);
        model.setPassword(password);
        //VALUE MASUK KE CONTROLLER
        String status = null;
        String val = mc.login(model, status);
        //EKSPEKTASI VALUE RETURN = A / ADMIN
        String exp = "A";

        assertEquals(exp, val);
    }

    @Test
    public void loginUserTest() throws SQLException {
        MainModel model = new MainModel();
        BaseController bc = new BaseController();
        MainController mc = new MainController();

        String username = "user";
        String password = "user";

        model.setUsername(username);
        model.setPassword(password);

        String status = null;
        String val = mc.login(model, status);
        String exp = "U";

        assertEquals(exp, val);
    }

    @Test
    public void createDataObatTest() throws ParseException {
        MainModel model = new MainModel();
        MainController mc = new MainController();
        //SET MODEL UNTUK DI INPUT
        String name = "Sarung tangan biasa";
        String type = "Perlengkapan";
        String stock = "40";
        String price = "5000";
        String exp_date = "2020-01-05";

        model.setName(name);
        model.setType(type);
        model.setStock(stock);
        model.setPrice(price);
        model.setExpired_date(exp_date);
        //MEMASUKAN MODEL YANG SDH DI SET KE MAIN CONTROLLER UNTUK DI PROSES
        Boolean create = mc.create(model);
        Boolean exp = Boolean.TRUE;

        try {
            assertEquals(exp, create);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test
    public void createOrderTest() throws ParseException {
        MainModel model = new MainModel();
        MainController mc = new MainController();
        //SET MODEL UNTUK DI INPUT
        String name = "Huju";
        String address = "Jl. Permata Indah no.3";
        String id_obat = "4";
        String product_name = "Obat Pilek";
        String totalq = "1";
        String totalp = "5000";

        model.setName(name);
        model.setAddress(address);
        model.setId_obat(id_obat);
        model.setProduct_Name(product_name);
        model.setTotalq(totalq);
        model.setTotalp(totalp);
        //MEMASUKAN MODEL YANG SDH DI SET KE MAIN CONTROLLER UNTUK DI PROSES
        Boolean submit = mc.submit(model);
        Boolean exp = Boolean.TRUE;

        try {
            assertEquals(exp, submit);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Test
    public void updateProdukObatTest() throws ParseException {
        MainModel model = new MainModel();
        MainController mc = new MainController();

        String id = "14";
        String name = "Yakultt";
        String type = "Suplemen";
        String stock = "100";
        String price = "5000";
        String expired = "2020-11-10";

        model.setName(name);
        model.setType(type);
        model.setStock(stock);
        model.setPrice(price);
        model.setExpired_date(expired);

        Boolean update = mc.update(id, model);
        Boolean exp = Boolean.TRUE;

        try {
            assertEquals(exp, update);
        } catch (Exception e) {
            e.getMessage();
        }
    }

//    @Test
//    public void deleteProdukObatTest() throws ParseException {
//        MainController mc = new MainController();
//        MainModel model = new MainModel();
//
//        String id = "23"; //MENENTUKAN ID YANG MAU DI DELETE
//
//        Boolean delete = mc.delete(id); //MEMASUKAN NILAI ID KE MC UNTUK DI JALANKAN
//        Boolean exp = Boolean.TRUE;
//
//        try {
//            assertEquals(exp, delete);
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }
//
//    @Test
//    public void deleteOrderTest() throws ParseException {
//        MainController mc = new MainController();
//        MainModel model = new MainModel();
//
//        String id = "7";
//
//        Boolean delete = mc.deleteorderdetails(id);
//        Boolean exp = Boolean.TRUE;
//
//        try {
//            assertEquals(exp, delete);
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }

    @Test
    public void searchByNameTest() throws ParseException, SQLException {
        MainController mc = new MainController();

        String name = "Kain Kasa"; //Memasukan value / nama barang
        String val = mc.searchByName(name); //value di masukan ke mc untuk di jalankan ke query

        try {
            assertEquals(name, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchByIdTest() throws ParseException, SQLException {
        MainController mc = new MainController();

        int id = 1;
        int val = mc.searchById(id);

        try {
            assertEquals(id, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
