package org.tbplusc.app.talent.helper;

import java.util.ArrayList;
import java.util.List;

public class HeroBuild {
    private final String name;
    private final String description;
    private final List<String> talents;

    public HeroBuild(String name, String description, List<String> talents) {
        this.name = name;
        this.description = description;
        this.talents = new ArrayList<>(talents);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTalents() {
        return new ArrayList<>(talents);
    }

    @Override
    public String toString() {
        return name + ": " + description + "\n" + talents + "\n";
    }
}
