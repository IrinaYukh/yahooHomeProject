package ru.stqa.selenium.model;

import java.util.Objects;

public class Row
{
    private String data;
    private String open;
    private String high;
    private String low;
    private String close;
    private String adjClose;
    private String volume;

    public Row(String data, String open, String high, String low, String close, String adjClose, String volume) {
        this.data = data;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjClose = adjClose;
        this.volume = volume;
    }

    public Row setOpen(String open) {
        this.open = open;
        return this;
    }

    public Row setHigh(String high) {
        this.high = high;
        return this;
    }

    public Row setLow(String low) {
        this.low = low;
        return this;
    }

    public Row setClose(String close) {
        this.close = close;
        return this;
    }

    public Row setAdjClose(String adjClose) {
        this.adjClose = adjClose;
        return this;
    }

    public Row setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public Row setData(String data) {
        this.data = data;
        return this;
    }

    public String getData() {

        return data;
    }

    public String getOpen() {
        return open;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getClose() {
        return close;
    }

    public String getAdjClose() {
        return adjClose;
    }

    public String getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(data, row.data) &&
                Objects.equals(open, row.open) &&
                Objects.equals(high, row.high) &&
                Objects.equals(low, row.low) &&
                Objects.equals(close, row.close) &&
                Objects.equals(adjClose, row.adjClose) &&
                Objects.equals(volume, row.volume);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, open, high, low, close, adjClose, volume);
    }

    @Override
    public String toString() {
        return "Row{" +
                "data='" + data + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", adjClose='" + adjClose + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
