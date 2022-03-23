package courseController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import courseEntity.Course;
import courseService.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Course>listcourse=service.listAll();
		model.addAttribute("listcourse",listcourse);
		System.out.println("Get/");
		return "index";
	}

	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("course",new Course ());
		return "new";
	}
	@RequestMapping(value ="/save", method =RequestMethod.POST)
	public String saveCourse(@ModelAttribute("Course")Course std) {
		service.save(std);
		return "redirect:/";

	}
	@RequestMapping("/edit/(id)")
	public ModelAndView showEditCoursePage(@PathVariable(name ="id")int id) {
		ModelAndView mav =new ModelAndView("new");
		Course std =service.get(id);
		mav.addObject("course", std);
		return mav;
	}
	@RequestMapping("/delete(id)")
	public String deleteCourse(@PathVariable(name ="id")int id) {
		service.delete(id);
		return "redirect:/";

	}


}
