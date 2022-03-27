package com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.impl;

import com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.Entity;

class Picture implements Entity {

    public static final String FILE_NAME = "picture.png";

    @Override
    public String getId() {
        return FILE_NAME;
    }
}
