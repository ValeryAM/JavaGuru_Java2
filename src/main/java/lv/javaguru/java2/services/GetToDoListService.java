package lv.javaguru.java2.services;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;

import java.util.List;

public class GetToDoListService {

    private AffairRepository database;

    public GetToDoListService(AffairRepository database) {
        this.database = database;
    }

    public List<Affair> getAllAffairs() {
        return database.getAllAffairs();
    }
}
