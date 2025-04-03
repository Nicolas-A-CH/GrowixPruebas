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
import utils.CalculosPedido
import utils.InicioSesion

import org.openqa.selenium.Keys as Keys

//Inicializar class
InicioSesion iniciarSesion = new InicioSesion()

String usuario = "Solicitante2PruebasCO"
// Definir los valores esperados (los mismos que se ingresaron en el formulario)
String vinEsperado = GlobalVariable.vinEsperado
String marcaEsperada = GlobalVariable.marcaEsperada
String numeroParteEsperado = GlobalVariable.numeroParteEsperado
String descripcionEsperada = GlobalVariable.descripcionEsperada
String cantidadEsperada = GlobalVariable.cantidadEsperada
String precio = GlobalVariable.precio

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')

iniciarSesion.inicioSesionDinamico(usuario)

WebUI.click(findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/a_Mis Solicitudes Growix'))

WebUI.click(findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/a_Mis Solicitudes Cotizadas'))

WebUI.click(findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/enlace_vermasDetalles_PrimeraCelda'))

WebUI.click(findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/input_40,000.00_form-check-input pedido-premium'))

WebUI.click(findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/button_Aceptar'))

WebUI.click(findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/button_Aceptar_1'))

// Obtener los valores de la primera fila de la tabla de detalles
TestObject celdaVin = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/td_Vin')
String vinActual = WebUI.getText(celdaVin)

TestObject celdaMarca = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/td_Marca')
String marcaActual = WebUI.getText(celdaMarca)

TestObject celdaNumeroParte = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/td_NumeroParte')
String numeroParteActual = WebUI.getText(celdaNumeroParte)

TestObject celdaDescripcion = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/td_Descripcion')
String descripcionActual = WebUI.getText(celdaDescripcion)

TestObject celdaCantidad = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/td_Cantidad')
String cantidadActual = WebUI.getText(celdaCantidad)

TestObject checkPremium = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/input_40,000.00_form-check-input pedido-premium')
boolean esPremium = WebUI.getAttribute(checkPremium, "checked") == "true" // Si está marcado, devuelve "true"

// Validaciones
WebUI.verifyMatch(vinActual, vinEsperado, false)
WebUI.verifyMatch(marcaActual, marcaEsperada, false)
WebUI.verifyMatch(numeroParteActual, numeroParteEsperado, false)
WebUI.verifyMatch(descripcionActual, descripcionEsperada, false)
WebUI.verifyMatch(cantidadActual, cantidadEsperada, false)

// Calcular el subtotal usando la clase CalculosPedido
double cantidad = Double.parseDouble(cantidadActual)
double precioUnitario = Double.parseDouble(precio)
double subtotalBase  = CalculosPedido.calcularSubtotalBase(cantidad, precioUnitario)

// Aplicar aumento del 10% si es premium
double subtotalCalculado = esPremium ? CalculosPedido.aplicarAumentoPremium(subtotalBase) : subtotalBase

// Calcular IVA sobre el subtotal base (sin aumento)
double ivaCalculado = CalculosPedido.calcularIVA(subtotalBase, usuario)

// Calcular total (subtotal con aumento + IVA sobre subtotal base)
double totalCalculado = CalculosPedido.calcularTotal(subtotalCalculado, ivaCalculado)

// Obtener valores de la interfaz
TestObject celdaSubtotal = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/td_SubTotal')
String subtotalMostrado = WebUI.getText(celdaSubtotal)
double subtotalMostradoNum = Double.parseDouble(subtotalMostrado.replaceAll("[^\\d.]", ""))

TestObject celdaTotalIVA = findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/td_IVA')
String totalIVAMostrado = WebUI.getText(celdaTotalIVA)
double totalIVAMostradoNum = Double.parseDouble(totalIVAMostrado.replaceAll("[^\\d.]", ""))

//imprimir valores consola
println("Valor del iva calculado ${totalCalculado}")
println("Valor del iva interfaz ${totalIVAMostradoNum}")
println("Valor del iva calculado ${ivaCalculado}")

// Validaciones
WebUI.verifyEqual(subtotalMostradoNum, subtotalCalculado) // Subtotal con aumento
WebUI.verifyEqual(totalIVAMostradoNum, totalCalculado)    // Total (subtotal + IVA base)

WebUI.click(findTestObject('Object Repository/cotizaciones/Page_Sales Orders 1.0 - 2025.03.20/button_Cerrar'))

iniciarSesion.cerrarSesion()
