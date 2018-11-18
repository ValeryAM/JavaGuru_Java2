package lv.javaguru.java2.db;

import lv.javaguru.java2.domain.Affair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryDatabase implements AffairRepository {

    private List<Affair> affairs = new ArrayList<>();

    @Override
    public void save(Affair affair) {
        affairs.add(affair);
    }

    @Override
    public Optional<Affair> findAffairByTitle(String title) {
        for (Affair affair : affairs) {
            if (affair.getTitle().equals(title)) {
                return Optional.of(affair);
            }
        }
        return Optional.empty();
/*
        return affairs.stream()
                .filter(a -> a.getTitle().equals(title))
                .findFirst(); */
    }

    @Override
    public boolean removeAffair(Affair affair) {
        return affairs.remove(affair);
    }

    @Override
    public List<Affair> getAllAffairs() {
        return new ArrayList<>(affairs);
    }
}
