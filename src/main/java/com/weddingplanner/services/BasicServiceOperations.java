package com.weddingplanner.services;

import com.weddingplanner.exceptions.ItemNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@Getter
@RequiredArgsConstructor
public class BasicServiceOperations {

    protected Supplier<RuntimeException> itemNotFound(String str) {
        return () -> new ItemNotFoundException(str);
    }
}