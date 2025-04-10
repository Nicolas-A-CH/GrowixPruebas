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
TestObject mensajeFormularioIncompleto = findTestObject('Object Repository/Validaciones Realizar pedido/Page_Sales Orders 1.0 - 2025.03.20/h2_Formulario incompleto')
TestObject botonOK = findTestObject('Object Repository/Validaciones Realizar pedido/Page_Sales Orders 1.0 - 2025.03.20/button_OK')
TestObject enviar = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Generar solicitud')

// Definir el usuario actual (puedes cambiarlo dinámicamente según tu caso de prueba)
String usuario = "Solicitante2PruebasCO"
String estadoEsperado = "Sin revisar"

// Definir el valor del select según el usuario
String valorSelect = (usuario == "Solicitante2PruebasCO") ? "20" : "86"

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
	// --------------------------
    // PRUEBA 1: Formulario vacío
    // --------------------------

	WebUI.scrollToElement(enviar, 5)
    WebUI.click(enviar)
    
    // Verificar que aparece el mensaje de formulario incompleto
    WebUI.waitForElementVisible(mensajeFormularioIncompleto, 5)
    WebUI.verifyElementPresent(mensajeFormularioIncompleto, 5)
    WebUI.click(botonOK)

	// --------------------------
	// PRUEBA 2: Solo select lleno
	// --------------------------
	WebUI.selectOptionByValue(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/select_Seleccione.                         _4685bc'), valorSelect, true)
	WebUI.scrollToElement(enviar, 5)
	WebUI.click(enviar)
	
	// Verificar que aparece el mensaje de formulario incompleto
	WebUI.waitForElementVisible(mensajeFormularioIncompleto, 5)
	WebUI.verifyElementPresent(mensajeFormularioIncompleto, 5)
	WebUI.click(botonOK)
	
	// --------------------------
	// PRUEBA 3: Solo VIN lleno (debería fallar porque VIN es opcional pero otros campos son obligatorios)
	// --------------------------
	WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_VIN (se recomienda ingresar este valo_33dc7e'), "TESTVIN123")
	WebUI.scrollToElement(enviar, 5)
	WebUI.click(enviar)
	
	// Verificar que aparece el mensaje de formulario incompleto
	WebUI.waitForElementVisible(mensajeFormularioIncompleto, 5)
	WebUI.verifyElementPresent(mensajeFormularioIncompleto, 5)
	WebUI.click(botonOK)
	
	// --------------------------
	// PRUEBA 4: Campos obligatorios llenos excepto VIN (debería pasar)
	// --------------------------
	WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Marca versin y modelo_marcaPedido'), "Marca prueba")
	WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Nmero de parte_numeroParte'), "12345")
	WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Descripcin parte_descripcionParte'), "Descripción prueba")
	WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Cantidad_cantidadPartes'), "1")
	WebUI.scrollToElement(enviar, 5)
	WebUI.click(enviar)
	
	// Verificar que NO aparece el mensaje de formulario incompleto
	WebUI.waitForElementNotPresent(mensajeFormularioIncompleto, 5)
	
	//Logica para regresar
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/div_Solicitud creadaLa solicitud se ha crea_ad8639'), 30)
	
	WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/button_Aceptar'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/table_Solicitudes'), 30)
	
	WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Crear Solicitud'))
	
	WebUI.waitForElementNotVisible(spiner, 30)
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Realizar pedido'), 30)
	
	WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Realizar pedido'))
	
	// --------------------------
	// PRUEBA 5: Validación de campo cantidad (no numérico)
	// --------------------------
	
	// Probar con caracteres no permitidos en input number (e, +, -, etc.)
	WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Cantidad_cantidadPartes'), "e")
	WebUI.scrollToElement(enviar, 5)
	WebUI.click(enviar)
	
	// Verificar que aparece el mensaje de formulario incompleto
	WebUI.waitForElementVisible(mensajeFormularioIncompleto, 5)
	WebUI.verifyElementPresent(mensajeFormularioIncompleto, 5)
	WebUI.click(botonOK)
	
	// Probar con símbolos
	WebUI.setText(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/input_Cantidad_cantidadPartes'), "+2.9")
	WebUI.scrollToElement(enviar, 5)
	WebUI.click(enviar)
	
	// Verificar que aparece el mensaje de formulario incompleto
	WebUI.waitForElementVisible(mensajeFormularioIncompleto, 5)
	WebUI.verifyElementPresent(mensajeFormularioIncompleto, 5)
	WebUI.click(botonOK)
	
	// --------------------------
	// Limpieza final
	// --------------------------
	iniciarSesion.cerrarSesion()