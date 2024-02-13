package com.emilioorduna.ApiParaAndroid.Persistence;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name="usuarios")
@Table
public class Usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nick")
    private String nick;

    @Column(name = "contrasena")
    private String contrasena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
