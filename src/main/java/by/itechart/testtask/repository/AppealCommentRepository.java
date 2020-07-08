package by.itechart.testtask.repository;

import by.itechart.testtask.model.AppealComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealCommentRepository extends CrudRepository<AppealComment, Long> {
}
