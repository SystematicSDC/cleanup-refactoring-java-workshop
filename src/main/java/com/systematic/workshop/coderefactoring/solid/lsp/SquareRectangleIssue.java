package com.systematic.workshop.coderefactoring.solid.lsp;

/**
 * The most commonly used example to emphasize violation of strong behavioral subtyping
 * <p>
 * https://en.wikipedia.org/wiki/Liskov_substitution_principle
 */
public class SquareRectangleIssue {

    static class Rectangle {
        double width;
        double height;

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        double getArea() {
            return width * height;
        }

    }

    static class Square extends Rectangle {
        public void setWidth(double width) {
            this.width = width;
            this.height = this.width;
        }

        public void setHeight(double height) {
            this.height = height;
            this.width = this.height;
        }
    }

    class Board {
        void draw() {
            Rectangle firstRectangle = drawRectangle();
            firstRectangle.setHeight(3);
            firstRectangle.setWidth(5);
            Double firstArea = firstRectangle.getArea(); // WHAT IS RETURNED HERE?

            Rectangle secondRectangle = drawAnotherRectangle();
            secondRectangle.setHeight(3);
            secondRectangle.setWidth(5);
            Double secondArea = secondRectangle.getArea(); // WHAT IS RETURNED HERE?

            assert firstArea.equals(secondArea);
        }

        Rectangle drawRectangle() {
            return new Rectangle();
        }

        Rectangle drawAnotherRectangle() {
            return new Square();
        }
    }

}
