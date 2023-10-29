package ca.sheridancollege.thiarapr.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.thiarapr.Repository.ArtRepository;
import ca.sheridancollege.thiarapr.beans.Art;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class ArtController {
	private ArtRepository artRepo;
	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("art",new Art());
		return "NewFile.html";
		
	}
	@PostMapping("/")
	public String root1(@ModelAttribute Art art) {
		artRepo.addArt(art);
		return "redirect:/";
	
	}
	@GetMapping("/view")
	public String view(Model model,@ModelAttribute Art art) {
		model.addAttribute("art",artRepo.getArt());
		System.out.println(artRepo.getArt());

		
		
		
		return "view.html";
		
	}
	@GetMapping("/delete/{id}")
	public String deletePage(@PathVariable int id,Model model ) {
		artRepo.deletebyid(id);
		model.addAttribute("contact", artRepo.getArt());
		return "redirect:/view";
	}
	@GetMapping("/purchase/{id}")
	public String updatePage(@PathVariable int id,Model model, @ModelAttribute Art art) {
		artRepo.updateQuantity(id);
			model.addAttribute("art", 	artRepo.getArt());
		return "view.html";
		
	}

}
