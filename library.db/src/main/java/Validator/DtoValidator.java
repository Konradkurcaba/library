package Validator;

public class DtoValidator {

    public void checkNull(String text) throws RuntimeException{
        if( text == null || text.isEmpty() || text.equals(" ") ){
            throw new RuntimeException("Wprowadzone dane są puste! Popraw i spróbuj ponownie!");
        }
    }
    public void checkSmallFirstLetters(String text) throws RuntimeException{
        checkNull(text);
        String pattern = "([A-Z][a-z]*)+";
        if(!text.matches(pattern)){
            throw new RuntimeException("Wprowadzone dane zaczynają się z małej litery! Popraw i spróbuj ponownie!");
        }
    }

    public void checkNumber(String number){
        checkNull(number);
        String pattern = "[0-9]*";
        if(!number.matches(pattern)){
            throw new RuntimeException("Wprowadzone dane nie są cyframi! Popraw i spróbuj ponownie!");
        }
    }

    public void checkISBN(String isbn){
        checkNull(isbn);
        String pattern = "[0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*[-| ][0-9]*";
        if(!isbn.matches(pattern)){
            throw new RuntimeException("Niepoprawny format ISBN! Popraw i spróbuj ponownie!");
        }
    }

    public void checkDate(String date){
        checkNull(date);
        String pattern = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        if(!date.matches(pattern)){
            throw new RuntimeException("Niepoprawny format daty! Popraw i spróbuj ponownie!");
        }
    }

    public void checkEmail(String email){
        checkNull(email);
        String pattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        if(!email.matches(pattern)){
            throw new RuntimeException("Niepoprawny format email! Popraw i spróbuj ponownie!");
        }
    }

    public void checkTelephone(String telephone){
        checkNull(telephone);
        String pattern = "[1-9][0-9]{8}";
        if(!telephone.matches(pattern)){
            throw new RuntimeException("Niepoprawny format numeru telefonu! Popraw i spróbuj ponownie!");
        }
    }

    public void checkZipCode(String text){
        checkNull(text);
        String pattern = "[0-9]{2}-[0-9]{3}";
        if(!text.matches(pattern)){
            throw new RuntimeException("Niepoprawny format kodu pocztowego! Popraw i spróbuj ponownie!");
        }
    }




}
