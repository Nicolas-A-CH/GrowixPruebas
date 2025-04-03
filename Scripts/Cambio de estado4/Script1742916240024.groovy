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
import utils.CambioYRevionEstadoFase4
import utils.InicioSesion

import org.apache.poi.ss.usermodel.ConditionType
import org.openqa.selenium.Keys as Keys

// Definir los valores esperados (los mismos que se ingresaron en el formulario)
String usuario = "GrowixCO"
String vinEsperado = GlobalVariable.vinEsperado
String marcaEsperada = GlobalVariable.marcaEsperada
String numeroParteEsperado = GlobalVariable.numeroParteEsperado
String descripcionEsperada = GlobalVariable.descripcionEsperada
String cantidadEsperada = GlobalVariable.cantidadEsperada
String precio = GlobalVariable.precio

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')

InicioSesion.inicioSesionDinamico(usuario)

WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/a_Growix Finder'))

WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/a_Solicitudes Aprobadas'))

// Obtener los valores de la primera fila de la tabla de detalles
TestObject celdaVin = findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/td_VIN')
String vinActual = WebUI.getText(celdaVin)

TestObject celdaMarca = findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/td_Marca')
String marcaActual = WebUI.getText(celdaMarca)

TestObject celdaNumeroParte = findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/td_NumeroParte')
String numeroParteActual = WebUI.getText(celdaNumeroParte)

TestObject celdaDescripcion = findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/td_Descripcion')
String descripcionActual = WebUI.getText(celdaDescripcion)

TestObject celdaCantidad = findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/td_Cantidad')
String cantidadActual = WebUI.getText(celdaCantidad)

TestObject numeroPedido = findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/td_NumPedido')

//TestObject checkPremium = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/input_40,000.00_form-check-input pedido-premium')
//boolean esPremium = WebUI.getAttribute(checkPremium, "checked") == "true" // Si está marcado, devuelve "true"

// Validaciones
WebUI.verifyMatch(vinActual, vinEsperado, false)
WebUI.verifyMatch(marcaActual, marcaEsperada, false)
WebUI.verifyMatch(numeroParteActual, numeroParteEsperado, false)
WebUI.verifyMatch(descripcionActual, descripcionEsperada, false)
WebUI.verifyMatch(cantidadActual, cantidadEsperada, false)

WebUI.scrollToElement(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/input_Entrega Estimada'), 3)

WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/input_Entrega Estimada'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/select_Seleccione.                         _05f498'), 
    '9', true)

WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/button_Actualizar estado'))

WebUI.setText(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/input_Nmero de pedido requerido_npedidoInput'),
	'133')

WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/button_Actualizar'))

WebUI.click(findTestObject('Object Repository/Cambio de estado 4/Page_Sales Orders 1.0 - 2025.03.20/button_Aceptar'))

InicioSesion.cerrarSesion()

InicioSesion.inicioSesionDinamico("Solicitante2PruebasCO")

CambioYRevionEstadoFase4.verificarEstadoSolicitud("Pendiente")

// Construir el XPath dinámico usando el valor de numeroPedido
//String xpathDinamico = "//a[contains(@onclick, 'mostrarDetalle(\"" + numeroPedido + "\")')]"

// Crear el TestObject dinámico
//TestObject enlacePedido = new TestObject("enlacePedidoDinamico")
//enlacePedido.addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, xpathDinamico)

// Hacer clic en el enlace
//WebUI.click(enlacePedido)

InicioSesion.cerrarSesion()

InicioSesion.inicioSesionDinamico(usuario)

CambioYRevionEstadoFase4.navegarAprobadasYCambiarEstado(10)

InicioSesion.cerrarSesion()

InicioSesion.inicioSesionDinamico("Solicitante2PruebasCO")

CambioYRevionEstadoFase4.verificarEstadoSolicitud("En tránsito")

InicioSesion.cerrarSesion()

InicioSesion.inicioSesionDinamico(usuario)

CambioYRevionEstadoFase4.navegarAprobadasYCambiarEstado(11)

InicioSesion.cerrarSesion()

InicioSesion.inicioSesionDinamico("Solicitante2PruebasCO")

CambioYRevionEstadoFase4.verificarEstadoSolicitud("En aduana")

InicioSesion.cerrarSesion()

InicioSesion.inicioSesionDinamico(usuario)

CambioYRevionEstadoFase4.navegarAprobadasYCambiarEstado(12)

InicioSesion.cerrarSesion()

InicioSesion.inicioSesionDinamico("Solicitante2PruebasCO")

CambioYRevionEstadoFase4.verificarEstadoSolicitud("Entregado")