package com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor;

public interface Entity {
    default String getId() {
        return null;
    }
}
