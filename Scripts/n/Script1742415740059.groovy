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

//Inicializar class
InicioSesion iniciarSesionObj = new InicioSesion()

//valores
String vinEsperado = "64687651"
String marcaEsperada = "Docker benz - 2020"
String numeroParteEsperado = "654658"
String descripcionEsperada = "motor"
String cantidadEsperada = "4"

WebUI.openBrowser('')

WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')

WebUI.maximizeWindow()

iniciarSesionObj.inicioSesionDinamico("GrowixCO")

WebUI.click(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders null/a_Growix Finder'))

WebUI.click(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders null/a_Solicitudes Recibidas'))

WebUI.waitForElementClickable(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/enlace_VerMasDetalles_PrimeraFila'), 5)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/enlace_VerMasDetalles_PrimeraFila'))

WebUI.setText(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders null/input_motor_form-control precio'), 
    '10000')

WebUI.setText(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders 1.0 - 2025.03.21/input_fecha-entrega'), '2025-04-01')

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
WebUI.verifyMatch(vinActual, vinEsperado, false)
WebUI.verifyMatch(marcaActual, marcaEsperada, false)
WebUI.verifyMatch(numeroParteActual, numeroParteEsperado, false)
WebUI.verifyMatch(descripcionActual, descripcionEsperada, false)
WebUI.verifyMatch(cantidadActual, cantidadEsperada, false)

WebUI.click(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders null/button_Actualizar'))

WebUI.click(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders null/div_Actualizacin exitosaEl registro se ha a_e00db1'))

WebUI.click(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders null/button_Aceptar'))

WebUI.click(findTestObject('Object Repository/Gestion_Pedido1/Page_Sales Orders null/button_Cerrar'))

