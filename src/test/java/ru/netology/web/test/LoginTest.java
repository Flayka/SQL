package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

class LoginTest {

    @AfterAll
   public static void CleanAllTables() {
        DataHelper.cleanTables();
    }

    @Test
    void shouldCorrectLogin() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor();
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.DashboardPage();
    }

    @Test
    void shouldErrorIfInvalidLogin() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getInvalidLogin();
        loginPage.invalidLogin(authInfo);
    }

    @Test
    void shouldErrorIfInvalidPassword() {
        val loginPage = open("http://localhost:9999", LoginPage.class);
        val authInfo = DataHelper.getInvalidPassword();
        loginPage.invalidLogin(authInfo);
    }
}
