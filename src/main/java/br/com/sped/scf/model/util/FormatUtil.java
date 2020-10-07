package br.com.sped.scf.model.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatUtil {
	private static SimpleDateFormat sdfDDmmYYYY = new SimpleDateFormat("dd/MM/yyyy");
	private static NumberFormat formatValorMonetario = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
	
	public  static String formatarValorMonetario(BigDecimal valor) {
		return formatValorMonetario.format(valor.doubleValue());
	}
	public static String formatarDataDDmmYYYY(Date data) {
		return sdfDDmmYYYY.format(data);
	}
}
