package kodlamaio.hrms.core.verification;

import java.util.UUID;

public class CodeGenarator {
	public static String sendVerificationCode() {
	    UUID uuid = UUID.randomUUID();
	    String code= uuid.toString().split("-")[0];
		return code;
	}

}
