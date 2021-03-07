/**
 * 
 */
package br.com.nutribox.nbx.resource.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @author edy
 *
 */
public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<FieldMessage>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void setList(List<FieldMessage> erros) {
		this.erros = erros;
	}

	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName,message));
	}
	
}
