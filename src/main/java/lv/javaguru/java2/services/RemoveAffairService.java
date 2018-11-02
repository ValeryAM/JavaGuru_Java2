package lv.javaguru.java2.services;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;

import java.util.Optional;

public class RemoveAffairService {

    private AffairRepository database;

    public RemoveAffairService(AffairRepository database) {
        this.database = database;
    }

    public boolean remove(String title) {
        Optional<Affair> foundAffair = database.findAffairByTitle(title);
        if (foundAffair.isPresent()) {
            Affair affair = foundAffair.get();
            return database.removeAffair(affair);
        } else {
            return false;
        }
    }
}
