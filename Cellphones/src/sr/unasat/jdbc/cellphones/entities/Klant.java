package sr.unasat.jdbc.cellphones.entities;

public class Klant {
    private int id;
    private String voorNaam;
    private String achterNaam;
    private String adres;
    private String telefoonnummer;
    private String emailadres;

    public Klant(int id, String voorNaam, String achterNaam, String adres, String telefoonnummer, String emailadres){
        this.id = id;
        this.voorNaam = voorNaam;
        this.achterNaam = achterNaam;
        this.adres = adres;
        this.telefoonnummer = telefoonnummer;
        this.emailadres = emailadres;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    @Override
    public String toString() {
        return "Klant{" +
                "id=" + id +
                ", voorNaam='" + voorNaam + '\'' +
                ", achterNaam='" + achterNaam +
                ", adres='" + adres +
                ", emailadres='" + emailadres +
                ", telefoonnummer='" + telefoonnummer +
                '}';
    }
}

