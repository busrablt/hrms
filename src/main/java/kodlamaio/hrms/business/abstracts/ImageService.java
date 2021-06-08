package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	Result add(Image image, MultipartFile imageFile);
	Result update(Image image);
	Result delete(int id);
	DataResult<Image> getByUserId(int userId);	
	DataResult<List<Image>> getAll();

}
