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
InicioSesion iniciarSesion = new InicioSesion()

//Elementos que pueden cambiar y se repiten muchas veces
TestObject spiner = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/SppinerLoadPage')

// Definir el usuario actual (puedes cambiarlo dinámicamente según tu caso de prueba)
String usuario = "Solicitante2PruebasCO"
// Definir los valores esperados (los mismos que se ingresaron en el formulario)
String vinEsperado = "64687651"
String marcaEsperada = "Docker benz - 2020"
String numeroParteEsperado = "654658"
String descripcionEsperada = "motor"
String cantidadEsperada = "4"
String estadoEsperado = "Sin revisar"

// Definir el valor del select según el usuario
String valorSelect = (usuario == "Solicitante2PruebasCO") ? "3" : "86"

WebUI.openBrowser('')

WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')

WebUI.maximizeWindow()

iniciarSesion.inicioSesionDinamico(usuario)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Solicitudes'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Crear Solicitud'), 5)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Crear Solicitud'))

WebUI.waitForElementNotVisible(spiner, 30)

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Realizar pedido'), 30)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Realizar pedido'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/select_Seleccione.                         _4685bc'), 30)

WebUI.waitForElementClickable(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/select_Seleccione.                         _4685bc'), 5)

WebUI.selectOptionByValue(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/select_Seleccione.                         _4685bc'), 
    valorSelect, true)

WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_VIN (se recomienda ingresar este valo_33dc7e'), vinEsperado)

WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Marca versin y modelo_marcaPedido'), marcaEsperada)

WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Nmero de parte_numeroParte'), numeroParteEsperado)

WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Descripcin parte_descripcionParte'), descripcionEsperada)

WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Cantidad_cantidadPartes'), cantidadEsperada)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Generar solicitud'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/div_Solicitud creadaLa solicitud se ha crea_ad8639'), 30)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Aceptar'))

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
WebUI.verifyMatch(vinActual, vinEsperado, false)
WebUI.verifyMatch(marcaActual, marcaEsperada, false)
WebUI.verifyMatch(numeroParteActual, numeroParteEsperado, false)
WebUI.verifyMatch(descripcionActual, descripcionEsperada, false)
WebUI.verifyMatch(cantidadActual, cantidadEsperada, false)
WebUI.verifyMatch(estadoActual, estadoEsperado, false)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Cerrar_Detalles'))

WebUI.waitForElementNotVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/Detalles_modal'), 30)

iniciarSesion.cerrarSesion()

WebUI.closeBrowser()