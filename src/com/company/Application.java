package com.company;


public class Application implements Comparable<Application> {
    static final String DEFAULT_APP_VERSION = "LATEST";
    static final String DEFAULT_APP_ADRESS = "voidapp.com/";
    static final String DEFAULT_PROTOCOL = "https";
    private final String appAddres = DEFAULT_APP_ADRESS;
    private final String appProtocolAddress = DEFAULT_PROTOCOL;
    public String appName;
    public Double appValue;
    String appVersion = DEFAULT_APP_VERSION;


    public Application(String appName, String appVersion, Double appValue) {
        this.appName = appName;
        this.appVersion = appVersion;
        this.appValue = appValue;
    }

    public Double getAppValue() {
        return this.appValue;
    }


    @Override
    public String toString() {
        return "Application{" +
                "appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Application o) {
        int result = this.appName.compareTo(o.appName);
        if (result == 0) {
            return this.appVersion.compareTo(o.appVersion);
        }
        return result;
    }
}
