package services;

import db.Database;
import domain.Affair;

import java.util.Optional;

public class RemoveAffairService {

    private Database database;

    public RemoveAffairService(Database database) {
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
