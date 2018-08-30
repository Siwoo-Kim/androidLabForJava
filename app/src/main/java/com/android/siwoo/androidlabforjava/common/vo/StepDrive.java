package com.android.siwoo.androidlabforjava.common.vo;


/*
    Immutable Class
*/
public class StepDrive{
    private final String title;
    private final String type;
    private final String date;

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    private StepDrive(Builder builder) {
        this.title = builder.title;
        this.type = builder.type;
        this.date = builder.date;
    }

    public static class Builder {

        private String title;
        private String type;
        private String date;
        Builder title(String title) {
            this.title = title;
            return this;
        }

        Builder type(String type) {
            this.type = type;
            return this;
        }

        Builder date(String date) {
            this.date = date;
            return this;
        }

        StepDrive build() {
            return new StepDrive(this);
        }

    }
    @Override
    public String toString() {
        return "StepDrive{" +
                "title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
