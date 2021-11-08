package reto3_domingo3_11.reto3_visual;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioBike implements Serializable{
    @Autowired
    private InterfaceBike crud; 
    
    public List<Bike> getAll(){
        return (List<Bike>) crud.findAll();
    }

    public Optional<Bike> getBike(int id){ //¿cómo funciona el Optional?
        return crud.findById(id);
    }
    
    public Bike save(Bike Bike){
        return crud.save(Bike);
    }
    
    public void delete(Bike Bike){
        crud.delete(Bike);
    }
    
}
