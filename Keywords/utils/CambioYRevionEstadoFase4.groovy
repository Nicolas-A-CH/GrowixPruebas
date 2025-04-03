package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CambioYRevionEstadoFase4 {

	static void navegarAprobadasYCambiarEstado(int valorEstado) {

		WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/a_Growix Finder'))
		WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/a_Solicitudes Aprobadas'))
		WebUI.scrollToElement(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/input_Entrega Estimada'), 5)
		WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/input_Entrega Estimada'))
		WebUI.selectOptionByValue(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/select_Seleccione.                         _05f498'),
				valorEstado.toString(), true)
		WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/button_Actualizar estado'))
		if (valorEstado == 6 ) {

			WebUI.setText(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/input_Nmero de pedido requerido_npedidoInput'),
					'133')

			WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/button_Actualizar'))
		}
		WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/button_Aceptar'))
	}

	static void verificarEstadoSolicitud(String estadoEsperado) {
		WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/a_Mis Solicitudes Growix'))
		if (estadoEsperado == "Entregado") {
			WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/a_Mis Solicitudes Cerradas'))
		} else {
			WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/a_Solicitudes Tracking'))
		}
		TestObject estadoTracking = findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/td_EstadoTracking')
		String textoEstado = WebUI.getText(estadoTracking)
		WebUI.verifyMatch(textoEstado, estadoEsperado, false)
	}
}
