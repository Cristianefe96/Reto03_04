package reto3_domingo3_11.reto3_visual;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClient implements Serializable{
    @Autowired
    private InterfaceClient crud1;
    
    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
        
    }
    public Optional<Cliente> getClient(int id){
        return crud1.findById(id);
    }
    public Cliente save(Cliente client){
        return crud1.save(client);
    }
    public void delete(Cliente client){
        crud1.delete(client);
    }
    
}
