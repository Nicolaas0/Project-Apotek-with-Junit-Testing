/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectapotek.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import projectapotek.Helper.Helper;
import projectapotek.Model.MainModel;
import projectapotek.Query.MainQuery;

/**
 *
 * @author nicol
 */
public class MainController extends BaseController {

    MainQuery query = new MainQuery();
    Helper helper = new Helper();

    public boolean create(MainModel model) throws ParseException { //untuk create 
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, model.getName());
        map.put(2, model.getType());
        map.put(3, model.getStock());
        map.put(4, model.getPrice());
        map.put(5, model.getExpired_date());

        String sql;
        sql = this.query.create;

        return this.preparedStatement(map, sql);
    }

    public boolean submit(MainModel model) throws ParseException { //untuk create
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, model.getName());
        map.put(2, model.getAddress());
        map.put(3, model.getId_obat());
        map.put(4, model.getProduct_Name());
        map.put(5, model.getTotalq());
        map.put(6, model.getTotalp());

        String sql;
        sql = this.query.submit;
        return this.preparedStatement(map, sql);

    }

    public ResultSet get() {
        String sql = this.query.get;
        return this.get(sql);
    }

    public ResultSet getorder() {
        String sql = this.query.getorder;
        return this.getorder(sql);
    }

    public ResultSet showById(String id) {
        String sql = this.query.showById;

        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);

        return this.getWithParameter(map, sql);
    }

    public ResultSet showByName(String name) {
        String sql = this.query.showByName;

        Map<Integer, Object> map = new HashMap<>();
        map.put(1, helper.parseLikeQuery(name));

        return this.getWithParameter(map, sql);
    }

    public boolean update(String id, MainModel model) throws ParseException { //untuk update

        Map<Integer, Object> map = new HashMap<>();
        map.put(1, model.getName());
        map.put(2, model.getType());
        map.put(3, model.getStock());
        map.put(4, model.getPrice());
        map.put(5, model.getExpired_date());
        map.put(6, id);

        String sql;
        sql = this.query.update;

        return this.preparedStatement(map, sql);
    }

    public Boolean delete(String id) throws ParseException {  //untuk delete
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);
        String sql = this.query.delete;

        return this.preparedStatement(map, sql);
    }

    public Boolean deleteorderdetails(String id) throws ParseException {  //untuk delete
        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);
        String sql = this.query.deleteorderdetails;

        return this.preparedStatement(map, sql);
    }

    public String login(MainModel model, String type) throws SQLException {
        String sql = this.query.login;

        Map<Integer, Object> map = new HashMap<>();
        map.put(1, model.username);
        map.put(2, model.password);

        ResultSet rs = getWithParameter(map, sql);

        if (rs.next()) {
            type = rs.getString("type");
            if (type.equals("U")) {
                return "U";
            } else {
                return "A";
            }
        }
        return "invalid";

    }

    public String searchByName(String name) throws ParseException, SQLException {
        String sql = this.query.showByName;

        Map<Integer, Object> map = new HashMap<>();
        map.put(1, name);

        ResultSet rs = this.getWithParameter(map, sql);
        if (rs.next()) {
            name = rs.getString("name");
            return name;
        }
        return "Not found in the Database";
    }

    public int searchById(int id) throws ParseException, SQLException {
        String sql = this.query.showById;

        Map<Integer, Object> map = new HashMap<>();
        map.put(1, id);

        ResultSet rs = this.getWithParameter(map, sql);
        if (rs.next()) {
            id = rs.getInt(id);
            return id;
        }
        return 0;
    }
    }


