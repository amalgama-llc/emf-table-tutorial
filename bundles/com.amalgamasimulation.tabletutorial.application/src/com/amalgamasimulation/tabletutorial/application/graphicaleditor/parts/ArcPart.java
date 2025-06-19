package com.amalgamasimulation.tabletutorial.application.graphicaleditor.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.amalgamasimulation.graphicaleditor.parts.AbstractArcPart;
import com.amalgamasimulation.tabletutorial.application.utils.AppData;
import com.amalgamasimulation.tabletutorial.datamodel.Arc;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelFactory;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.Node;
import com.amalgamasimulation.tabletutorial.datamodel.Point;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;

public class ArcPart extends AbstractArcPart<Arc, Scenario, Node, Point> {
	
	@Override
	public boolean isEndDecorationVisible() {
		return true;
	}
	
	@Override
	public EStructuralFeature getNameFeature() {
		return DatamodelPackage.Literals.ARC__NAME;
	}

	@Override
	public EStructuralFeature getArcBendpointsFeature() {
		return DatamodelPackage.Literals.ARC__POINTS;
	}

	@Override
	public EStructuralFeature getSourceNodeFeature() {
		return DatamodelPackage.Literals.ARC__SOURCE;
	}

	@Override
	public EStructuralFeature getDestNodeFeature() {
		return DatamodelPackage.Literals.ARC__DEST;
	}

	@Override
	public EStructuralFeature getNodeXFeature() {
			return DatamodelPackage.Literals.NODE__X;
	}

	@Override
	public EStructuralFeature getNodeYFeature() {
			return DatamodelPackage.Literals.NODE__Y;
	}

	@Override
	public EStructuralFeature getNodeZFeature() {
		return null;
	}

	@Override
	public EStructuralFeature getBendpointXFeature() {
			return DatamodelPackage.Literals.POINT__X;
	}

	@Override
	public EStructuralFeature getBendpointYFeature() {
			return DatamodelPackage.Literals.POINT__Y;
	}

	@Override
	public EStructuralFeature getBendpointZFeature() {
		return null;
	}

	@Override
	public Point createBendpoint() {
		return DatamodelFactory.eINSTANCE.createPoint();
	}

	@Override
	public EStructuralFeature getContainerStructuralFeature() {
		return DatamodelPackage.Literals.ARC__SCENARIO;
	}
	
	@Override
	public String getNewObjectName(EObject container, EObject eObject) {
		return AppData.messages.obj_ARC;
	}
	
}

