/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sped.scf.model.enums;

import java.util.List;

/**
 *
 * @author 711541241
 */
public enum TipoNotaFiscal implements CustomEnum<TipoNotaFiscal, Integer> {

    SIM(0, "Entrada"),
    NAO(1, "Saída");

    private final int codigo;
    private final String descricao;

    TipoNotaFiscal(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static List<String> getListaDescricao() {
        return CustomEnum.getListaDescricao(TipoNotaFiscal.class);
    }

    public static List<Integer> getListaValor() {
        return CustomEnum.getListaValor(TipoNotaFiscal.class);
    }

    public static TipoNotaFiscal[] getEnums() {
        return CustomEnum.getEnums(TipoNotaFiscal.class);
    }

    public static TipoNotaFiscal of(Integer codigo) {
        return CustomEnum.of(codigo, TipoNotaFiscal.class);
    }

    public static TipoNotaFiscal getByDescricao(String descricao) {
        TipoNotaFiscal[] sit = getEnums();
        for (int i = 0; i < sit.length; i++) {

            if (sit[i].getDescricao().equalsIgnoreCase(descricao)) {
                return sit[i];
            }
        }
        return null;
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
