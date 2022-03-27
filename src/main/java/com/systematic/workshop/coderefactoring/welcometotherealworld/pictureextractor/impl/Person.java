package com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.impl;

import com.systematic.workshop.coderefactoring.welcometotherealworld.pictureextractor.Entity;

class Person implements Entity {
    @Override
    public String getId() {
        return CNPGenerator.generateRandomCnp();
    }

    static final class CNPGenerator {

        static final String MY_CNP = "1909090123456";

        private CNPGenerator() {

        }

        static String generateRandomCnp() {
            // a very "random" CNP for the sake of simplicity during the workshop
            return MY_CNP;
        }
    }
}

