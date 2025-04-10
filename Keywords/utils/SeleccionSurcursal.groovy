package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class SeleccionSurcursal {
	
	/**
	 * Selecciona sucursales según el modo especificado
	 * @param modoSeleccion "primera", "todas" o "ninguna"
	 */
	static void seleccionarSucursales(String modoSeleccion) {
		// Obtener elementos
		def selectElement = findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/select_Surcursal')
		def inputControl = findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Sucursal del Cliente_sucursal-ts-control')
		
		// Abrir el dropdown
		WebUI.click(inputControl)
		
		// Obtener opciones (esperar 10 segundos si es necesario)
		List<WebElement> options = WebUiCommonHelper.findWebElements(selectElement, 10)
		
		switch(modoSeleccion.toLowerCase()) {
			case "primera":
				if (options.size() > 1) {
					WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/div_' + options[1].getText()))
				}
				break
				
			case "todas":
				for (int i = 1; i < options.size(); i++) {
					WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/div_' + options[i].getText()))
				}
				break
				
			case "ninguna":
				// No selecciona ninguna sucursal (queda "No Aplica")
				break
				
			default:
				println "Modo de selección no reconocido: ${modoSeleccion}"
		}
	}
}
