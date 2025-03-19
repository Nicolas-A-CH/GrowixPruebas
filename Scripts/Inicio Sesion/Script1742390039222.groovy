import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

try {
    // Abrir navegador y navegar a la URL
    WebUI.openBrowser('')
    WebUI.navigateToUrl('https://growixpruebasplus.idl.com.co/sales-orders/jsp/index.jsp')
    WebUI.maximizeWindow()

    // Paso 1: Hacer clic en "Ingresar"
    WebUI.click(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/a_Ingresar'))
    WebUI.takeScreenshot()  // Captura de pantalla para diagnóstico

    // Paso 2: Ingresar credenciales
    WebUI.setText(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/input_Login_username'), 'admin')
    WebUI.setEncryptedText(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/input_Login_password'), 'xSRDNOoyrpnhrpRgLrbWJA==')
    WebUI.takeScreenshot()

    // Paso 3: Hacer clic en el botón "Ingresar"
    WebUI.click(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/button_Ingresar'))

    // Paso 4: Esperar dinámicamente a que el spinner desaparezca
    int timeout = 90 // Segundos máximos de espera
    int pollingInterval = 2 // Intervalo de verificación en segundos
    TestObject spinner = findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders/div_Ingresar_spinner')
    boolean isSpinnerGone = false

    // Intenta verificar la ausencia del spinner
    for (int i = 0; i < timeout; i += pollingInterval) {
        try {
            // Verificar si el spinner NO está presente
            if (!WebUI.verifyElementPresent(spinner, 1, FailureHandling.OPTIONAL)) {
                isSpinnerGone = true
                break
            }
            WebUI.delay(pollingInterval)
        } catch (Exception e) {
            // Captura el error y continúa el bucle
            println("⚠️ Error durante la verificación del spinner: ${e.getMessage()}")
        }
    }

    if (!isSpinnerGone) {
        throw new Exception("❌ El spinner no desapareció después de ${timeout} segundos")
    }

    // Paso 5: Verificar carga completa de la página
    WebUI.waitForElementVisible(findTestObject('Object Repository/Inicio_Sesion/Page_Sales Orders 1.0 - 2025.03.21/img'), 30)
    WebUI.takeScreenshot()

} catch (Exception e) {
    // Manejo detallado de errores
    println("""
        ❌ Error crítico durante la ejecución:
        Mensaje: ${e.getMessage()}
        Causa: ${e.getCause()}
        StackTrace: ${Arrays.toString(e.getStackTrace())}
    """)
    throw e // Relanza la excepción para marcar el test como fallido
}