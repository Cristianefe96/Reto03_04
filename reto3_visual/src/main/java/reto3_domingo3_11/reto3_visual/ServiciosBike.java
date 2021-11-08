package reto3_domingo3_11.reto3_visual;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosBike implements Serializable{
    @Autowired
    private RepositorioBike metodosCrud;
    
    public List<Bike> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Bike> getBike(int idBike){
        return metodosCrud.getBike(idBike);
    }
    public Bike save(Bike Bike){
        if(Bike.getId()==null){
            return metodosCrud.save(Bike);
        }else{
            Optional<Bike> evt=metodosCrud.getBike(Bike.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(Bike);
            }else{
            return Bike;
            }
        }
    }
    public Bike update(Bike Bike){
        if(Bike.getId()!=null){
            Optional<Bike> evt=metodosCrud.getBike(Bike.getId());
            if(!evt.isEmpty()){
                if(Bike.getName()!=null){
                    evt.get().setName(Bike.getName());
                }
                if(Bike.getBrand()!=null){
                    evt.get().setBrand(Bike.getBrand());
                }
                if(Bike.getYear()!=null){
                    evt.get().setYear(Bike.getYear());
                }
                if(Bike.getDescription()!=null){
                    evt.get().setDescription(Bike.getDescription());
                }
                if(Bike.getCategory()!=null){
                    evt.get().setCategory(Bike.getCategory());
                }
                metodosCrud.save(evt.get());
                return evt.get();
            }else{
                return Bike;
            }
        }else{
            return Bike;
        }
    }


    public boolean deleteBike(int IdBike) {
        Boolean aBoolean = getBike(IdBike).map(Bike -> {
            metodosCrud.delete(Bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}

//Integer.valueOf(x); // fails if x is null
//Optional.ofNullable(Integer.valueOf(x)).orElse(null); // NullPointerException