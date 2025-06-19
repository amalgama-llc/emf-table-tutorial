package com.amalgamasimulation.tabletutorial.application.graphicaleditor.handlers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.mvc.fx.parts.IVisualPart;

import com.amalgamasimulation.emf.commands.AddCommand;
import com.amalgamasimulation.graphicaleditor.factories.ContentPartFactory;
import com.amalgamasimulation.graphicaleditor.handlers.CreateObjectClickHandler;
import com.amalgamasimulation.graphicaleditor.models.ActionModel;
import com.amalgamasimulation.tabletutorial.application.utils.AppData;
import com.amalgamasimulation.desktop.ui.editor.commands.UniqNamesManager;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import javafx.scene.Node;

public class CreateObjectHandler extends CreateObjectClickHandler {
	
	@Override
	public EObject executeCreateObject(	ActionModel actionModel,
										ContentPartFactory contentPartFactory, 
										EClass eClass,
										IVisualPart<? extends Node> rootPart, IVisualPart<? extends Node> clickedPart, 
										EObject container, 
										double x,
										double y) {
		AddCommand<EObject> command = createDefaultCommand(actionModel, contentPartFactory, eClass, rootPart, clickedPart, container, x, y);
		if (eClass == DatamodelPackage.Literals.NODE) {
			command.setActionBefore(() -> {
				String id = UniqNamesManager.getInstance().generateUniqueId(container, command.getObject(), AppData.messages.obj_NODE);
				command.getObject().eSet(DatamodelPackage.Literals.NODE__ID, id);
				command.getObject().eSet(DatamodelPackage.Literals.NODE__NAME, id);
			});
		}
		command.executeInStack();
		return command.getObject();
	}
}

