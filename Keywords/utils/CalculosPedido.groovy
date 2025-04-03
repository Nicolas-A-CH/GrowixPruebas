package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CalculosPedido {

	// Calcula el subtotal base (sin aumento)
	static double calcularSubtotalBase(double cantidad, double precioUnitario) {
		return cantidad * precioUnitario
	}

	// Aplica el 10% de aumento si es premium
	static double aplicarAumentoPremium(double subtotalBase) {
		return subtotalBase * 1.10
	}

	// Calcula el IVA sobre el subtotal base (sin aumento)
	static double calcularIVA(double subtotalBase, String usuario) {
		double ivaPorcentaje = (usuario == "GrowixCO" || usuario == "Solicitante2PruebasCO") ? 0.19 : 0.15
		return subtotalBase * ivaPorcentaje
	}

	// Calcula el total: subtotal con aumento + IVA (sobre subtotal base)
	static double calcularTotal(double subtotalConIncremento, double iva) {
		return subtotalConIncremento + iva
	}
}
