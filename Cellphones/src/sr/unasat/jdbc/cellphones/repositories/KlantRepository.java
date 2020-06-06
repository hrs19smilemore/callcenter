package sr.unasat.jdbc.cellphones.repositories;

import sr.unasat.jdbc.cellphones.entities.Klant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KlantRepository {
    private Connection connection;

    public KlantRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "C:\\Users\\Admin\\Documents\\Database Opdrachten";
            String USER = "root";
            String PASS = "bar7mad2";
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println(connection);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Klant> findAllRecords() {
        List<Klant> klantList = new ArrayList<Klant>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String voorNaam = rs.getString("voornaam");
                String achterNaam = rs.getString("achternaam");
                String adres = rs.getString("adres");
                String telefoonnummer = rs.getString("telefoonnummer");
                String emailadres = rs.getString("emailadres");

            /*    //Display values
               System.out.print("ID: " + id);
               System.out.print(", Age: " + naam);*/
                klantList.add(new Klant(id, voorNaam, achterNaam, adres, telefoonnummer, emailadres ));

            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return klantList;
    }

    public int insertOneRecord(Klant klant) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, klant.getVoorNaam());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

    public int deleteOneRecord(Klant klant){
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, klant.getId());
            result = stmt.executeUpdate();
            System.out.println("deleted: " + klant.getId());

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

}

