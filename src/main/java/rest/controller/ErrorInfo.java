package rest.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorInfo {
    private final String url;
    private final String error;
}
