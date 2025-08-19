package com.example.cheko_app.dto;

import com.example.cheko_app.enums.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse<T> implements Serializable {

    private Integer statusCode;
    private String msgArabic;
    private String msgEnglish;
    private String source;
    private T data;
    private List<String> errors;

    public static <T> ResponseEntity<ApiResponse<T>> getSuccessResponse() {
        return getResponse(ResponseStatus.SUCCESS, null, null, null, Collections.emptyList(), HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> getSuccessResponse(T data) {
        return getResponse(ResponseStatus.SUCCESS, null, null, data, Collections.emptyList(), HttpStatus.OK);
    }

    private static <T> ResponseEntity<ApiResponse<T>> getResponse(ResponseStatus responseStatus, Object[] messageArgs, String source, T data,
                                                                  List<String> errors, HttpStatus httpStatus) {


        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(responseStatus.getCode());
        String messageAr = responseStatus.getMessage();

        if (messageArgs != null && messageArgs.length > 0) {
            messageAr = MessageFormat.format(messageAr, messageArgs);
        }
        response.setMsgArabic(messageAr);
        response.setMsgEnglish(responseStatus.getMessageEn());
        response.setSource(source);
        response.setData(data);
        response.setErrors(errors);

        return new ResponseEntity<>(response, httpStatus);
    }

}
