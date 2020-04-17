package com.cmpy.group.example.repo;


import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepo {
    ;

    Worker findByTeamIdAndUserId(String teamId, String userId);

    ;
}
