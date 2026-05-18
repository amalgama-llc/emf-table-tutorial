package com.amalgamasimulation.tabletutorial.datamodel.data;

import com.amalgamasimulation.ecoreutils.EcoreutilsPackage;
import com.amalgamasimulation.emf.excel.EMFExcelTransform;
import com.amalgamasimulation.timeseriesdatamodel.TimeseriesdatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.DatamodelPackage;
import com.amalgamasimulation.tabletutorial.datamodel.Scenario;

public class EMFExcelDataTransform {
	
	
	private static EMFExcelTransform<Scenario> emfExcelTransform;
	
	private static void initialize() {
		 emfExcelTransform = new EMFExcelTransform<Scenario>(DatamodelPackage.eINSTANCE.getScenario())
					.addPackage(EcoreutilsPackage.eINSTANCE)
					.addPackage(TimeseriesdatamodelPackage.eINSTANCE);
	}

	public static EMFExcelTransform<Scenario> getExcelTransform() {
		if(emfExcelTransform == null) {
			initialize();
		}
		return emfExcelTransform;
	}
}
