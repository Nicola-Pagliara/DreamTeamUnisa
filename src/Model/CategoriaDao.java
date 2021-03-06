package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    public static List<Categoria> getAllCategoria() {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Categoria> categorie = new ArrayList<Categoria>();
            PreparedStatement ps = con.prepareStatement("select Id_category,category_name,cat_description,img_category from Category");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String descripton = rs.getString(3);
                String pathimg = rs.getString(4);
                categorie.add(new Categoria(id, nome, descripton, pathimg));
            }
            return categorie;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doDelete(int idCategoria) {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Categoria> categorie = new ArrayList<Categoria>();
            PreparedStatement ps = con.prepareStatement("delete  from Category where Id_category=?");
            ps.setInt(1, idCategoria);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("errore nella cancellazione");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int doSave(String nomeCategoria) {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Categoria> categorie = new ArrayList<Categoria>();
            PreparedStatement ps = con.prepareStatement("insert into Category ('category_name') values(?)");
            ps.setString(1, nomeCategoria);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("errore inserimento");
            }
            ps = con.prepareStatement("select id_category from Category order by id_category desc ");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int num = rs.getInt(1);
            return num;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public static List<Integer> doFindProdottoConIdCategoria(int idTmp){
        try(Connection con = ConPool.getConnection()){
            ArrayList<Integer> categorieId = new ArrayList<Integer>();
            PreparedStatement ps = con.prepareStatement("select P.Id_product\n\" + \n" +
                    "\t\t\t\t\t\t\t\"from Product as P join CategoryProd as C on P.Id_product=C.Id_prod\n\" + \n" +
                    "\t\t\t\t\t\t\t\"where C.Id_Cat=?;");
            ps.setInt(1, idTmp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int num=rs.getInt(1);
                categorieId.add(num);
            }
            return categorieId;
        } catch (SQLException e) {
            throw new RuntimeException("Errore");
        }
    }*/

    public static List<Categoria> doFindNotInCategorie(int idTmp) {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Categoria> categorie = new ArrayList<Categoria>();
            PreparedStatement ps = con.prepareStatement("select *\n" +
                    "from Category \n" +
                    "where Category.Id_category not in(select CP.Id_Cat\n" +
                    "from Product as P join CategoryProd AS CP on P.Id_product=CP.Id_prod\n" +
                    "where P.Id_product=?)");
            ps.setInt(1, idTmp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int num = rs.getInt(1);
                String nome = rs.getString(2);
                Categoria categoria = new Categoria(num, nome);
                categorie.add(categoria);
            }
            return categorie;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Prodotto> doGetNotInProdotti(int idTmp) {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
            PreparedStatement ps = con.prepareStatement("select Product.Id_product,Product.name_product\n" +
                    "from Product \n" +
                    "where Product.Id_product not in(select CP1.Id_prod from Category as C join CategoryProd as CP1 on C.Id_category=CP1.Id_Cat where C.Id_category=?);");
            ps.setInt(1, idTmp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String numIdprodotto = rs.getString(1);
                String nomeProdotto = rs.getString(2);
                Prodotto prodotto = new Prodotto(numIdprodotto, nomeProdotto, 0, null, null);
                prodotti.add(prodotto);
            }
            return prodotti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int doGetLastId() throws SQLException {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT Category.Id_category FROM Category ORDER BY Id_category DESC limit 0,1;");
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDeleteByID(int id_cat) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Category WHERE Id_category=?;");
            ps.setInt(1, id_cat);
            if (ps.executeUpdate() != 1)
                throw new RuntimeException("errore nella cancellazione");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Categoria doFindByID(int id_cat) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT DISTINCT Id_category,category_name,cat_description,img_category FROM Category where Id_category=?;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String desc = rs.getString(3);
                String image = rs.getString(4);
                return new Categoria(id_cat, name, desc, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<Prodotto> doFindProdByCatId(int id_cat) {
        ArrayList<Prodotto> products = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT name_product,qty_product,Id_product FROM Product,CategoryProd where Product.Id_product=Id_prod and Id_Cat=?");
            ps.setInt(1, id_cat);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                int qty=rs.getInt(2);
                int id=rs.getInt(3);
                Prodotto prod = new Prodotto(name,qty,id);
                products.add(prod);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;

    }
}





