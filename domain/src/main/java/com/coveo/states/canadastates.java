package com.coveo.states;

public enum canadastates {

    CA01("AB"),
    CA02("BC"),
    CA03("MB"),
    CA04("NB"),
    CA05("NL"),
    CA07("NS"),
    CA08("ON"),
    CA09("PE"),
    CA10("QC"),
    CA11("SK"),
    CA12("YT"),
    CA13("NT"),
    CA14("NU");

    private String state;

    canadastates(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
