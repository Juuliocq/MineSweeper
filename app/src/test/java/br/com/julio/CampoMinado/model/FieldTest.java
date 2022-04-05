/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.julio.CampoMinado.model;

import br.com.julio.CampoMinado.exception.ExplosionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author julio
 */
public class FieldTest {

    private Field fieldTest;

    public FieldTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        fieldTest = new Field(false, false, false, 1, 1);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void isNeighbourRightTest() {
        Field field2 = new Field(1, 2);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNeighbourLeftTest() {
        Field field2 = new Field(1, 0);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNeighbourDownTest() {
        Field field2 = new Field(2, 1);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNeighbourUpTest() {
        Field field2 = new Field(0, 1);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNeighbourDiagonalUpLeftTest() {
        Field field2 = new Field(0, 0);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNeighbourDiagonalUpRightTest() {
        Field field2 = new Field(0, 2);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNeighbourDiagonalDownLeftTest() {
        Field field2 = new Field(2, 0);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNeighbourDiagonalDownRightTest() {
        Field field2 = new Field(2, 2);

        assertTrue(fieldTest.isNeighbour(field2));
    }

    @Test
    void isNotNeighbourTest() {
        Field field2 = new Field(3, 2);

        assertFalse(fieldTest.isNeighbour(field2));
    }

    @Test
    void iaddNeighbourRightTest() {
        Field field2 = new Field(1, 2);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNeighbourLeftTest() {
        Field field2 = new Field(1, 0);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNeighbourDownTest() {
        Field field2 = new Field(2, 1);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNeighbourUpTest() {
        Field field2 = new Field(0, 1);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNeighbourDiagonalUpLeftTest() {
        Field field2 = new Field(0, 0);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNeighbourDiagonalUpRightTest() {
        Field field2 = new Field(0, 2);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNeighbourDiagonalDownLeftTest() {
        Field field2 = new Field(2, 0);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNeighbourDiagonalDownRightTest() {
        Field field2 = new Field(2, 2);

        assertTrue(fieldTest.addNeighbour(field2));
    }

    @Test
    void addNotNeighbourTest() {
        Field field2 = new Field(3, 2);

        assertFalse(fieldTest.addNeighbour(field2));
    }

    @Test
    void alterMarkedTrueTest() {
        fieldTest.alterMarked();

        assertTrue(fieldTest.getMarked());
    }

    @Test
    void alterMarkedFalseTest() {

        assertFalse(fieldTest.getMarked());
    }

    @Test
    void openFieldOpenedFalseMarkedFalseMinedFalseTest() {
        
        assertTrue(fieldTest.open());
    }

    @Test
    void openFieldOpenedTrueMarkedTrueMinedTrueTest() {

        fieldTest.open();
        fieldTest.alterMarked();
        fieldTest.setMined(true);
        assertFalse(fieldTest.open());
    }

    @Test
    void openFieldOpenedTrueMarkedFalseMinedFalseTest() {

        fieldTest.open();
        assertFalse(fieldTest.open());
    }

    @Test
    void openFieldOpenedFalseMarkedTrueMinedFalseTest() {

        fieldTest.alterMarked();
        assertFalse(fieldTest.open());
    }

    @Test
    void openFieldOpenedFalseMarkedFalseMinedTrueTest() {

        fieldTest.setMined(true);
        assertThrows(ExplosionException.class, () -> {
            fieldTest.open();
        });
    }

    @Test
    void openFieldOpenedTrueMarkedTrueMinedFalseTest() {

        fieldTest.open();
        fieldTest.alterMarked();
        assertFalse(fieldTest.open());
    }

    @Test
    void openFieldOpenedFalseMarkedTrueMinedTrueTest() {

        fieldTest.alterMarked();
        fieldTest.setMined(true);
        assertFalse(fieldTest.open());
    }

    @Test
    void openFieldOpenedTrueMarkedFalseMinedTrueTest() {

        fieldTest.open();
        fieldTest.setMined(true);
        assertFalse(fieldTest.open());
    }
    
    @Test
    void safeNeighbourNotMinedTest(){
        Field field2 = new Field(false, false, false, 0, 0);
        Field field3 = new Field(false, false, false, 0, 1);
        Field field4 = new Field(false, false, false, 0, 2);
        Field field5 = new Field(false, false, false, 1, 0);
        Field field6 = new Field(false, false, false, 1, 2);
        Field field7 = new Field(false, false, false, 2, 0);
        Field field8 = new Field(false, false, false, 2, 1);
        Field field9 = new Field(false, false, false, 2, 2);
        
        fieldTest.addNeighbour(field2);
        fieldTest.addNeighbour(field3);
        fieldTest.addNeighbour(field4);
        fieldTest.addNeighbour(field5);
        fieldTest.addNeighbour(field6);
        fieldTest.addNeighbour(field7);
        fieldTest.addNeighbour(field8);
        fieldTest.addNeighbour(field9);
        
        assertTrue(fieldTest.safeNeighbour());
    }
    
    @Test
    void safeNeighbourMinedTest(){
        Field field2 = new Field(true, false, false, 0, 0);
        Field field3 = new Field(false, false, false, 0, 1);
        Field field4 = new Field(true, false, false, 0, 2);
        Field field5 = new Field(false, false, false, 1, 0);
        Field field6 = new Field(true, false, false, 1, 2);
        Field field7 = new Field(false, false, false, 2, 0);
        Field field8 = new Field(true, false, false, 2, 1);
        Field field9 = new Field(false, false, false, 2, 2);
        
        fieldTest.addNeighbour(field2);
        fieldTest.addNeighbour(field3);
        fieldTest.addNeighbour(field4);
        fieldTest.addNeighbour(field5);
        fieldTest.addNeighbour(field6);
        fieldTest.addNeighbour(field7);
        fieldTest.addNeighbour(field8);
        fieldTest.addNeighbour(field9);
        
        assertFalse(fieldTest.safeNeighbour());
    }
}
