package com.sparta.tp.Trainees;
import java.util.List;

public class JavaTrainee extends Trainee implements Trainable {
    private int experience;
    private List<String> certifications;
    private List<String> projects;
    private String github;

    // Constructor
    public JavaTrainee(String name, int age, String email, String phone, int experience, List<String> certifications, List<String> projects, String github) {
        super(name, age, email, phone);
        this.experience = experience;
        this.certifications = certifications;
        this.projects = projects;
        this.github = github;
    }

    @Override
    public void train(){{
        System.out.println("Java Trainee is training");}
    }

    @Override
    public void study() {

    }
}

