package reto3_domingo3_11.reto3_visual;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMessage implements Serializable{
    @Autowired
    private InterfaceMessage crud2;
    
    public List<Message> getAll(){
        return (List<Message>) crud2.findAll();
    }
    public Optional <Message> getMessage(int id){
        return crud2.findById(id);
    }
    
    public Message save(Message message){
        return crud2.save(message);
    }
    public void delete(Message message){
        crud2.delete(message);
    }
}
