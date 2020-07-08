package com.challenge.testes;

import java.math.BigDecimal;
import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class ReflectionTest
{
    private static final String METHOD_SOMAR = "somar";
    private static final String METHOD_SUBTRAIR = "subtrair";
    private static final String METHOD_TOTALIZAR = "totalizar";
    private static final String CALCULADOR_DE_CLASSES_PATH = "com.challenge.desafio.CalculadorDeClasses";
    private static final String CALCULAVEL_PATH = "com.challenge.interfaces.Calculavel";
    
    @Test
    public void whenAdd() {
        final Salario salario = new Salario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        final BigDecimal result = this.execute("somar", salario);
        Assert.assertThat((Object)result, Matchers.equalTo((Object)new BigDecimal(40)));
    }
    
    @Test
    public void whenAddWithouAnnotation() {
        final AnotherSalario salario = new AnotherSalario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        final BigDecimal result = this.execute("somar", salario);
        Assert.assertThat((Object)result, Matchers.equalTo((Object)new BigDecimal(0)));
    }
    
    @Test
    public void whenSubtract() {
        final Salario salario = new Salario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        final BigDecimal result = this.execute("subtrair", salario);
        Assert.assertThat((Object)result, Matchers.equalTo((Object)new BigDecimal(15)));
    }
    
    @Test
    public void whenSubtractAllWithouAnnotation() {
        final AnotherSalario salario = new AnotherSalario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        final BigDecimal result = this.execute("subtrair", salario);
        Assert.assertThat((Object)result, Matchers.equalTo((Object)new BigDecimal(0)));
    }
    
    private BigDecimal execute(final String method, final Object object) {
        try {
            final Object obj = this.getCalculadorClassesClass().newInstance();
            return (BigDecimal)obj.getClass().getMethod(method, Object.class).invoke(obj, object);
        }
        catch (Exception e) {
            new RuntimeException(e);
            return null;
        }
    }
    
    @Test
    public void whenResult() {
        final Salario salario = new Salario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        final BigDecimal result = this.execute("totalizar", salario);
        Assert.assertThat((Object)result, Matchers.equalTo((Object)new BigDecimal(25)));
    }
    
    @Test
    public void whenResultWithoutAnnotation() {
        final AnotherSalario salario = new AnotherSalario();
        salario.setInss(BigDecimal.valueOf(5L));
        salario.setPlanoSaude(BigDecimal.valueOf(10L));
        salario.setValeRefeicao(BigDecimal.valueOf(15L));
        salario.setSalarioBruto(BigDecimal.valueOf(25L));
        final BigDecimal result = this.execute("totalizar", salario);
        Assert.assertThat((Object)result, Matchers.equalTo((Object)new BigDecimal(0)));
    }
    
    @Test
    public void shouldImplementsCalculavel() {
        final boolean isSameClass = Stream.of(this.getCalculadorClassesClass().getInterfaces()).anyMatch(i -> i.equals(this.getCalculavelClass()));
        Assert.assertThat((Object)isSameClass, Matchers.is((Object)true));
    }
    
    @Test
    public void shouldHaveAddMethod() {
        final boolean temSoma = Stream.of(this.getCalculavelClass().getMethods()).anyMatch(m -> m.getName().equals("somar"));
        Assert.assertThat((Object)temSoma, Matchers.is((Object)true));
    }
    
    private Class<?> getCalculavelClass() {
        try {
            return Class.forName("com.challenge.interfaces.Calculavel");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    private Class<?> getCalculadorClassesClass() {
        try {
            return Class.forName("com.challenge.desafio.CalculadorDeClasses");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void shouldHaveSubtractMethod() {
        final boolean temSoma = Stream.of(this.getCalculavelClass().getMethods()).anyMatch(m -> m.getName().equals("subtrair"));
        Assert.assertThat((Object)temSoma, Matchers.is((Object)true));
    }
    
    @Test
    public void shouldHaveResultMethod() {
        final boolean temSoma = Stream.of(this.getCalculavelClass().getMethods()).anyMatch(m -> m.getName().equals("totalizar"));
        Assert.assertThat((Object)temSoma, Matchers.is((Object)true));
    }
}