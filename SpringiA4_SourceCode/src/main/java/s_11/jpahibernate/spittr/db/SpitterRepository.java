package s_11.jpahibernate.spittr.db;

import s_11.jpahibernate.spittr.domain.Spitter;

import java.util.List;


/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository {

  long count();

  Spitter save(Spitter spitter);

  Spitter findOne(long id);

  Spitter findByUsername(String username);

  List<Spitter> findAll();

}
