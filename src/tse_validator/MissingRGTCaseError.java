package tse_validator;

import java.util.Arrays;
import java.util.Collection;

import report_validator.ReportError;

public class MissingRGTCaseError implements ReportError {

	private String rowId;
	public MissingRGTCaseError(String rowId) {
		this.rowId = rowId;
	}
	
	@Override
	public ErrorType getTypeOfError() {
		return ErrorType.ERROR;
	}

	@Override
	public String getErrorMessage() {
		return "No case was specified for random genotyping record";
	}

	@Override
	public Collection<String> getInvolvedRowsIdsMessage() {
		return Arrays.asList(rowId);
	}

	@Override
	public String getCorrectExample() {
		return null;
	}

	@Override
	public Collection<String> getErroneousValues() {
		return null;
	}

}