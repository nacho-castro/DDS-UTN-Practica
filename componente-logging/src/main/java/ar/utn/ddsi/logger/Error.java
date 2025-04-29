package ar.utn.ddsi.logger;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private String message;
    private String stackTrace;
    private LocalDateTime timestamp;

    public static Error of(String message){
        return Error.builder()
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }

    //sobrecarga de metodos
    public static Error of(String message, String stacktrace){
        return Error.builder()
                .message(message)
                .stackTrace(stacktrace)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public static Error of(String message, String stacktrace, LocalDateTime timestamp){
        Error error = new Error();
        error.setMessage(message);
        error.setStackTrace(stacktrace);
        error.setTimestamp(timestamp);
        return error;
    }
}
