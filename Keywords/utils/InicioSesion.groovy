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

public class InicioSesion {

	static void inicioSesionDinamico(String nameUsuario) {
		WebUI.click(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/a_Ingresar'))
		WebUI.setText(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/input_Login_username'), nameUsuario)
		WebUI.setEncryptedText(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/input_Login_password'), 'c4HiwZztlarfDaH0rnJD6g==')
		WebUI.click(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/button_Ingresar'))

		waitForSpinnerToDisappear()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders 1.0 - 2025.03.21/img'), 30)
	}

	private static void waitForSpinnerToDisappear(int timeout = 90, int pollingInterval = 2) {
		TestObject spinner = findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/div_Ingresar_spinner')
		for (int i = 0; i < timeout; i += pollingInterval) {
			if (!WebUI.verifyElementPresent(spinner, 1, FailureHandling.OPTIONAL)) {
				return
			}
			WebUI.delay(pollingInterval)
		}
		throw new Exception("❌ El spinner no desapareció después de ${timeout} segundos")
	}
}
