package lv.javaguru.java2.services.remove;

import lv.javaguru.java2.db.AffairRepository;
import lv.javaguru.java2.domain.Affair;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
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
