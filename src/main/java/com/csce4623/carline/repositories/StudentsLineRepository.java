package com.csce4623.carline.repositories;

  import com.csce4623.carline.models.LineStudent;
  import com.csce4623.carline.models.Student;
  import org.springframework.data.mongodb.repository.MongoRepository;
  import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentsLineRepository extends MongoRepository<LineStudent, String>{
    LineStudent findBy_id(String _id);
}
