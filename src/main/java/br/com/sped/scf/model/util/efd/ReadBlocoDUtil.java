package br.com.sped.scf.model.util.efd;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.sped.scf.model.entity.efd.Efd;
import br.com.sped.scf.model.entity.efd.blocod.BlocoD;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD001;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD100;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD101;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD190;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD195;
import br.com.sped.scf.model.entity.efd.blocod.RegistroD197;
import br.com.sped.scf.model.util.ReadLineUtil;

public class ReadBlocoDUtil {

	Efd efd;
	BlocoD blocoD;
	RegistroD001 registroD001;
	RegistroD100 registroD100;
	List<RegistroD100> registroD100List;
	RegistroD101 registroD101;
	RegistroD190 registroD190;
	List<RegistroD190> registroD190List;
	RegistroD195 registroD195;
	List<RegistroD195> registroD195List;
	RegistroD197 registroD197;
	List<RegistroD197> registroD197List;

	public void processarBlocoD(List<String[]> blocoList, Efd efd) throws ParseException {
		this.efd = efd;
		for (String[] row : blocoList) {
			if (row.length == 0) {
				continue;
			}

			switch (row[0]) {

			case "D001":// nivel 1
				blocoD = new BlocoD();
				registroD001 = lerRegistroD001(row);
				blocoD.setRegistroD001(registroD001);
				registroD100List = new ArrayList<>();
				efd.setBlocoD(blocoD);
				break;
			case "D100":// nivel 2
				registroD100 = lerRegistroD100(row);
				registroD100List.add(registroD100);
				registroD001.setRegistroD100(registroD100List);
				registroD190List = new ArrayList<>();
				break;
			case "D101":// nivel 3
				registroD101 = lerRegistroD101(row);
				registroD100.setRegistroD101(registroD101);
				break;
			case "D190":// nivel 3
				registroD190 = lerRegistroD190(row);
				registroD190List.add(registroD190);
				registroD100.setRegistroD190(registroD190List);
				break;
			case "D195":// nivel 3
				registroD195 = lerRegistroD195(row);
				registroD195List.add(registroD195);
				registroD100.setRegistroD195(registroD195List);
				registroD197List = new ArrayList<>();
				break;
			case "D197":// nivel 4
				registroD197 = lerRegistroD197(row);
				registroD197List.add(registroD197);
				registroD195.setRegistroD197(registroD197List);
				break;
			default:
				break;
			}
		}
	}

	private RegistroD100 lerRegistroD100(String[] row) throws ParseException {
		RegistroD100 registroD100 = new RegistroD100();
		int i = 1;
		registroD100.setIndOper(ReadLineUtil.castString(row, i++));
		registroD100.setIndEmit(ReadLineUtil.castString(row, i++));
		registroD100.setCodPart(ReadLineUtil.castString(row, i++));
		registroD100.setCodMod(ReadLineUtil.castString(row, i++));
		registroD100.setCodSit(ReadLineUtil.castInteger(row, i++));
		registroD100.setSer(ReadLineUtil.castString(row, i++));
		registroD100.setSub(ReadLineUtil.castString(row, i++));
		registroD100.setNumDoc(ReadLineUtil.castInteger(row, i++));
		registroD100.setChvCte(ReadLineUtil.castString(row, i++));
		registroD100.setDtDoc(ReadLineUtil.castDateAAAAMMDD(row, i++));
		registroD100.setDtAp(ReadLineUtil.castDateAAAAMMDD(row, i++));
		registroD100.setTpCte(ReadLineUtil.castInteger(row, i++));
		registroD100.setChvCteRef(ReadLineUtil.castString(row, i++));
		registroD100.setVlDoc(ReadLineUtil.castBigDecimal(row, i++));
		registroD100.setVlDesc(ReadLineUtil.castBigDecimal(row, i++));
		registroD100.setIndFrt(ReadLineUtil.castString(row, i++));
		registroD100.setVlServ(ReadLineUtil.castBigDecimal(row, i++));
		registroD100.setVlBcIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD100.setVlIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD100.setVlNt(ReadLineUtil.castBigDecimal(row, i++));
		registroD100.setCodInf(ReadLineUtil.castString(row, i++));
		registroD100.setCodCta(ReadLineUtil.castString(row, i++));
		registroD100.setCodMunOrig(ReadLineUtil.castInteger(row, i++));
		registroD100.setCodMunDest(ReadLineUtil.castInteger(row, i++));
		return registroD100;
	}

	private RegistroD101 lerRegistroD101(String[] row) throws ParseException {
		RegistroD101 registroD101 = new RegistroD101();
		int i = 1;
		registroD101.setVlFcpUfDest(ReadLineUtil.castBigDecimal(row, i++));
		registroD101.setVlIcmsUfDest(ReadLineUtil.castBigDecimal(row, i++));
		registroD101.setVlIcmsUfRem(ReadLineUtil.castBigDecimal(row, i++));
		return registroD101;
	}

	private RegistroD190 lerRegistroD190(String[] row) throws ParseException {
		RegistroD190 registroD190 = new RegistroD190();

		int i = 1;
		registroD190.setCstIcms(ReadLineUtil.castInteger(row, i++));
		registroD190.setCfop(ReadLineUtil.castInteger(row, i++));
		registroD190.setAliqIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD190.setVlOpr(ReadLineUtil.castBigDecimal(row, i++));
		registroD190.setVlBcIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD190.setVlIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD190.setVlRedBc(ReadLineUtil.castBigDecimal(row, i++));
		registroD190.setCodObs(ReadLineUtil.castString(row, i++));
		return registroD190;
	}

	private RegistroD195 lerRegistroD195(String[] row) throws ParseException {
		RegistroD195 registroD195 = new RegistroD195();
		int i = 1;
		registroD195.setCodObs(ReadLineUtil.castString(row, i++));
		registroD195.setTxtCompl(ReadLineUtil.castString(row, i++));
		return registroD195;
	}

	private RegistroD001 lerRegistroD001(String[] row) throws ParseException {
		RegistroD001 registroD001 = new RegistroD001();
		int i = 1;
		registroD001.setIndMov(ReadLineUtil.castString(row, i++));
		return registroD001;
	}

	private RegistroD197 lerRegistroD197(String[] row) throws ParseException {
		RegistroD197 registroD197 = new RegistroD197();

		int i = 1;
		registroD197.setCodAj(ReadLineUtil.castString(row, i++));
		registroD197.setDescrComplAj(ReadLineUtil.castString(row, i++));
		registroD197.setCodItem(ReadLineUtil.castString(row, i++));
		registroD197.setVlBcIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD197.setVlAliqIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD197.setVlIcms(ReadLineUtil.castBigDecimal(row, i++));
		registroD197.setVlOutros(ReadLineUtil.castBigDecimal(row, i++));
		return registroD197;
	}

}
