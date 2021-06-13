package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

@CrossOrigin
@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	private ImageService imageService;
	private UserService userService;
	
	@Autowired
	public ImageController(ImageService imageService, UserService userService) {
		super();
		this.imageService = imageService;
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		User user = this.userService.getById(id).getData();
		Image image = new Image();
		image.setUser(user);
		return this.imageService.add(image, imageFile);
		
	}

}
