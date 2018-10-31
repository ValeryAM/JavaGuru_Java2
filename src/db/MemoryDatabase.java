package db;

import domain.Affair;
import domain.AffairStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryDatabase implements Database {

    private List<Affair> affairs = new ArrayList<>();

    @Override
    public void addAffair(Affair affair) {
        affairs.add(affair);
    }

    @Override
    public Optional<Affair> findAffairByTitle(String title) {
        for (Affair affair : affairs) {
            if (affair.getAffairTitle().equals(title)) {
                return Optional.of(affair);
            }
        }
        return Optional.empty();
/*
        return affairs.stream()
                .filter(a -> a.getAffairTitle().equals(title))
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
