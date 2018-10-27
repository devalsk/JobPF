package com.example.devsk.jobpf;

import android.os.Parcel;
import android.os.Parcelable;

public class Project {


    private  String img;
    private  String nameProject;
    private  String desc;
    private  String author;
    private  String gitRepository;
    private  String contactEmail;
    private  String contactGit;

    public Project(String img, String nameProject, String desc, String author, String gitRepository, String contactEmail, String contactGit) {
        this.img = img;
        this.nameProject = nameProject;
        this.desc = desc;
        this.author = author;
        this.gitRepository = gitRepository;
        this.contactEmail = contactEmail;
        this.contactGit = contactGit;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {

        return author;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public void setGitRepository(String gitRepository) {
        this.gitRepository = gitRepository;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactGit(String contactGit) {
        this.contactGit = contactGit;
    }

    public String getImg() {

        return img;
    }

    public String getNameProject() {
        return nameProject;
    }

    public String getGitRepository() {
        return gitRepository;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactGit() {
        return contactGit;
    }

    public String getDesc() {


        return desc;

    }

    public void setStr(String str) {
        this.nameProject = str;
    }

    public String getStr() {

        return nameProject;
    }


}