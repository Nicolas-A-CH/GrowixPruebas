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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.json.JsonSlurper
import internal.GlobalVariable
import utils.InicioSesion

import org.openqa.selenium.Keys as Keys

String jsonFilePath = 'D:\\Descargas\\Pruebas growix.json'

//Inicializar class
InicioSesion iniciarSesion = new InicioSesion()
String jsonText = new File(jsonFilePath).text
def jsonData = new JsonSlurper().parseText(jsonText)
List solicitudes = jsonData.'solicitudes_pendientes (3)'

//Elementos que pueden cambiar y se repiten muchas veces
TestObject spiner = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/SppinerLoadPage')

TestObject getVerMasDetallesLink(int fila) {
	String xpath = "(//a[contains(text(), 'Ver más detalles')])[${fila}]"
	TestObject link = new TestObject()
	link.addProperty('xpath', ConditionType.EQUALS, xpath)
	return link
}

// Definir el usuario actual (puedes cambiarlo dinámicamente según tu caso de prueba)
String usuario = "ClientePruebasCO"
// Definir los valores esperados (los mismos que se ingresaron en el formulario)
String estadoEsperado = "Sin revisar"

// Definir el valor del select según el usuario
String valorSelect = (usuario == "ClientePruebasCO") ? "3" : "86"

WebUI.openBrowser('')

WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')

WebUI.maximizeWindow()

iniciarSesion.inicioSesionDinamico(usuario)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Solicitudes'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Crear Solicitud'), 5)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Crear Solicitud'))

WebUI.waitForElementNotVisible(spiner, 30)

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Cargar excel'), 30)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Cargar excel'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/select_Form_Excel'), 30)

WebUI.selectOptionByValue(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/select_Form_Excel'), valorSelect, true)

WebUI.uploadFile(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/inputArchivoExcel'), 'D:\\Descargas\\Pruebas growix.xlsx')

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_ENVIAR_excel'))

WebUI.waitForElementNotVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/spinnerFormularioExcel'), 60)

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Aceptar_excel'), 30)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Aceptar_excel'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/table_Solicitudes'), 30)

WebUI.waitForElementClickable(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/enlace_VerMasDetalles_PrimeraFila'), 5)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/enlace_VerMasDetalles_PrimeraFila'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/Detalles_modal'), 30)

// Obtener los valores de la primera fila de la tabla de detalles
TestObject celdaVin = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/celda_VIN')
String vinActual = WebUI.getText(celdaVin)

TestObject celdaMarca = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/celda_Marca')
String marcaActual = WebUI.getText(celdaMarca)

TestObject celdaNumeroParte = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/celda_NumeroParte')
String numeroParteActual = WebUI.getText(celdaNumeroParte)

TestObject celdaDescripcion = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/celda_Descripcion')
String descripcionActual = WebUI.getText(celdaDescripcion)

TestObject celdaCantidad = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/celda_Cantidad')
String cantidadActual = WebUI.getText(celdaCantidad)

TestObject celdaEstado = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/celda_Estado')
String estadoActual = WebUI.getText(celdaEstado)

// Validaciones
WebUI.verifyMatch(estadoActual, estadoEsperado, false)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Cerrar_Detalles'))

WebUI.waitForElementNotVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/Detalles_modal'), 30)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/logo_Usuario'))

WebUI.waitForElementVisible(findTestObject('null'), 30)

WebUI.click(findTestObject('null'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/modal_Confirmacion_Cerrar_Sesion'), 30)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Salir'))