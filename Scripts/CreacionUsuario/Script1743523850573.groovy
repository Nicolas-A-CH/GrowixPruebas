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

import groovy.json.StringEscapeUtils
import internal.GlobalVariable as GlobalVariable
import utils.InicioSesion

import org.apache.poi.ss.usermodel.ConditionType
import org.openqa.selenium.Keys as Keys

// Configuración de tipos de usuario
def userTypes = [
	'SOLUCIONADOR': [
		perfil: '2', // Gestor Growix
		atiendeCasos: '1', // Sí
		checkbox: '(//input[@name="cCodMenu"])[2]',
		nameVisible: 'SOLUCIONADOR'
	],
	'SOLICITANTE': [
		perfil: '0', // Valor para solicitante
		atiendeCasos: '0', // No
		checkbox: '(//input[@name="cCodMenu"])[3]',
		nameVisible: 'SOLICITANTE'
	]
]

// Parámetros del usuario (puedes cambiarlos según necesites)
String tipoUsuario = 'SOLICITANTE' // Cambiar a 'SOLUCIONADOR' cuando necesites
def config = userTypes[tipoUsuario]


//variables

String nameUsuario = tipoUsuario + '3CO'
String emailUsuario = 'ceted71812@bariswc.com'
String numeroCelular = '3205964349'
String cargoUsuario = 'Gestionador de solicitudes'
String password = 'c4HiwZztlarfDaH0rnJD6g=='

// Inicio del navegador y navegación a la URL de la aplicación

WebUI.openBrowser('')

WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')

WebUI.maximizeWindow()

InicioSesion.inicioSesionDinamico('admin')

// Navegación al módulo de creación de usuarios

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/a_Administrador'))

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/a_Crear Usuarios'))

// Selección del cliente DONPEDRO

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/div_Seleccione el clienteRemove item'))

WebUI.waitForElementVisible(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/div_DONPEDRO_opcion'), 5)

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/div_DONPEDRO_opcion'))

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/button_Crear Usuario'))

// Llenado del formulario de creación de usuario

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Sucursal del Cliente_sucursal-ts-control'))

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/div_BOGOT - BOGOT - CALLE SIEMPRE VIVA 145'))

WebUI.selectOptionByValue(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/select_No Aplica  No Tiene Sucursal.       _3bdbcf'), 
    '19', true) // Selecciona la sucursal 'bogota calle siempre viva 145'

WebUI.setText(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Nombre de Usuario_nombreUsuario'), nameUsuario)

WebUI.selectOptionByValue(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/select_Selecciona su estado                _6bf873'), 
    '1', true) // Selecciona el estado 'Activo'

WebUI.setEncryptedText(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Contrasea_password'), password)

WebUI.setEncryptedText(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Confirmar Contrasea_password2'), password)

// Configuración específica según tipo de usuario

WebUI.selectOptionByValue(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/select_Seleccione Perfil                   _896603'), 
    config.perfil, true) // Selecciona el perfil

WebUI.selectOptionByValue(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/select_Seleccione Division                 _c71728'), 
    '1', true) // Selecciona la division 'Cliente'

WebUI.setText(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Descripcin_descripuser'), config.nameVisible)

WebUI.setText(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Numero de Celular_celular'), numeroCelular)

WebUI.setText(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Correo_mail'), emailUsuario)

WebUI.setText(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/input_Cargo Empleado_cargo'), cargoUsuario)

WebUI.selectOptionByValue(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/select_Seleccione.                         _09ae38'), 
    config.atiendeCasos, true) // Selecciona que el usuario puede atender casos

// Construir el TestObject dinámico para el checkbox
String xpathCheckbox = config.checkbox
TestObject checkboxDinamico = new TestObject("checkboxDinamico").addProperty("xpath", com.kms.katalon.core.testobject.ConditionType.EQUALS, xpathCheckbox)

// 2. Scroll hasta el checkbox
WebUI.scrollToElement(checkboxDinamico, 3) // 3 segundos de tiempo de espera

// 3. Hacer clic en el checkbox
WebUI.click(checkboxDinamico)

WebUI.scrollToElement(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/button_Guardar Cambios'), 5)

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/button_Guardar Cambios'))

WebUI.click(findTestObject('Object Repository/crear_usuario/Page_Sales Orders 1.0 - 2025.03.20/button_Guardar'))