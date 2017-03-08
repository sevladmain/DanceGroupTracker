package ua.org.dancegrouptracker.dao;

import java.util.List;

/**
 * Created by SeVlad on 08.03.2017.
 */
public interface GenericDao  <T, PK> {
    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(PK id);

    /** Save or udate changes made to a persistent object.  */
    PK saveOrUpdate(T transientObject);

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject);

    /** Return all instances **/
    List<T> getAll();
}
