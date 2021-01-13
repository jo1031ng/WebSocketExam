package com.example.websocketexam;

import androidx.annotation.NonNull;

public class Weather {
    private String contry;
    private String weader;
    private String temperature;

    public Weather() {}
    public Weather(String contry, String weader, String temperature) {
        this.contry = contry;
        this.weader = weader;
        this.temperature = temperature;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getWeader() {
        return weader;
    }

    public void setWeader(String weader) {
        this.weader = weader;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "contry='" + contry + '\'' +
                ", weader='" + weader + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
