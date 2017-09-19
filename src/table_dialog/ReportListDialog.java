package table_dialog;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;

import app_config.AppPaths;
import database.TableDao;
import table_skeleton.TableRow;
import xlsx_reader.TableSchema;
import xml_config_reader.Selection;

public class ReportListDialog extends DataDialog {

	private Listener listener;
	
	public ReportListDialog(Shell parent, String title, String message) {
		super(parent, title, message, false, false, true);
	}

	@Override
	public String getSchemaSheetName() {
		return AppPaths.REPORT_SHEET;
	}

	@Override
	public Collection<TableRow> getRows(TableSchema schema, TableRow parentTable) {
		TableDao dao = new TableDao(schema);
		return dao.getAll();
	}

	@Override
	public boolean apply(TableSchema schema, Collection<TableRow> rows, TableRow selectedRow) {

		if (selectedRow == null) {
			warnUser("Error", "A report was not selected!");
			return false;
		}
		
		if (listener != null) {
			Event event = new Event();
			event.data = selectedRow;
			listener.handleEvent(event);
		}
		
		return true;
	}
	
	public void setListener(Listener listener) {
		this.listener = listener;
	}

	@Override
	public Menu createMenu() {
		return null;
	}

	@Override
	public TableRow createNewRow(TableSchema schema, Selection type) throws IOException {
		return null;
	}
}
