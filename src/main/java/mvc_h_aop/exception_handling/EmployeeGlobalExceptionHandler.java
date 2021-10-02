package mvc_h_aop.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeIncorrectData> handleException(NoSuchEmployeeException noSuchEmployeeException){
        EmployeIncorrectData  data = new EmployeIncorrectData();
        data.setInfo(noSuchEmployeeException.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeIncorrectData> handleException(Exception exception){
        EmployeIncorrectData  data = new EmployeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}