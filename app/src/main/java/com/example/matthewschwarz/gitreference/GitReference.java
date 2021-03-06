package com.example.matthewschwarz.gitreference;

import android.content.Context;

import java.io.InputStream;
/**
 * Created by matthewschwarz on 2/27/18.
 */

public class GitReference {
    private String command, example, explanation, section;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
