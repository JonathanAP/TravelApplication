package fi.hh.finalproject.web;

import java.util.List;
/*import java.util.Map;*/

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.jdbc.core.JdbcTemplate;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.finalproject.domain.CategoryRepository;
import fi.hh.finalproject.domain.Destination;
import fi.hh.finalproject.domain.DestinationRepository;
/*import fi.hh.finalproject.domain.TravelRepository;*/

@Controller
public class TravelController {
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/ //used for jdbc database connection
	
	@Autowired
	private DestinationRepository  drepository;
	
	@Autowired 
	private CategoryRepository crepository;
	
	@Autowired
	
	//mapping for the web layer test
	@RequestMapping(value="/")
	public @ResponseBody String webLayerTesting() {
		return "Travel application test";
	}
	
	//RESTful service, showing all destinations
	@RequestMapping(value="/destinations", method=RequestMethod.GET)
	public @ResponseBody List<Destination> destinationlistRest() {
		return (List<Destination>) drepository.findAll();
	} 
	
	//RESTful service, searching a destination with its id
	@RequestMapping(value="/destination/{id}", method=RequestMethod.GET)
	public @ResponseBody Destination findDestinationRest(@PathVariable("id") Long destinationId) {
		return drepository.findOne(destinationId);
	}
	
	//RESTful service, deleting destination with its id
	@RequestMapping(value="/destination/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody List<Destination> destinationRest(@PathVariable("id") Long destinationId) {
		drepository.delete(destinationId);
		return (List<Destination>) drepository.findAll();
	}
	
	//showing destinations, outcommented versions to demonstrate jdbc database connection
	@RequestMapping(value="/destinationlist", method=RequestMethod.GET)
	public String showDestinations(Model model) {
		/*List<Map<String, Object>> destinations = jdbcTemplate.queryForList("select destinationName, province, mainAttraction,rating,category from destination");*/
		model.addAttribute("destination", drepository.findAll() /*destinations*/); 
		return "destinationlist";
	}
	
	//adding destination
	@RequestMapping(value="/add")
	public String addDestination(Model model) {
		model.addAttribute("destination", new Destination());
		model.addAttribute("categories", crepository.findAll());
		return "adddestination";
	}
	
	//saving new destination
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveDestination(Destination destination) {
		drepository.save(destination);
		return "redirect:destinationlist";
	}
	
	//deleting destinations
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteDestination(@PathVariable("id")Long id, Model model) {
		drepository.delete(id);
		return "redirect:../destinationlist";
	}
	
	//editing destination
	@RequestMapping(value="/edit/{id}")
	public String editDestination(@PathVariable("id") Long destinationId, Model model) {
		model.addAttribute("destination", drepository.findOne(destinationId));
		model.addAttribute("categories", crepository.findAll());
		return "editdestination";
	}
	
	
	//authentication
	@RequestMapping(value="/login")
	public String userLogin() {
		return "login";
	}

}
