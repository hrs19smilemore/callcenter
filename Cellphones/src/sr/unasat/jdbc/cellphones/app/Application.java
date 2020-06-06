package sr.unasat.jdbc.cellphones.app;

import sr.unasat.jdbc.cellphones.entities.Cellphones;
import sr.unasat.jdbc.cellphones.entities.Klant;
import sr.unasat.jdbc.cellphones.repositories.CellphonesRepository;
import sr.unasat.jdbc.cellphones.repositories.KlantRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        KlantRepository klantRepo = new KlantRepository();
        List<Klant> klantList = klantRepo.findAllRecords();
        for (Klant klant : klantList) {
            System.out.println(klant);
        }

        CellphonesRepository cpRepo = new CellphonesRepository();
        List<Cellphones> cellphonesList = cpRepo.findAllRecords();
        for (Cellphones cellphones : cellphonesList) {
            System.out.println(cellphones);
        }

/*        Persoon person = new Persoon(4);
        persoonRepo.deleteOneRecord(person);*/

//        int pk = persoonRepo.insertOneRecord(new Persoon("Ellen"));

//        ContactInformatieRepository ci = new ContactInformatieRepository();
//        ContactInformatie recordFound = ci.findOneRecord(1234, "Manjastraat 10");
//        System.out.println("single record: " + ci);
//
//        recordFound.setTelefoonNummer(8888);
//        recordFound.getPersoon().setId(4);
//        ci.updateOneRecord(recordFound);
//
//        System.out.println(ci.findAllRecords());


    }


}
