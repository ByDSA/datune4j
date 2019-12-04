package es.danisales.building;

public class BuildingException extends Exception {
    public BuildingException(String msg) {
        super(msg);
    }

    public BuildingException(Exception e) {
        this(e.getMessage());

        e.printStackTrace();
    }
}
