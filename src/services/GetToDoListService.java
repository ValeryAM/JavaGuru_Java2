package services;

import db.Database;
import domain.Affair;

import java.util.List;

public class GetToDoListService {

    private Database database;

    public GetToDoListService(Database database) {
        this.database = database;
    }

    public List<Affair> getAllAffairs() {
        return database.getAllAffairs();
    }
}
