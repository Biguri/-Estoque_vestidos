import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VestidoDAO {

    public void inserir(Vestido v) {
        String sql = "INSERT INTO vestidos(nome, tamanho, preco, foto) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getTamanho());
            stmt.setDouble(3, v.getPreco());
            stmt.setString(4, v.getFoto());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vestido> listar() {
        List<Vestido> lista = new ArrayList<>();
        String sql = "SELECT * FROM vestidos";
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vestido v = new Vestido(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("tamanho"),
                        rs.getDouble("preco"),
                        rs.getString("foto")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizar(Vestido v) {
        String sql = "UPDATE vestidos SET nome=?, tamanho=?, preco=?, foto=? WHERE id=?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, v.getNome());
            stmt.setString(2, v.getTamanho());
            stmt.setDouble(3, v.getPreco());
            stmt.setString(4, v.getFoto());
            stmt.setInt(5, v.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM vestidos WHERE id=?";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
