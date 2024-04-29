package com.forUMC.global.exception.handler;

import com.forUMC.global.apiPayLoad.code.BaseErrorCode;
import com.forUMC.global.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}
