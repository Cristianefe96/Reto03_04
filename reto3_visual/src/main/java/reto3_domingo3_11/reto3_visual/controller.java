package reto3_domingo3_11.reto3_visual;

import org.springframework.web.bind.annotation.GetMapping;

public class controller {
    @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo Tutoria";
    }
    
}
