package br.com.sped.scf.model.enums;

import java.util.List;

/**
 *
 * @author 711541241
 */
public enum NomeCollectionMongoDb implements CustomEnum<NomeCollectionMongoDb, Integer> {
	DIVERGENCIA_NFE_COLLECTION(1, "DivergenciaDocFiscal"),
        EFD_COLLECTION(2, "Efd"),
        NFE_COLLECTION(2, "Nfe"),
        NFE_NAO_ESCRITURADA_COLLECTION(2, "NfeNaoEscriturada");

	private final int codigo;
	private final String descricao;

	NomeCollectionMongoDb(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static List<String> getListaDescricao() {
		return CustomEnum.getListaDescricao(NomeCollectionMongoDb.class);
	}

	public static List<Integer> getListaValor() {
		return CustomEnum.getListaValor(NomeCollectionMongoDb.class);
	}

	public static NomeCollectionMongoDb[] getEnums() {
		return CustomEnum.getEnums(NomeCollectionMongoDb.class);
	}

	public static NomeCollectionMongoDb of(Integer codigo) {
		return CustomEnum.of(codigo, NomeCollectionMongoDb.class);
	}

	@Override
	public Integer getValor() {
		return codigo;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}
}
