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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')

WebUI.maximizeWindow()

InicioSesion.inicioSesionDinamico("admin")

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/a_Administrador'))

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/a_Crear Cliente'))

WebUI.selectOptionByValue(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/select_Seleccione el Pas.                  _20c8cd'), 
    '1', true)

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/button_Crear cliente'))

WebUI.selectOptionByValue(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/select_Selecciona.                         _b56a15'), 
    'Cliente', true)

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Documento de identificacin_documento__67a552'), 
    '100000')

WebUI.selectOptionByValue(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/select_Selecciona su estado                _5dd4ee'), 
    '1', true)

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/div_Especifique el nombre completo del cliente'))

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Nombre Completo_razon_social'), 
    'PepitoPerez')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Ciudad_ciudad'), 
    'Bogotá - BOGOTÁ')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Direccin del Cliente_direccion'), 
    'Calle Siempre viva 145')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Celular_celular'), 
    '3134541985')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Telfono_tel'), 
    '333333')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Direccin del Cliente_direccion'), 
    'Calle Siempre viva 145')

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Tipo_tipo'))

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Tipo_tipo'), 
    'indolke')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Correo electrnico_correo'), 
    'pruebas@Idl.com')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Correo Factura Electronica_correoFactura'), 
    'pruebas@Idl.com')

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/button_Guardar Cambios'))

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/button_Guardar'))

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/div_Guardado con xitoOKNoCancel'))

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/button_Crear nueva sucursal'))

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Nombre Sucursal_nombre_sucursal'), 
    'nombre2')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Persona a contactar_persona_contacto'), 
    'don juan')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Telfono_telefono_sucursal'), 
    '3333333333')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Ciudad_ciudad_sucursal'), 
    'Bogotá - BOGOTÁ')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Direccin_direccion_sucursal'), 
    'calle 100')

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Tipo de Sucursal_tipo_sucursal'), 
    '')

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/div_Tipo de Sucursal                       _332d88'))

WebUI.setText(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/input_Tipo de Sucursal_tipo_sucursal'), 
    'venta')

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/button_Aplicar cambios'))

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/button_Guardar_1'))

WebUI.click(findTestObject('Object Repository/CrearCliente_Surcursal/Page_Sales Orders 1.0 - 2025.03.20/div__swal2-success-circular-line-left'))

WebUI.closeBrowser()

