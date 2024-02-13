package com.emilioorduna.ApiParaAndroid.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepositoryI extends JpaRepository<Proyecto,Long> {
}
