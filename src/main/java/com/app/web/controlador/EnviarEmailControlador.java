package com.app.web.controlador;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.web.entidad.Email;
import com.app.web.entidad.Usuario;
import com.app.web.servicio.EmailServicioImp;
import com.app.web.servicio.UsuarioServicio;

@Controller
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})

public class EnviarEmailControlador {
	
	@Autowired
	private EmailServicioImp emailServicioImp;
	@Autowired
	private UsuarioServicio usuarioServicio;
	 
	 @GetMapping("Email")
	    public String Mostrarformulario(){
	        return "EnviarEmail";
	    }
	
	 @PostMapping("/sendMail")
	 
	 public String sendMail(@RequestParam("recipient") String recipient,@RequestParam("subject") String subject, @RequestParam("msgBody") String msgBody){
		 Email email = new Email();
		 email.setRecipient(recipient);
		 email.setSubject(subject);
		 email.setMsgBody(msgBody);
		 emailServicioImp.sendSimpleMail(email);
	        return "redirect:Email";
	    }
	 @PostMapping("SendMassiveMails")
	 
	 public String sendMassiveMails(@RequestParam("subject") String subject, @RequestParam("msgBody") String msgBody) {
		 List<Usuario>listausuarios = usuarioServicio.listarusuario();
		 for (Usuario usuario : listausuarios) {
			 try {
				 sendMail(usuario.getCorreo(), subject, msgBody);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		 
		 return "redirect:/Solware2/home/ConsultarPAdmin";
	}
}
