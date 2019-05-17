package com.rmi.shared;

import java.io.Serializable;

public class СustomerCard  implements Serializable {
    private static final long serialVersionUID = 1L;


    private String name;
    private String god;
    private String FIO;
    private String machina;
    private String Email;
    private String komentarii;
    private String nomerkyzova;





    public СustomerCard( String name,String god,String FIO,String machina,String Email,String komentarii,String nomerkyzova)
    {
        super();
        this.name=name;
        this.god=god;
        this.FIO=FIO;
        this.machina=machina;
        this.Email=Email;
        this.komentarii=komentarii;
        this.nomerkyzova=nomerkyzova;

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setGod(String god) {
        this.god = god;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setMachina(String machina) {
        this.machina = machina;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setKomentarii(String komentarii) {
        this.komentarii = komentarii;
    }

    public void setNomerkyzova(String nomerkyzova) {
        this.nomerkyzova = nomerkyzova;
    }
    public String getName() {
        return name;
    }

    public String getGod() {
        return god;
    }

    public String getFIO() {
        return FIO;
    }

    public String getMachina() {
        return machina;
    }

    public String getEmail() {
        return Email;
    }

    public String getKomentarii() {
        return komentarii;
    }

    public String getNomerkyzova() {
        return nomerkyzova;
    }
}
