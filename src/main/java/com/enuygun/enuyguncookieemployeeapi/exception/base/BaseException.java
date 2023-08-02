package com.enuygun.enuyguncookieemployeeapi.exception.base;

import org.slf4j.*;

public abstract class BaseException extends RuntimeException {

    protected final Logger log = LoggerFactory.getLogger(BaseException.class);

    protected BaseException(String message) {
        super(message);
    }
}
