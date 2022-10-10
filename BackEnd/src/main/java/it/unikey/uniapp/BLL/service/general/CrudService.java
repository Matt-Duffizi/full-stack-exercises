package it.unikey.uniapp.BLL.service.general;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface CrudService<D> {

    /**
     * ############
     * #  CREATE  #
     *
     * ############
     */
    D insert(D dto);

    /**
     * ##########
     * #  READ  #
     * ##########
     */
    D getById(Integer id) throws EntityNotFoundException;
    List<D> getAll();

    /**
     * ############
     * #  UPDATE  #
     * ############
     */
    D update(D dto) throws EntityNotFoundException;

    /**
     * ############
     * #  DELETE  #
     * ############
     */
    void deleteById(Integer id) throws EntityNotFoundException;

}
