package br.com.design.patterns.creational.singleton.config;

public class ConfigurationManager {
    private static volatile ConfigurationManager instance;
    private String configuration;

    private ConfigurationManager() {
        configuration = "Default configuration";
    }

    public static ConfigurationManager getInstance() {
        if(instance == null) {
            synchronized (ConfigurationManager.class) {
                if(instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}

class Application {
    public static void main(String[] args) {
        ConfigurationManager config = ConfigurationManager.getInstance();
        System.out.println("Configuration: " + config.getConfiguration());
        config.setConfiguration("Updated configuration");
        System.out.println("Configuration: " + config.getConfiguration());
    }
}
