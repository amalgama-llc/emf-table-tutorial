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

import com.amalgamasimulation.tabletutorial.application.states.AppState;
import com.amalgamasimulation.tabletutorial.application.utils.Messages;


public class NewHandler {

    @Inject
    private AppState appState;

    @Inject
    @Translation
    private Messages messages;

	@CanExecute
	private boolean canExecute() {
		return appState.isEditor();
	}

    @Execute
    public void execute(IEventBroker eventBroker,
                        Shell shell, 
						MApplication app, EPartService partService, EModelService modelService, MWindow mainWindow) {
   		// ask if user wants the (changed) scenario to be saved
		if (appState.ensureCurrentScenarioIsSaved(shell)) {
			appState.createAndSetNewScenario();
		}
    }
}

