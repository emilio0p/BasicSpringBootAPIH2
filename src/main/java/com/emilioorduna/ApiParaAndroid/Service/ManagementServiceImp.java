package com.emilioorduna.ApiParaAndroid.Service;

import com.emilioorduna.ApiParaAndroid.Persistence.Proyecto;
import com.emilioorduna.ApiParaAndroid.Persistence.ProyectoRepositoryI;
import com.emilioorduna.ApiParaAndroid.Persistence.Usuario;
import com.emilioorduna.ApiParaAndroid.Persistence.UsuarioRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagementServiceImp implements ManagementServiceI{

    @Autowired
    private ProyectoRepositoryI proyectRepo;

    @Autowired
    private UsuarioRepositoryI usuarioRepo;

    @Override
    public List<Proyecto> searchAllProyects() {
        return proyectRepo.findAll();
    }

    @Override
    public Optional<Proyecto> searchProyectById(Long id) {
        Optional<Proyecto> optionalProject = proyectRepo.findById(id);
        return optionalProject;
    }

    @Override
    public void insertarProyecto(Proyecto proyecto) {
        proyectRepo.save(proyecto);
    }

    @Override
    public void eliminarProyecto(Long projectId) {
        Optional<Proyecto> optionalProject = proyectRepo.findById(projectId);
        optionalProject.ifPresent(proyecto -> proyectRepo.delete(proyecto));
    }

    @Override
    public void editarProyecto(Proyecto p) {
        // Verificar si el proyecto existe
        Optional<Proyecto> optionalProject = proyectRepo.findById(p.getId());
        if (optionalProject.isPresent()) {
            // El proyecto existe, actualizarlo
            proyectRepo.save(p);
        }
    }

    @Override
    public boolean autenticarUser(String nick, String pass) {
        Usuario user = usuarioRepo.findByNick(nick);
        return user!=null && user.getContrasena().equals(pass);
    }


}
