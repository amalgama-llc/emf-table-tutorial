package com.amalgamasimulation.tabletutorial.application.handlers;

import jakarta.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;

import com.amalgamasimulation.tabletutorial.application.scenario.ScenarioFileFormat;
import com.amalgamasimulation.tabletutorial.application.states.AppState;
import com.amalgamasimulation.tabletutorial.application.utils.Messages;
import com.amalgamasimulation.desktop.ui.dialogs.DialogUtils;

public class OpenHandler {

	@Inject
	@Translation
	private Messages messages;

	@Inject
	private AppState appState;

	@CanExecute
	private boolean canExecute() {
		return appState.isEditor();
	}

	@Execute
	public void execute(Shell shell,
						IEventBroker eventBroker, 
						MApplication app, EPartService partService, EModelService modelService, MWindow mainWindow) {
		// ask if user wants the (changed) scenario to be saved
		if (appState.ensureCurrentScenarioIsSaved(shell)) {
			DialogUtils.showOpenFileDialog(	shell,
											filePath -> appState.loadScenario(filePath),
											ScenarioFileFormat.EXCEL.filePattern);
		}
	}
}

