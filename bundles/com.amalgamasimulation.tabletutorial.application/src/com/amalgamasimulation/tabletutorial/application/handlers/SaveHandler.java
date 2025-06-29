package com.amalgamasimulation.tabletutorial.application.handlers;

import jakarta.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

import com.amalgamasimulation.tabletutorial.application.states.AppState;
import com.amalgamasimulation.tabletutorial.application.utils.AppData;

public class SaveHandler {

	@Inject
	private AppData appData;

	@Inject
	private AppState appState;

	@CanExecute
	private boolean canExecute() {
		return appState.isEditor() && appState.isScenarioExist();
	}

	@Execute
	public void execute(Shell shell) {
		appState.saveScenario(shell, appData.getFilePath());
	}
}

