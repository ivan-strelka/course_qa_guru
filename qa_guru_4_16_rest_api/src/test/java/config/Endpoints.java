package config;

public enum Endpoints {

    USERS("/users"), REGISTER("/register"), LOGIN("/login"), API("/api");
    String path;

    Endpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String addPath(String additionalPath) {
        return path + additionalPath;
    }


}
