package com.centime.tasks.fullnameservice.model;

import javax.validation.constraints.NotBlank;

public class FullName {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "SurName is mandatory")
    private String surName;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }
}
