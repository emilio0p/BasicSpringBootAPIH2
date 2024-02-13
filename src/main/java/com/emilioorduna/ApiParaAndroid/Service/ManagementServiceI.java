package com.emilioorduna.ApiParaAndroid.Service;

import com.emilioorduna.ApiParaAndroid.Persistence.Proyecto;
import com.emilioorduna.ApiParaAndroid.Persistence.Usuario;

import java.util.List;
import java.util.Optional;

public interface ManagementServiceI {

    // Métodos `Proyecto`
    List<Proyecto> searchAllProyects();
    Optional<Proyecto> searchProyectById(Long id);
    void insertarProyecto(Proyecto proyecto);
    void eliminarProyecto(Long id);
    void editarProyecto(Proyecto p);

    // Métodos `Usuario`
    boolean autenticarUser(String nick, String pass);
}
