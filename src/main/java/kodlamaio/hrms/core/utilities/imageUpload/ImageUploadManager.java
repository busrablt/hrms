package kodlamaio.hrms.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService{

   private Cloudinary cloudinary;
	
	public ImageUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dc0mezewo",
				"api_key", "542989699223513",
				"api_secret", "-pfU-AOIvmC4TAKPMBvDEd8ZWz0"));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
      
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());

            return new SuccessDataResult<>(resultMap);

        } 
		catch (IOException e) {
            e.printStackTrace();

        }
        return new ErrorDataResult<>();
	}

}
