package reto3_domingo3_11.reto3_visual;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCategory implements Serializable{
    @Autowired
    private InterfaceCategory crud4;
    
    public List<Category> getAll(){
        return (List<Category>) crud4.findAll();
    }
    public Optional <Category> getCategory(int id){
        return crud4.findById(id);
    }
    
    public Category save(Category Category){
        return crud4.save(Category);
    }
    public void delete(Category Category){
        crud4.delete(Category);
    }
    
}
