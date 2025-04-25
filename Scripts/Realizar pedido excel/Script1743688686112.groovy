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
import internal.GlobalVariable as GlobalVariable
import utils.InicioSesion
import groovy.json.JsonSlurper


def validateTableDataAgainstJson() {
	
	// 1. Parsear el JSON
    def jsonSlurper = new JsonSlurper()
    def jsonFile = new File("D:\\Descargas\\Pruebas growix.json")
    def expectedData = jsonSlurper.parse(jsonFile)
    def totalItems = expectedData.size()
	
	// 2. Configurar objetos
    def nextButton = findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/a_Next')
	
	// 3. Variables de control
    def dataIndex = totalItems - 1 // Comenzar desde el último elemento del JSON
    def currentPage = 1
	
	// 4. Recorrer todas las páginas
    while (dataIndex >= 0) {
        // Esperar a que la tabla esté visible
        WebUI.waitForElementVisible(
            findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/Detalles_modal'),
            30
        )
        
        // Obtener filas de la tabla
        def rows = WebUI.findWebElements(
            findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/tableRows'),
            30
        )
        
        // Validar cada fila en orden inverso
        for (int i = 1; i <= rows.size() && dataIndex >= 0; i++) {
            // Construir objetos dinámicos para las celdas
			
			// Construir XPath dinámico y loguearlo
            TestObject vinCell = new TestObject("vinCell_${i}")
            vinCell.addProperty("xpath", ConditionType.EQUALS, "//table[@id='tblDetalleSolicitud']//tbody//tr[${i}]/td[1]")
			
			TestObject marcaCell = new TestObject("marcaCell_${i}")
			marcaCell.addProperty("xpath", ConditionType.EQUALS, "//table[@id='tblDetalleSolicitud']//tbody//tr[${i}]/td[2]")
			
			TestObject numParteCell = new TestObject("numParteCell_${i}")
			numParteCell.addProperty("xpath", ConditionType.EQUALS, "//table[@id='tblDetalleSolicitud']//tbody//tr[${i}]/td[3]")
			
			TestObject DescripcionCell = new TestObject("DescripcionCell_${i}")
			DescripcionCell.addProperty("xpath", ConditionType.EQUALS, "//table[@id='tblDetalleSolicitud']//tbody//tr[${i}]/td[4]")
            
			TestObject CantidadCell = new TestObject("CantidadCell_${i}")
			CantidadCell.addProperty("xpath", ConditionType.EQUALS, "//table[@id='tblDetalleSolicitud']//tbody//tr[${i}]/td[5]")
			
            // Obtener valores actuales
            def actualVin = WebUI.getText(vinCell)
            def expectedItem = expectedData[dataIndex]
            def expectedVin = expectedItem.VIN?.toString() ?: ""
			
			def actualMarca = WebUI.getText(marcaCell)
			def expectedMarca = expectedItem.MARCA?.toString() ?: ""
			
			def actualNumParte = WebUI.getText(numParteCell)
			def expectedNumParte = expectedItem."NÚMERO PARTE"?.toString() ?: ""
			
			def actualDescripcion = WebUI.getText(DescripcionCell)
			def expectedDescripcion = expectedItem."DESCRIPCIÓN"?.toString() ?: ""
			
			def actualCantidad = WebUI.getText(CantidadCell)
			def expectedCantidad = expectedItem.CANTIDAD?.toString() ?: ""

            // Log de depuración
            //println("Validando fila ${i} (JSON index ${dataIndex}):")
            //println("Actual VIN: ${actualVin} | Esperado: ${expectedVin}")

            // Validación
            WebUI.verifyMatch(actualVin, expectedVin, false, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyMatch(actualMarca, expectedMarca, false, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyMatch(actualNumParte, expectedNumParte, false, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyMatch(actualDescripcion, expectedDescripcion, false, FailureHandling.STOP_ON_FAILURE)
			WebUI.verifyMatch(actualCantidad, expectedCantidad, false, FailureHandling.STOP_ON_FAILURE)
            
            dataIndex-- // Decrementar el índice del JSON
        }
        
        // Paginación: Ir a la siguiente página si es necesario
        if (dataIndex >= 0 && WebUI.verifyElementClickable(nextButton, FailureHandling.OPTIONAL)) {
            WebUI.click(nextButton)
            WebUI.waitForPageLoad(30)
            currentPage++
        } else {
            break
        }
    }
	
	// Verificación final
    WebUI.verifyEqual(dataIndex, -1)
}

//Variables
TestObject spiner = findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/SppinerLoadPage')

String usuario = GlobalVariable.usuarioSolicitante

String url = GlobalVariable.Url

WebUI.openBrowser('')

WebUI.navigateToUrl(url)

WebUI.maximizeWindow()

InicioSesion.inicioSesionDinamico(usuario)

WebUI.click(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/a_Mis Solicitudes Growix'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Crear Solicitud'), 5)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/a_Crear Solicitud'))

WebUI.waitForElementNotVisible(spiner, 30)

WebUI.click(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/button_Cargar excel'))

WebUI.selectOptionByValue(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/select_Seleccione.                         _0242a6'), 
    '20', true)

WebUI.uploadFile(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/inputPedido_uploadfile'), 'D:\\Descargas\\Pruebas growix.xlsx')

WebUI.click(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/button_ENVIAR'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/button_Aceptar'), 60)

WebUI.click(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/button_Aceptar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/table_Solicitudes'), 30)

WebUI.waitForElementClickable(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/enlace_VerMasDetalles_PrimeraFila'), 5)

WebUI.click(findTestObject('Object Repository/RealizarPedido/Page_Sales Orders 1.0 - 2025.03.21/enlace_VerMasDetalles_PrimeraFila'))

validateTableDataAgainstJson()

WebUI.click(findTestObject('Object Repository/RealizarPedidoExcel/Page_Sales Orders 1.0 - 2025.03.20/button_Cerrar'))

InicioSesion.cerrarSesion()