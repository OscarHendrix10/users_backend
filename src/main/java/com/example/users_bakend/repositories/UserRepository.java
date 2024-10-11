package com.example.users_bakend.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.users_bakend.models.UsersModel;

// This interface is a repository for the UsersModel class
@Repository
// This interface extends the CrudRepository interface 
public interface UserRepository extends CrudRepository<UsersModel, Long> {
    // This method is used to find users by status
    public abstract ArrayList<UsersModel> findByStatus(Integer status);
    
}
