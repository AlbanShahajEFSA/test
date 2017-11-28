package tse_validator;

import report_validator.ReportError;

public class TooManyCasesError implements ReportError {

	private String rowId;
	public TooManyCasesError(String rowId) {
		this.rowId = rowId;
	}
	
	@Override
	public ErrorType getTypeOfError() {
		return ErrorType.ERROR;
	}

	@Override
	public String getErrorMessage() {
		return "Number of specified cases is greater than number of declared cases";
	}

	@Override
	public String getInvolvedRowsIdsMessage() {
		return rowId;
	}

	@Override
	public String getCorrectExample() {
		return null;
	}

	@Override
	public String getErroneousValue() {
		return null;
	}

}
