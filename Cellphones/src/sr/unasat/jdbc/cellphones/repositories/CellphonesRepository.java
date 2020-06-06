package sr.unasat.jdbc.cellphones.repositories;

import sr.unasat.jdbc.cellphones.entities.Cellphones;
import sr.unasat.jdbc.cellphones.entities.Klant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CellphonesRepository {
    private Connection connection;
    public CellphonesRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("De driver is geregistreerd!");

            String URL = "C:\\Users\\Admin\\Documents\\Database Opdrachten"; //adres van database
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

    public List<Cellphones> findAllRecords() {
        List<Cellphones> cellphonesList = new ArrayList<Cellphones>();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String sql = "SELECT *\n" +
                    "FROM cellshop.cellphones\n" +
                    "JOIN cellshop.klant\n" +
                    "ON KLANT_ID = KLANT_ID;";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String merk = rs.getString("merk");
                String model = rs.getString("model");
                String processor = rs.getString("processor");
                String battery = rs.getString("battery");
                String ram = rs.getString("ram");
                String prijs = rs.getString("prijs");

                int klantId = rs.getInt("kid");
                String klantVoorNaam = rs.getString("kvoornaam");
                String klantAchterNaam = rs.getString("kachternaam");
                String klantAdres = rs.getString("kadres");
                String klantTelefoonnummer = rs.getString("ktelefoonnummer");
                String klantEmailadres = rs.getString("kemailadres");
                Klant klant = new Klant(klantId, klantVoorNaam, klantAchterNaam, klantAdres, klantTelefoonnummer, klantEmailadres);

                cellphonesList.add(new Cellphones(id, merk, model, processor, battery, ram, prijs, klant));
        }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return cellphonesList;
    }

    public Cellphones findOneRecord(String cpmerk, String cpmodel) {
        Cellphones cellphones = null;
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT *\n" +
                    "FROM cellshop.cellphones\n" +
                    "WHERE MERK =? AND MODEL =?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpmerk);
            stmt.setString(2, cpmodel);
            ResultSet rs = stmt.executeQuery();
            System.out.println("resultset: " + rs);
            //STEP 5: Extract data from result set
            if (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String merk = rs.getString("merk");
                String model = rs.getString("model");
                String processor = rs.getString("model");
                String battery = rs.getString("model");
                String ram = rs.getString("model");
                String prijs = rs.getString("prijs");


                int klantId = rs.getInt("kid");
                String klantVoorNaam = rs.getString("kvoornaam");
                String klantAchterNaam = rs.getString("kachternaam");
                String klantAdres = rs.getString("kadres");
                String klantTelefoonnummer = rs.getString("ktelefoonnummer");
                String klantEmailadres = rs.getString("kemailadres");
                Klant klant = new Klant(klantId, klantVoorNaam, klantAchterNaam, klantAdres, klantTelefoonnummer, klantEmailadres);

                cellphones = new Cellphones(id, merk, model, processor, battery, ram, prijs, klant);
            }
            rs.close();


        } catch (SQLException e) {

        } finally {

        }
        return cellphones;
    }

    public int updateOneRecord(Cellphones cp) {
        PreparedStatement stmt = null;
        int result = 0;
        try {
            String sql = "";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cp.getmerk());//wat we hierin zetten hangt af van wat we in die string sql zetten
            stmt.setInt(2, cp.getKlant().getId());
            stmt.setInt(3, cp.getId());
            result = stmt.executeUpdate();
            System.out.println("resultset: " + result);

        } catch (SQLException e) {

        } finally {

        }
        return result;
    }

}
