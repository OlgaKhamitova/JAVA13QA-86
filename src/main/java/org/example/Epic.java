package org.example;

import java.util.Arrays;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (id = 0; id < subtasks.length; id++) {
            if (Arrays.asList(subtasks).contains(query)) {
                return true;
            }
        } return false;
    }
}
