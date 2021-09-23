package config;

public enum RabbitConfigs {
    PERF_TEST("perfTest.properties"),
    PERF_TEST_MULTI("perfTestMulti.properties");

    private String config;

    RabbitConfigs(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
}
