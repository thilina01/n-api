package com.nanosl.n.module.appsession;

import com.nanosl.n.entity.AppSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSessionRepository extends JpaRepository<AppSession, String> {

}
