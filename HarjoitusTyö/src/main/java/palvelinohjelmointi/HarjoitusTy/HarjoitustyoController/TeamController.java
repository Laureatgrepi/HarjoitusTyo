package palvelinohjelmointi.HarjoitusTy.HarjoitustyoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.SportRepository;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.Team;
import palvelinohjelmointi.HarjoitusTy.HarjoitusTyDomain.TeamRepository;

@Controller
public class TeamController {
	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private SportRepository sRepo;
	
	
	@GetMapping("/teams")
	public String showTeams (Model model) {
		model.addAttribute("teams",teamRepo.findAll() );
		return "teamList";
	}
	@GetMapping("/addTeam")
	public String addTeam(Model model) {
		model.addAttribute("team", new Team());
		model.addAttribute("sports", sRepo.findAll());
		return "addTeam";
		
	}
	@PostMapping("/saveTeam")
	public String saveTeam(Team team) {
		teamRepo.save(team);
		return "redirect:teams";
		
	}
	@GetMapping("/deleteTeam/{id}")
	public String deleteTeam(@PathVariable("id") Long teamId, Model model) {
		teamRepo.deleteById(teamId);
		return "redirect:../teams";

	}
	
	
}
