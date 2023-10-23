package com.test.api.marvelchallenge.service;

import java.util.Map;

public interface HttpClientService {

    <T> T doGet(String endPoint, Map<String, String> queryParams, Class<T> responseType);
    <T, R> T doPost(String endPoint, Map<String, String> queryParams, Class<T> responseType, R bodyRequest);
    <T, R> T doPut(String endPoint, Map<String, String> queryParams, Class<T> responseType, R bodyRequest);
    <T> T doDelete(String endPoint, Map<String, String> queryParams, Class<T> responseType);
}