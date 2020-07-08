package com.challenge.testes;

import java.math.BigDecimal;

public class AnotherSalario
{
    private BigDecimal salarioBruto;
    private BigDecimal inss;
    private BigDecimal planoSaude;
    private BigDecimal valeRefeicao;
    
    public BigDecimal getSalarioBruto() {
        return this.salarioBruto;
    }
    
    public void setSalarioBruto(final BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }
    
    public BigDecimal getInss() {
        return this.inss;
    }
    
    public void setInss(final BigDecimal inss) {
        this.inss = inss;
    }
    
    public BigDecimal getPlanoSaude() {
        return this.planoSaude;
    }
    
    public void setPlanoSaude(final BigDecimal planoSaude) {
        this.planoSaude = planoSaude;
    }
    
    public BigDecimal getValeRefeicao() {
        return this.valeRefeicao;
    }
    
    public void setValeRefeicao(final BigDecimal valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }
}