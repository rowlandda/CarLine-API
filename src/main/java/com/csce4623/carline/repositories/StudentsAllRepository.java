package com.csce4623.carline.repositories;

  import com.csce4623.carline.models.Student;
  import org.springframework.data.mongodb.repository.MongoRepository;
  import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentsAllRepository extends MongoRepository<Student, String>{
    Student findBy_id(String _id);
}
