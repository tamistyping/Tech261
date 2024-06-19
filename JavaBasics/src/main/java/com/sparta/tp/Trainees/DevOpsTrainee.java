package com.sparta.tp.Trainees;
import java.util.List;

public class DevOpsTrainee extends Trainee implements Trainable {
    private int experience;
    private List<String> certifications;
    private List<String> projects;

    // Constructor
    public DevOpsTrainee(String name, int age, String email, String phone, int experience, List<String> certifications, List<String> projects) {
        super(name, age, email, phone);
        this.experience = experience;
        this.certifications = certifications;
        this.projects = projects;
    }

    @Override
    public void train(){{
        System.out.println("Java Trainee is training");}
    }

    @Override
    public void study() {

    }
}