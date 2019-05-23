package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DtoValidator {

    private boolean found = false;

    public void checkNull(String text) throws RuntimeException{
        if( text == null || text.isEmpty() || text.equals(" ") ){
            throw new RuntimeException("Wprowadzone dane są puste! Popraw i spróbuj ponownie!");
        }
    }
    public void checkSmallFirstLetters(String text) throws RuntimeException{
        checkNull(text);
        Pattern pattern = Pattern.compile("([A-Z]{1}[a-z]*)+");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            found = true;
        }
        if(!found){
            throw new RuntimeException("Wprowadzone dane zaczynają się z małej litery! Popraw i spróbuj ponownie!");
        }
    }

    public void checkNumber(String number){
        checkNull(number);
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher matcher = pattern.matcher(number);
        while(matcher.find()){
            found = true;
        }
        if(!found){
            throw new RuntimeException("Wprowadzone dane nie są cyframi! Popraw i spróbuj ponownie!");
        }
    }

    public void checkISBN(String isbn){
        checkNull(isbn);
        Pattern pattern = Pattern.compile("[0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*");
        Matcher matcher = pattern.matcher(isbn);
        while(matcher.find()){
            found = true;
        }
        if(!found){
            throw new RuntimeException("Niepoprawny format ISBN! Popraw i spróbuj ponownie!");
        }
    }

    public void checkDate(String date){
        checkNull(date);
        Pattern pattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
        Matcher matcher = pattern.matcher(date);
        while(matcher.find()){
            found = true;
        }
        if(!found){
            throw new RuntimeException("Niepoprawny format daty! Popraw i spróbuj ponownie!");
        }
    }

    public void checkEmail(String email){
        checkNull(email);
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
        Matcher matcher = pattern.matcher(email);
        while(matcher.find()){
            found = true;
        }
        if(!found){
            throw new RuntimeException("Niepoprawny format email! Popraw i spróbuj ponownie!");
        }
    }

    public void checkTelephone(String telephone){
        checkNull(telephone);
        Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{8}");
        Matcher matcher = pattern.matcher(telephone);
        while(matcher.find()){
            found = true;
        }
        if(!found){
            throw new RuntimeException("Niepoprawny format numeru telefonu! Popraw i spróbuj ponownie!");
        }
    }

    public void checkZipCode(String text){
        checkNull(text);
        Pattern pattern = Pattern.compile("[0-9]{2}-[0-9]{3}");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            found = true;
        }
        if(!found){
            throw new RuntimeException("Niepoprawny format kodu pocztowego! Popraw i spróbuj ponownie!");
        }
    }




}
