package lv.javaguru.java2.services.get;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetToDoListService {

    private AffairRepository database;

    public GetToDoListService(AffairRepository database) {
        this.database = database;
    }

    public List<Affair> getAllAffairs() {
        return database.getAllAffairs();
    }
}
