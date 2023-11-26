package br.com.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.projeto.bo.ClienteBO;
import br.com.projeto.model.Cliente;

@Controller
@RequestMapping("/users")
public class ClienteController {
	
	@Autowired
	private ClienteBO bo;
	
	
	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("user", new Cliente());
		return new ModelAndView("/user/form", model);
		
		
	}
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String salva(@Valid @ModelAttribute Cliente user) {
		bo.insert(user);
		return "user/form";
		
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(ModelMap model) {
		model.addAttribute("users", bo.lista());
		return new ModelAndView("/user/list", model);
	}
		
	
	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("user", bo.searchID(id));
		return new ModelAndView("/user/form", model);
	
	}
	
	@RequestMapping(value = "/desativar/{id}", method = RequestMethod.GET)
	public String inativa(@PathVariable("id") Long id) {
		Cliente user = bo.searchID(id);
		bo.desativar(user);
		return "redirect:/users";
	}
	
	@RequestMapping(value = "/ativar/{id}", method = RequestMethod.GET)
	public String ativar(@PathVariable("id") Long id) {
		Cliente user = bo.searchID(id);
		bo.ativar(user);
		return "redirect:/users";
	}
	
	
	
}

