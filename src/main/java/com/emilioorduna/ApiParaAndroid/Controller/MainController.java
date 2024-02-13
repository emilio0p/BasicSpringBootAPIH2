package com.emilioorduna.ApiParaAndroid.Controller;

import com.emilioorduna.ApiParaAndroid.Persistence.Proyecto;
import com.emilioorduna.ApiParaAndroid.Persistence.Usuario;
import com.emilioorduna.ApiParaAndroid.Service.ManagementServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private ManagementServiceI managementServiceI;

    @GetMapping
    public List<Proyecto> getAllProyects(){
        return managementServiceI.searchAllProyects();
    }

    @GetMapping("/{id}")
    public Optional<Proyecto> getProyectById(@PathVariable Long id){
        return managementServiceI.searchProyectById(id);
    }

    @PostMapping("/insert")
    public void insertPro(@RequestBody Proyecto p){
        p.setId(null);
        managementServiceI.insertarProyecto(p);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Usuario u){

        return u!=null && managementServiceI.autenticarUser(u.getNick(), u.getContrasena());
    }

    @DeleteMapping("/delete{id}")
    public void deletePro(@PathVariable Long id){
        managementServiceI.eliminarProyecto(id);
    }

    @PutMapping("/edit{id}")
    public void editarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyecto.setId(id); // Establecer el ID del proyecto con el valor proporcionado en la ruta
        managementServiceI.editarProyecto(proyecto);
    }
}
