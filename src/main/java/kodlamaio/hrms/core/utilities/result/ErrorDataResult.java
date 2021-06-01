package kodlamaio.hrms.core.utilities.result;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data) {
		super(data,false);
	}
	
	public ErrorDataResult(T data,String message ) {
		super(data, false, message);
	}
	
	public ErrorDataResult( ) {
		super(null, true);
	}
	public ErrorDataResult(String message ) {
		super(null, true, message);
	}
	

}
