/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.job.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class ReadLineUtil {
	
	public static final String AAAAMMDDHHMMSS = "yyyyMMddhhmmss";
	public static final String AAAAMMDD = "yyyyMMdd";
	public static final String AAAAMM = "yyyyMM";
	
	public static Character castCharacter(String[] row, int index) {
		return (row.length >= index + 1) ? (!isNullOrEmpty(row[index])) ? row[index].charAt(0) : null : null;
	}
	
    public static String castString(String value) {
		return (!isNullOrEmpty(value)) ? value.trim() : null;
	}
    
	public static String castString(String[] row, int index) {
		return (row.length >= index + 1) ? row[index].trim() : null;
	}
    
    public static Short castShort(String value) {
		return (!isNullOrEmpty(value)) ? new Short(value.replace("\"","").replace("\'","").trim()) : null;
	}
	
	public static Short castShort(String[] row, int index) {
		return (row.length >= index + 1) ? (!isNullOrEmpty(row[index])) ? new Short(row[index].replace("\"","").replace("\'","").trim()) : null : null;
	}
	
	public static Short castShort(String[] row, int index, List<Integer> listValues) {
		Short value = castShort(row, index);		
		if(listValues.contains((int) value))
			return value;

		throw new UnsupportedOperationException("Valor Tipo nao esperado: " + value + ", em " + listValues);
	}
	
    public static Integer castInteger(String value) {
        return (!isNullOrEmpty(value)) ? new Integer(value.replace("\"","").replace("\'","").trim()) : null;
	}
    
    public static Integer castInteger(String[] row, int index) {
		return (row.length >= index + 1) ? (!isNullOrEmpty(row[index])) ? new Integer(row[index].trim()) : null : null;
	}
    
    public static Long castLong(String value) {
		return (!isNullOrEmpty(value)) ? new Long(value.replace("\"","").replace("\'","").trim()) : null;
	}
    
	public static Long castLong(String[] row, int index) {
		return (row.length >= index + 1) ? (!isNullOrEmpty(row[index])) ? new Long(row[index].trim()) : null : null;
	}
	
    public static BigInteger castBigInteger(String[] row, int index) {
		return (row.length >= index + 1) ? (!isNullOrEmpty(row[index])) ? (!row[index].equals("-Infinito")) ? new BigInteger(row[index].replace(",",".").trim()) : BigInteger.ZERO : BigInteger.ZERO : BigInteger.ZERO;
	}

    public static BigDecimal castBigDecimal(String value) {
		return (!isNullOrEmpty(value)) ? (!value.equals("-Infinito")) ? new BigDecimal(value.replace(",",".").trim()) : BigDecimal.ZERO : BigDecimal.ZERO;
	}
    
	public static BigDecimal castBigDecimal(String[] row, int index) {
		return (row.length >= index + 1) ? (!isNullOrEmpty(row[index])) ? (!row[index].equals("-Infinito")) ? new BigDecimal(row[index].replace(",",".").trim()) : BigDecimal.ZERO : BigDecimal.ZERO : BigDecimal.ZERO;
	}
	
	public static Date castDateAAAAMMDDHHMMSS(String[] row, int index) throws ParseException {
		return (row.length >= index + 1) ? castDate(AAAAMMDDHHMMSS, row[index]) : null;
	}
	
    public static Date castDateAAAAMMDD(String value) throws ParseException {
		return (!isNullOrEmpty(value)) ? castDate(AAAAMMDD, value.trim()) : null;
	}
    
	public static Date castDateAAAAMMDD(String[] row, int index) throws ParseException {
		return (row.length >= index + 1) ? castDate(AAAAMMDD, row[index]) : null;
	}
	
    public static Date castDateAAAAMM(String value) throws ParseException {
		return (!isNullOrEmpty(value)) ? castDate(AAAAMM, value.trim()) : null;
	}
    
	public static Date castDateAAAAMM(String[] row, int index) throws ParseException {
		return (row.length >= index + 1) ? castDate(AAAAMM, row[index]) : null;
	}
	
	private static Date castDate(String pattern, String value) throws ParseException {
		return (isNullOrEmpty(value)) ? null : new SimpleDateFormat(pattern).parse(value);
	}
	
	private static boolean isNullOrEmpty(String value) {
		return (null == value || value.trim().isEmpty());
	}
	
}
