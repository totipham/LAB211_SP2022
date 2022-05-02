/*
 * Copyright 2022 DucPTMHE160517
 */

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author DucPTMHE160517
 */
class Ebank {

    void checkLogin(Locale locale) {
        String account, password, inputCaptcha, systemCaptcha, resultMessage;
        boolean checkFlag = true;
        Input input = new Input();
        AccountList accountList = new AccountList();
        ResourceBundle bundle = ResourceBundle.getBundle("language", locale);

        account = input.getString(bundle.getString("account.input"), "account",
                bundle.getString("account.warning"));
        password = input.getString(bundle.getString("password.input"), "password",
                bundle.getString("password.warning"));
        
        do {

            //Check if check flag is false
            if (!checkFlag) {
                System.out.println(bundle.getString("captcha.wrong"));
                checkFlag = true;
            }

            systemCaptcha = generateCaptcha();
            System.out.println(bundle.getString("captcha").concat(systemCaptcha));
            
            inputCaptcha = input.getString(bundle.getString("captcha.input"),
                    "captcha", bundle.getString("captcha.wrong"));
            
            checkFlag = isValidCaptcha(inputCaptcha, systemCaptcha);

        } while (!checkFlag); //Loop while check flag is false

        //Check if account & password is a valid information
        if (accountList.isValidInformation(account, password)) {
            resultMessage = bundle.getString("login.successful");
        } else {
            resultMessage = bundle.getString("login.unsuccessful");
        }

        System.out.println(resultMessage);
    }

    private String generateCaptcha() {
        int randomNumber, randomChoice, length = 5;
        boolean hasNumber = false, hasLowerCase = false, hasUpperCase = false;
        boolean flagCheck = false;
        StringBuilder captchaResult;
        Random random = new Random();

        do {
            hasNumber = false;
            hasLowerCase = false;
            hasUpperCase = false;
            captchaResult = new StringBuilder();

            //Loop from i which equals 0 to length's value
            for (int i = 0; i < length; i++) {
                randomNumber = random.nextInt(25);
                randomChoice = random.nextInt(3) + 1;

                switch (randomChoice) {
                    case 1:
                        randomNumber = randomNumber % 10 + 48;
                        hasNumber = true;
                        break;
                    case 2:
                        randomNumber += 65;
                        hasUpperCase = true;
                        break;
                    case 3:
                        randomNumber += 97;
                        hasLowerCase = true;
                        break;
                }

                captchaResult.append((char) randomNumber);
            }

            flagCheck = hasNumber && hasLowerCase && hasUpperCase;
            
        } while (!flagCheck); //Loop while flag check is false

        return captchaResult.toString();
    }

    private boolean isValidCaptcha(String captchaInput, String captchaGenerate) {

        //Check if input captcha equals generated captcha
        if (captchaInput.equals(captchaGenerate)) {
            return true;
        }

        return false;
    }

}
