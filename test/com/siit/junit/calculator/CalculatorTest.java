package com.siit.junit.calculator;

import com.siit.junit.applicationexception.ApplicationException;
import com.siit.junit.measurementunits.MeasurementUnits;
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private Calculator calculator1;
    private Calculator calculator2;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() throws ApplicationException {
        System.out.println("In setUp");
    }

    @After
    public void tearDown() throws ApplicationException {
        System.out.println("In tearDown");
    }

    @Test
    public void testAddAndSubstractionWhenOperandsInMMAndCMAndMAndResultInMM() throws ApplicationException {
        calculator1 = new Calculator("10 cm + 1 m - 10 mm", MeasurementUnits.MM);
        assertThat(calculator1.calculate(), is(1090.0));
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsACharacterDifferentFrom0_9_Or_MCDK() throws ApplicationException {
        calculator1 = new Calculator("10 cm + 1 m - 10 mmq", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test
    public void testAddAndSubstractionWhenOperandsAndResultInMM() throws ApplicationException {
        calculator1 = new Calculator("10 mm + 100 mm - 100 mm", MeasurementUnits.MM);
        assertThat(calculator1.calculate(),is(10.0));
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsTwoConsecutiveAddSigns() throws ApplicationException {
        calculator1 = new Calculator("10 mm ++ 100 mm - 100 mm", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsTwoConsecutiveSubstractionSigns() throws ApplicationException {
        calculator1 = new Calculator("10 mm -- 100 mm - 100 mm", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsDifferentUnitsFromMM() throws ApplicationException {
        calculator1 = new Calculator("10 mmm - 100 mm - 100 mm", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsDifferentUnitsFromCM() throws ApplicationException {
        calculator1 = new Calculator("10 ccm - 100 mm - 100 mm", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsDifferentUnitsFromDM() throws ApplicationException {
        calculator1 = new Calculator("10 cdm - 100 mm - 100 mm", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsDifferentUnitsFromM() throws ApplicationException {
        calculator1 = new Calculator("10 zm - 100 mm - 100 mm", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test(expected = ApplicationException.class)
    public void testInputContainsDifferentUnitsFromKM() throws ApplicationException {
        calculator1 = new Calculator("10 kma - 100 mm - 100 mm", MeasurementUnits.MM);
        calculator1.calculate();
    }

    @Test
    public void testAddWhenOperandsAndResultInMM() throws ApplicationException {
        calculator1 = new Calculator("10 mm + 100 mm + 100 mm", MeasurementUnits.MM);
        assertThat(calculator1.calculate(), is(210.0));
    }

    @Test
    public void testAddWhenOperandsInMMAndResultInCM() throws ApplicationException {
        calculator1 = new Calculator("10 mm + 100 mm + 100 mm", MeasurementUnits.CM);
        assertThat(calculator1.calculate(), is(21.0));
    }

    @Test
    public void testAddWhenOperandsInMMAndResultInDM() throws ApplicationException {
        calculator1 = new Calculator("10 mm + 100 mm + 100 mm", MeasurementUnits.DM);
        assertThat(calculator1.calculate(), is(2.1));
    }

    @Test
    public void testAddWhenOperandsInMMAndResultInM() throws ApplicationException {
        calculator1 = new Calculator("10 mm + 100 mm + 100 mm", MeasurementUnits.M);
        assertThat(calculator1.calculate(), is(0.21));
    }

    @Test
    public void testAddWhenOperandsInMMAndResultInKM() throws ApplicationException {
        calculator1 = new Calculator("10 mm + 100 mm + 100 mm", MeasurementUnits.KM);
        assertThat(calculator1.calculate(), is(0.00021));
    }

    @Test
    public void testSubstractionWhenOperandsAndResultInMM() throws ApplicationException {
        calculator1 = new Calculator("10 mm - 100 mm - 100 mm", MeasurementUnits.MM);
        assertThat(calculator1.calculate(), is(-190.0));
    }

    @Test
    public void testAddAndSubstractionWhenOperandsAndResultInCM() throws ApplicationException {
        calculator1 = new Calculator("10 cm + 100 cm - 100 cm", MeasurementUnits.CM);
        assertThat(calculator1.calculate(), is(10.0));
    }

    @Test
    public void testAddWhenOperandsAndResultInCM() throws ApplicationException {
        calculator1 = new Calculator("10 cm + 100 cm + 100 cm", MeasurementUnits.CM);
        assertThat(calculator1.calculate(), is(210.0));
    }

    @Test
    public void testSubstractionWhenOperandsAndResultInCM() throws ApplicationException {
        calculator1 = new Calculator("10 cm - 100 cm - 100 cm", MeasurementUnits.CM);
        assertThat(calculator1.calculate(), is(-190.0));
    }

    @Test
    public void testAddAndSubstractionWhenOperandsAndResultInDM() throws ApplicationException {
        calculator1 = new Calculator("10 dm + 100 dm - 100 dm", MeasurementUnits.DM);
        assertThat(calculator1.calculate(), is(10.0));
    }

    @Test
    public void testAddWhenOperandsAndResultInDM() throws ApplicationException {
        calculator1 = new Calculator("10 dm + 100 dm + 100 dm", MeasurementUnits.DM);
        assertThat(calculator1.calculate(), is(210.0));
    }

    @Test
    public void testSubstractionWhenOperandsAndResultInDM() throws ApplicationException {
        calculator1 = new Calculator("10 dm - 100 dm - 100 dm", MeasurementUnits.DM);
        assertThat(calculator1.calculate(), is(-190.0));
    }

    @Test
    public void testAddAndSubstractionWhenOperandsAndResultInM() throws ApplicationException {
        calculator1 = new Calculator("10 m + 100 m - 100 m", MeasurementUnits.M);
        assertThat(calculator1.calculate(), is(10.0));
    }

    @Test
    public void testAddWhenOperandsAndResultInM() throws ApplicationException {
        calculator1 = new Calculator("10 m + 100 m + 100 m", MeasurementUnits.M);
        assertThat(calculator1.calculate(), is(210.0));
    }

    @Test
    public void testSubstractionWhenOperandsAndResultInM() throws ApplicationException {
        calculator1 = new Calculator("10 m - 100 m - 100 m", MeasurementUnits.M);
        assertThat(calculator1.calculate(), is(-190.0));
    }

    @Test
    public void testAddAndSubstractionWhenOperandsAndResultInKM() throws ApplicationException {
        calculator1 = new Calculator("10 km + 100 km - 100 km", MeasurementUnits.KM);
        assertThat(calculator1.calculate(), is(10.0));
    }

    @Test
    public void testAddWhenOperandsAndResultInKM() throws ApplicationException {
        calculator1 = new Calculator("10 km + 100 km + 100 km", MeasurementUnits.KM);
        assertThat(calculator1.calculate(), is(210.0));
    }

    @Test
    public void testSubstractionWhenOperandsAndResultInKM() throws ApplicationException {
        calculator1 = new Calculator("10 km - 100 km - 100 km", MeasurementUnits.KM);
        assertThat(calculator1.calculate(), is(-190.0));
    }
}