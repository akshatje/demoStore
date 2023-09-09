package com.pocStore.demoStore.Repositories;

import com.pocStore.demoStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
