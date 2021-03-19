package oi.kowalczyk.advanced_todo_app.adapter;

import oi.kowalczyk.advanced_todo_app.model.Project;
import oi.kowalczyk.advanced_todo_app.model.ProjectRepository;
import oi.kowalczyk.advanced_todo_app.model.TaskGroup;
import oi.kowalczyk.advanced_todo_app.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();
}
