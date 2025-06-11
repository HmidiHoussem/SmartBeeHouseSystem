package DAO;

import model.Fermier;
import java.sql.*;
import java.util.*;

public class FermierDAO {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/smartbee_db", "root", "");
    }

    public static List<Fermier> getAllFermiers() {
        List<Fermier> list = new ArrayList<>();
        try (Connection con = getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM fermier");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fermier f = new Fermier();
                f.setId(rs.getInt("id"));
                f.setNom(rs.getString("nom"));
                f.setEmail(rs.getString("email"));
                list.add(f);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
