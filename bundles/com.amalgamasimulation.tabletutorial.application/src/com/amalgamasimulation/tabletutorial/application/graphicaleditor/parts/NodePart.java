package com.amalgamasimulation.tabletutorial.application.graphicaleditor.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.amalgamasimulation.graphicaleditor.parts.AbstractNodePart;
import com.amalgamasimulation.tabletutorial.application.utils.AppData;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.Node;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;

public class NodePart extends AbstractNodePart<Node, Scenario> {
	
	@Override
	public EStructuralFeature getNameFeature() {
		return DatamodelPackage.Literals.NODE__NAME;
	}

	@Override
	public EStructuralFeature getXStructuralFeature() {
			return DatamodelPackage.Literals.NODE__X;
	}

	@Override
	public EStructuralFeature getYStructuralFeature() {
			return DatamodelPackage.Literals.NODE__Y;
	}

	@Override
	public EStructuralFeature getZStructuralFeature() {
		return null;
	}

	@Override
	public EStructuralFeature getContainerStructuralFeature() {
		return DatamodelPackage.Literals.NODE__SCENARIO;
	}
	
	@Override
	public String getNewObjectName(EObject container, EObject eObject) {
		return AppData.messages.obj_NODE;
	}
	
}

