package sr.unasat.jdbc.cellphones.entities;

public class Cellphones {
    private int id;
    private String merk;
    private String model;
    private String processor;
    private String battery;
    private String ram;
    private String prijs;
    private Klant klant;

    public Cellphones(int id, String merk, String model, String processor, String battery, String ram
            , String prijs, Klant klant) {
        this.id = id;
        this.merk = merk;
        this.model = model;
        this.klant = klant;
        this.processor = processor;
        this.battery = battery;
        this.prijs = prijs;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmerk() {
        return merk;
    }

    public void setmerk() {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    @Override
    public String toString() {
        return "Cellphones{" +
                "id=" + id +
                ", merk='" + merk + '\'' +
                ", model=" + model +
                '}';
    }
}
