package com.digitalvotingpass.digitalvotingpass;

import net.sf.scuba.data.Gender;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rico on 2-6-17.
 */

public class TestPerson {

    private String frontName = "Tom";
    private String lastName = "de Vries";

    private Gender[] genders  = new Gender[] { Gender.getInstance(Gender.MALE.toInt()),
            Gender.getInstance(Gender.FEMALE.toInt()),
            Gender.getInstance(Gender.UNSPECIFIED.toInt()),
            Gender.getInstance(Gender.UNKNOWN.toInt()) };
    private String[] genderStrings = new String[] { "Mr", "Ms", "unspecified", "unknown"} ;

    private Person person;

    @Test
    public void testGetters() {
        person = new Person(frontName, lastName, genders[0]);
        assertEquals(frontName, person.getFrontName());
        assertEquals(lastName, person.getLastName());
        assertEquals(genders[0].toInt(), person.getGender().toInt());
    }

    @Test
    public void testSetters() {
        person = new Person();
        person.setFrontName(frontName);
        person.setLastName(lastName);
        person.setGender(genders[0]);
        assertEquals(frontName, person.getFrontName());
        assertEquals(lastName, person.getLastName());
        assertEquals(genders[0].toInt(), person.getGender().toInt());
    }

    @Test
    public void testGenderStrings() {
        person = new Person();
        person.setGenderStrings(genderStrings[0], genderStrings[1], genderStrings[2], genderStrings[3]);
        for(int i=0; i< genders.length; i++) {
            person.setGender(genders[i]);
            assertEquals(genderStrings[i], person.genderToString());
        }
    }

    @Test
    public void testLastName1() {
        String lName = "VAN DE VORst";
        String expextedLName = "van de Vorst";
        person = new Person(frontName, lName, genders[0]);
        assertEquals(expextedLName, person.getLastName());
    }

    @Test
    public void testLastName2() {
        String lName = "VorsT";
        String expextedLName = "Vorst";
        person = new Person(frontName, lName, genders[0]);
        assertEquals(expextedLName, person.getLastName());
    }

}
