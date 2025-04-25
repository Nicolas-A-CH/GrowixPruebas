import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import utils.InicioSesion

import org.openqa.selenium.Keys as Keys

String usuario = GlobalVariable.usuarioSolucionador
String url = GlobalVariable.Url

WebUI.openBrowser('')

WebUI.navigateToUrl(url)

WebUI.maximizeWindow()

InicioSesion.inicioSesionDinamico(usuario)

WebUI.click(findTestObject('Object Repository/Facturazion/Page_Sales Orders 1.0 - 2025.03.20/a_Growix Biller'))

WebUI.click(findTestObject('Object Repository/Facturazion/Page_Sales Orders 1.0 - 2025.03.20/a_Facturacion de Pedidos'))

WebUI.click(findTestObject('Object Repository/Facturazion/Page_Sales Orders 1.0 - 2025.03.20/i_Fecha Estado_bi bi-pencil-square text-war_b52685'))

WebUI.click(findTestObject('Object Repository/Facturazion/Page_Sales Orders 1.0 - 2025.03.20/button_Actualizar Estado a Facturado'))

WebUI.click(findTestObject('Object Repository/Facturazion/Page_Sales Orders 1.0 - 2025.03.20/button_OK'))

WebUI.click(findTestObject('Object Repository/Facturazion/Page_Sales Orders 1.0 - 2025.03.20/td_Facturado'))

