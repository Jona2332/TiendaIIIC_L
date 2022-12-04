
package com.TiendaLunes.TiendaLunes.dao;

import com.TiendaLunes.TiendaLunes.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jonha
 */
public interface ClienteDAO extends CrudRepository<Cliente, Long>{
    
}
