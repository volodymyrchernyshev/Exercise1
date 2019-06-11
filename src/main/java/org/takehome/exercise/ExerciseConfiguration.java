package org.takehome.exercise;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class ExerciseConfiguration extends Configuration {


    @NotNull
    private String password;

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }
}
