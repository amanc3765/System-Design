package com.system.tinyurl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.tinyurl.model.URL;

public interface URLRepository extends JpaRepository<URL,Long>{

}
