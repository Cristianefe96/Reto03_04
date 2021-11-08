package reto3_domingo3_11.reto3_visual;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategory implements Serializable{
    @Autowired
    private RepositorioCategory metodosCrud;
    
    public List<Category> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Category> getCategory(int idCategory){
        return metodosCrud.getCategory(idCategory);
    }
    
    
    public Category save(Category Category){
        if(Category.getId()==null){
            return metodosCrud.save(Category);
        }else{
            Optional<Category> evt=metodosCrud.getCategory(Category.getId());
            if(evt.isEmpty()){
            return metodosCrud.save(Category);
            }else{
                return Category;
            }
        
        
        }
    }
    public Category update(Category Category){
        if(Category.getId()!=null){
            Optional<Category>evt=metodosCrud.getCategory(Category.getId());
            if(!evt.isEmpty()){
                if(Category.getDescription()!=null){
                    evt.get().setDescription(Category.getDescription());
                }
                if(Category.getName()!=null){
                    evt.get().setName(Category.getName());
                }
                return metodosCrud.save(evt.get());
            }
        }
        return Category;
    }
    public boolean deleteCategory(int id){
        Boolean dBoolean=getCategory(id).map(Category -> {
            metodosCrud.delete(Category);
            return true;
        }).orElse(false);
        return dBoolean;
    }
    
}
