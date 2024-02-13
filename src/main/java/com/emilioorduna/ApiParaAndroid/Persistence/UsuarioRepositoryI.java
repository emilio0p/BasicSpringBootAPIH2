package com.emilioorduna.ApiParaAndroid.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryI extends JpaRepository<Usuario, Long> {
    Usuario findByNick(String nick);
}
