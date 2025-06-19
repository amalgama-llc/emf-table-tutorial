package com.amalgamasimulation.tabletutorial.application.parts.editor;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.amalgamasimulation.desktop.properties.PropertyPart;
import com.amalgamasimulation.tabletutorial.application.pages.PeoplePage;
import com.amalgamasimulation.tabletutorial.application.utils.Messages;

import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

public class PropertiesPart extends PropertyPart {

	@Inject
	@Translation
	private Messages messages;
	
	@Override
	protected boolean isPartVisible() {
		return true;
	}

	@Override
	public void setPartVisible(boolean visible) {
	}
	
	@Override
	protected void setLabeledSelectedObject(IObservableValue<EObject> labeledSelectedObject, Object selectedObject) {
	}

	@Override
	protected boolean isAlternativeTitle() {
		return true;
	}

	@Override
	protected EStructuralFeature getLabeledField() {
		return null;
	}

	@Override
	protected void registerPages() {
		registerPage(new PeoplePage(), messages.tab_general);
	}
	
	@Override
	protected String getPropertyTypeTitle(Object selectedObject) {
		return "";
	}
	
	@Override
	protected void changePropertyPerspective(Object selectedObject) {
		
	}
	
	@PreDestroy
	public void preDestroy() {
		eventBroker.unsubscribe(propertyPerspectiveChangedEventHandler);
		eventBroker.unsubscribe(propertySelectionChangedEventHandler);
	}
}

