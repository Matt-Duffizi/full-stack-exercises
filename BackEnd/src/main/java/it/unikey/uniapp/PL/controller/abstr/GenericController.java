package it.unikey.uniapp.PL.controller.abstr;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController<R> {
    /**
     * ############
     * #  CREATE  #
     * ############
     */
    ResponseEntity<R> post(R rest);

    /**
     * ##########
     * #  READ  #
     * ##########
     */
    ResponseEntity<R> getById(Integer id);

    ResponseEntity<List<R>> getAll();

    /**
     * ############
     * #  UPDATE  #
     * ############
     */
    ResponseEntity<R> put(R rest);

    /**
     * ############
     * #  DELETE  #
     * ############
     */
    ResponseEntity<Void> deleteById(Integer id);

}