package com.example.demo;

public class Clients {
    String id, fio, shifer, type, inn, document, sernum, organ;

    public Clients(String id, String fio, String shifer, String type,
                   String inn, String document, String sernum, String organ) {
        this.id = id;
        this.fio = fio;
        this.shifer = shifer;
        this.type = type;
        this.inn = inn;
        this.document = document;
        this.sernum = sernum;
        this.organ = organ;
    }

    public String getId() {return id;}

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getShifer() {
        return shifer;
    }

    public void setShifer(String shifer) {
        this.shifer = shifer;
    }

    public String getInn() {return inn;}

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getSernum() {
        return sernum;
    }

    public void setSernum(String sernum) {
        this.sernum = sernum;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }
}
