package models;
//import

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpTest {


    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();


    @Test
    public void getNameReturnsCorrectName() throws Exception{
        SignUp testSignUp = setupSignUp();
        assertEquals("name", testSignUp.getName());
    }
    @Test
    public void setNameSetsCorrectName() throws Exception{
        SignUp testSignUp= setupSignUp();
        testSignUp.setName("name");
        assertNotEquals("pr",testSignUp.getName());
    }
    @Test
    public void getEmailReturnsCorrectEmail() throws Exception{
        SignUp testSignUp = setupSignUp();
        assertEquals("km@gm",testSignUp.getEmail());
    }
    @Test
    public void setEmailSetsCorrectEmail() throws Exception{
        SignUp testSignUp = setupSignUp();
        testSignUp.setEmail("km@gm");
        assertNotEquals("kq",testSignUp.getEmail());
    }
    @Test
    public void getPasswordReturnsCorrectPassword() throws Exception{
        SignUp testSignUp = setupSignUp();
        assertEquals("password", testSignUp.getPassword());
    }
    @Test
    public void setPasswordSetsCorrectPassword() throws Exception{
        SignUp testSignUp = setupSignUp();
        testSignUp.setPassword("password");
        assertNotEquals("22", testSignUp.getPassword());

    }
    @Test
    public void getIdReturnsCorrectId() throws Exception{
        SignUp testSignUp = setupSignUp();
        testSignUp.save();
        int id = testSignUp.getId();
        assertEquals(id, testSignUp.getId());
    }
    @Test
    public void setIdSetsCorrectId() throws Exception{
        SignUp testSignUp = setupSignUp();
        testSignUp.setId(1);
        assertNotEquals("string", testSignUp.getId());
    }

    //helper

    public SignUp setupSignUp(){ return new SignUp("name","km@gm","password");}


    @Test
    public void save() {
        SignUp user = setupSignUp();
        user.save();
        assertTrue(SignUp.all().contains(user));
    }

    @Test
    public void all() {
        SignUp user = setupSignUp();
        user.save();
        SignUp another = setupSignUp();
        another.save();
        assertTrue(SignUp.all().contains(another));
        assertTrue(SignUp.all().contains(user));
    }
}