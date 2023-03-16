package org;

public class Mower {

    private int x;
    private int y;
    private String orientation;
    private Garden garden;

    public Mower(int x, int y, String orientation, Garden field) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.garden = field;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
    public String getOrientation() {
        return orientation;
    }

    public Garden getGarden() {
        return garden;
    }

    @Override
    public String toString() {
        return "Mower{" +
                "x=" + x +
                ", y=" + y +
                ", orientation='" + orientation + '\'' +
                ", garden=" + garden +
                '}';
    }

    public void foward() {
        if (garden.getFieldY()>getY() && this.orientation.equals("N")) {
            setY(getY()+1);
        }
        if (getY()>0 && this.orientation.equals("S")) {
            setY(getY()-1);
        }
        if (garden.getFieldX()> getX() && this.orientation.equals("E")) {
            setX(getX()+1);
        }
        if (getX()>0 && this.orientation.equals("W")) {
            setX(getX()-1);
        }
    }

    public void turn(String sens) {
        String cardinals = "NESW";
        int indexOfCardinals = cardinals.indexOf(orientation);
        if (sens.equals("D")) {
            if (!getOrientation().equals("W")) {
                indexOfCardinals = indexOfCardinals + 1;
            } else {
                indexOfCardinals = 0;
            }
        }
        if (sens.equals("G")) {
            if (!getOrientation().equals("N")) {
                indexOfCardinals = indexOfCardinals - 1;
            } else {
                indexOfCardinals = 3;
            }
        }
        setOrientation(String.valueOf(cardinals.charAt(indexOfCardinals)));
    }

    public String execute(String instructions) {
        String[] instructionsLetter = instructions.split("");
        for (String letter: instructionsLetter) {
            if(letter.equals("A")) {
                this.foward();
            }
            this.turn(letter);
        }
        String coordinateFinalMower = String.valueOf(this.getX())+ " " + String.valueOf(this.getY()) + " " + this.getOrientation()+ " ";
        return coordinateFinalMower;
    }
}
