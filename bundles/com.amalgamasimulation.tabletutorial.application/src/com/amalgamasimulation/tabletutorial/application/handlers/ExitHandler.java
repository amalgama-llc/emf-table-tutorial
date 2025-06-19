package com.amalgamasimulation.tabletutorial.application.handlers;

import jakarta.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.swt.SWT;

import com.amalgamasimulation.tabletutorial.application.states.AppState;
import com.amalgamasimulation.tabletutorial.application.utils.MessageBoxFactory;
import com.amalgamasimulation.tabletutorial.application.utils.Messages;

import org.eclipse.swt.widgets.Shell;

public class ExitHandler {

    @Inject
    @Translation
    private Messages messages;

    @Inject
    private AppState appState;
    
    @Execute
	public void execute(IWorkbench workbench, Shell shell) {
		// ask if user wants to close the app
		if (SWT.OK != MessageBoxFactory.createMessageBox(shell,
				SWT.ICON_QUESTION | SWT.OK | SWT.CANCEL | SWT.APPLICATION_MODAL, "",
				messages.message_create_new_scenario)) {
			return;
		}
		// ask if user wants the (changed) scenario to be saved
		if (appState.ensureCurrentScenarioIsSaved(shell)) {
			workbench.close();
		}
	}
}

