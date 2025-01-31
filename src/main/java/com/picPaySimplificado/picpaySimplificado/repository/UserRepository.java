package com.picPaySimplificado.picpaySimplificado.repository;

import com.picPaySimplificado.picpaySimplificado.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
