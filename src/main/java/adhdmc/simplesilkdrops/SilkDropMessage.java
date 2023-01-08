package adhdmc.simplesilkdrops;

public enum SilkDropMessage {
    NO_PERMISSION("<red>Sorry, you don't have permission to run this command!"),
    CONFIG_RELOADED("<white>[<gold>Simple Silk Drops</gold>]</white> <gray>»</gray> Simple Silk Drops config has been reloaded");
    String message;

    SilkDropMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
