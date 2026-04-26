package airport.core;

public interface Trackable {
    void trackStatus();
    void updateLocation(String location);
    String getCurrentLocation();
}
