package com.example.projectgreenveg.controller;

public class Pegawai {
    private String nip , nama , email , password;

    public Pegawai (){}

    public Pegawai (String email, String password){
        this.nip = "NIP - 12345";
        this.nama = "Lazu";
        this.email = email;
        this.password = password;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void catatIdentitasPegawai(){
        System.out.println(
                " \n----------------------------------------------- " +
                        " \nIdentitas Pegawai Yang Sign In Saat Ini " +
                        " \nNIP         : " + this.getNip() +
                        " \nNama        : " + this.getNama() +
                        " \nEmail       : " + this.getEmail() +
                        " \nPassword    : " + this.getPassword()
        );
    }
}
