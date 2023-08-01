package com.enuygun.enuyguncookieemployeeapi.exception.base;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.*;

@Slf4j
public abstract class BaseException extends RuntimeException {

    protected final Logger LOG = LoggerFactory.getLogger(BaseException.class);

    protected BaseException(String message) {
        super(message);
    }
}
