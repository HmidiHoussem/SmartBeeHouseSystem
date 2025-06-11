public class FermeDAO {
    public static List<Ferme> getAllFermes() {
        List<Ferme> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ferme");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ferme f = new Ferme(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getInt("fermier_id")
                );
                list.add(f);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static void addFerme(Ferme f) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO ferme (nom, fermier_id) VALUES (?, ?)");
            ps.setString(1, f.getNom());
            ps.setInt(2, f.getFermierId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void updateFerme(Ferme f) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE ferme SET nom=?, fermier_id=? WHERE id=?");
            ps.setString(1, f.getNom());
            ps.setInt(2, f.getFermierId());
            ps.setInt(3, f.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void deleteFerme(int id) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ferme WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
