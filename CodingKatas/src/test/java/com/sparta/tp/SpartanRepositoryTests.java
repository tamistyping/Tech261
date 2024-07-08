package com.sparta.tp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SpartanRepositoryTests {
    SpartanRepository sut = new SpartanRepository();
    Spartan mock1 = Mockito.mock(Spartan.class);
    Spartan mock2 = Mockito.mock(Spartan.class);

    @BeforeEach
    public void setup(){
        sut.addSpartan(mock1);
        sut.addSpartan(mock2);
    }

    @Test
    @DisplayName("Add spartans")
    public void testAddSpartans(){
        assert(sut.getNumSpartans() == 2);
    }

    @Test
    @DisplayName("Testing findSpartan")
    public void testFindSpartan(){
        Mockito.when(mock2.getId())
                .thenReturn(27);
        Assertions.assertEquals(mock2, sut.findSpartan(27));
    }

    @Test
    @DisplayName("Testing getSpartansCreatedLast24Hours")
    public void testGetSpartansCreatedLast24Hours(){
        Mockito.when(mock1.getStartDate())
                .thenReturn(java.time.LocalDate.now());
        Mockito.when(mock2.getStartDate())
                .thenReturn(java.time.LocalDate.now().minusDays(2));
        assert(sut.getSpartansCreatedLast24Hours().size() == 1);
    }

    @Test
    @DisplayName("Testing getSpartansCreatedLast24Hours_multiplecalls")
    public void testGetSpartansCreatedLast24Hours_multiplecall(){
        Mockito.when(mock1.getStartDate())
                .thenReturn(java.time.LocalDate.now());
        Mockito.when(mock2.getStartDate())
                .thenReturn(java.time.LocalDate.now().minusDays(2))
                .thenReturn(LocalDate.now());
        assert(sut.getSpartansCreatedLast24Hours().size() == 1);
    }


    @Test
    @DisplayName("testing changeName where name is null")
    public void testChangeNameNull(){
        Mockito.when(mock1.getId())
                .thenReturn(3);
        Mockito.doThrow(IllegalArgumentException.class)
                .when(mock1)
                .setName(Mockito.mock(String.class));
        Assertions.assertFalse(sut.changeName(3, "Doris"));
    }

    @Test
    @DisplayName("Check getId is called once per Spartan")
    public void checkGetIdCalledOncePerSpartan(){
        sut.findSpartan(20);
        Mockito.verify(mock1, Mockito.times(1)).getId();
        Mockito.verify(mock2, Mockito.times(1)).getId();
    }

    @Test
    @DisplayName("Check methods are called in order")
    public void checkMethodsAreCalledInOrder(){
        sut.getNumSpartans();
        InOrder inOrder = Mockito.inOrder(mock1);
        inOrder.verify(mock1).getId();
    }
}

