package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioAcimaDeDezMil() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Julio", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaFuncionarioComSalarioAbaixoDeDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Julio", LocalDate.now(), new BigDecimal("2500")));

        assertEquals((new BigDecimal("250.00")), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Julio", LocalDate.now(), new BigDecimal("10000")));

        assertEquals((new BigDecimal("1000.00")), bonus);
    }

}